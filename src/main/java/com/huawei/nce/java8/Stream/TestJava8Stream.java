package com.huawei.nce.java8.Stream;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.huawei.nce.pojo.*;

import org.junit.jupiter.api.Test;
import org.springframework.util.CollectionUtils;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * TODO
 *
 * @author Administrator
 * @date 2020/9/12 13:26
 */
public class TestJava8Stream {
    private static final List<Product> productList;

    static {
        productList = Lists.newArrayList(
                new Product("红色商品", "红色", 6000D, 1),
                new Product("蓝色商品", "蓝色", 7000D, 2),
                new Product("黄色商品", "黄色", 6000D, 3));
    }

    // 流的创建
    @Test
    public void test1_1() {
        Product product1 = new Product().builder().color("紫色").name("紫罗兰").num(2).price(666D).build();
        // 1.使用Collection的stream()或者parallelStream()
        System.out.println("Collection的stream()=======================");
        productList.stream().forEach(System.out::println);
        System.out.println("Collection的parallelStream() ==========================");
        Stream<Product> parallelStream = productList.parallelStream();
        parallelStream.forEach(System.out::println);
        // 2.使用Arrays的stream()方法
        System.out.println("Arrays的stream()操作=============================");
        Integer[] integers = {1, 2, 3, 4, 5};
        Arrays.stream(integers).forEach(System.out::println);
        // 3.使用Stream的静态方法 of() iterate() generate()
        System.out.println("Stream的静态方法of() ===================================");
        Stream.of("Plugins", "bb", "cc").forEach(System.out::println);
        System.out.println("Stream的静态方法 iterate() =============================");
        Stream.iterate(0, (x) -> x + 2).limit(5).forEach(System.out::println);
        System.out.println("Stream的静态方法 generate() ==================");
        Stream.generate(Math::random).limit(5).forEach(System.out::println);
    }

    // 流的创建
    @Test
    public void test1_2() {
        // 4.使用BufferedReader.lines()方法
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\aaa.txt"))) {
            System.out.println("BufferedReader.lines() 方法 ==============================");
            bufferedReader.lines().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 5.使用Pattern.splitAsStream()方法 将字符串分割成流
        System.out.println("Pattern.splitAsStream()方法,=======================");
        Pattern.compile(",").splitAsStream("a,b,c,d,e,f").forEach(System.out::println);
    }

    // 流的中间操作
    @Test
    public void test2_1() {
        // 1.筛选与切片 即filter(),limit() skip() ,distinct()
        Stream.of(1, 2, 3, 4, 5, 5, 4, 3, 2, 1, 10, 12, 14, 14).filter((x) -> x >= 5).distinct()
                .skip(2).limit(2).forEach(System.out::println);
        // 2.映射1 即map()
        Arrays.asList("a,b,c", "1,2,3").stream().map(str -> {
            return str.replaceAll(",", "");
        })
                .forEach(System.out::println);
        // 3. 映射2 flatMap() 将流中的每一个元素转化为一个stream,然后将所有流连接成一个流
        Arrays.asList("a,b,c", "1,2,3").stream().flatMap((str) -> {
            String[] strArr = str.split(",");
            Stream<String> stream = Arrays.stream(strArr);
            return stream;
        });
    }

    // 流的中间操作
    @Test
    public void test2_2() {
        // 3.排序 即sorted()
        List<Student> studentList = Lists.newArrayList(
                new Student(4, "tangyan", 18),
                new Student(2, "huojianhua", 20),
                new Student(1, "huge", 19),
                new Student(3, "yangmi", 20),
                new Student(5, "huge", 30)
        );
        //自定义排序,先按照姓名排序,再按照年龄排序
        //自定义排序,sorted方法中里面要传一个Compartor接口的实现类实例 ,
        // 重写compare方法或者调用Comparator.comparing的静态方法
        System.out.println("重写compare()方法 ========================");
        studentList.stream().sorted((o1, o2) -> {
            if (o1.getName().equals(o2.getName())) {
                return o1.getAge() - o2.getAge();
            } else {
                return o1.getName().compareTo(o2.getName());
            }
        }).forEach(System.out::println);
        //按照年龄正序排序,再按照id正序排序
        System.out.println("调用Comparator.comparing()静态方法,多重排序一 ======================");
        studentList.stream()
                .sorted(Comparator.comparing(Student::getAge).thenComparing(Student::getId))
                .forEach(System.out::println);
        // 按照年龄正序排序,再按照id倒叙排序
        System.out.println("多重排序二 ==================================");
        studentList.stream().sorted(Comparator.comparing(Student::getId).reversed())
                .sorted(Comparator.comparing(Student::getAge)).forEach(System.out::println);
    }

    // 流的中间操作
    @Test
    public void test2_3() {
        // 4.消费 即peek()
        List<Student> studentList = Lists.newArrayList(
                new Student(4, "tangyan", 18),
                new Student(2, "huojianhua", 20),
                new Student(1, "huge", 19),
                new Student(3, "yangmi", 20),
                new Student(5, "huge", 30)
        );
        // 和map类似,能够得到流中的每一个元素,但是map接收的是一个Funcation 函数式接口表达式
        //而peek()接收的是一个ConSumer 消费式接口表达式
        studentList.stream().peek(student -> student.setAge(500)).forEach(System.out::println);
    }

    // 流的终止操作
    @Test
    public void test3_1() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        // 1.匹配聚合操作
        System.out.println("allMath 流中的每一个元素都符合断言表达式才返回true: " +
                integerList.stream().allMatch(element -> element < 4));
        System.out.println("noneMatch 流中的每一个元素都不符合断言表达式才返回true: " +
                integerList.stream().noneMatch(element -> element > 5));
        System.out.println("anyMatch() 流中只要有一个元素符合断言表达式就返回true: " +
                integerList.stream().anyMatch(element -> element >= 5));
        System.out.println("findFirst 返回流中第一个元素: " +
                integerList.stream().findFirst().get());
        System.out.println("findAny 返回流中任意一个元素: " +
                integerList.stream().findAny().get());
        System.out.println("返回流中元素总个数: " +
                integerList.stream().count());
        System.out.println("返回流中元素的最大值: " +
                integerList.stream().max(Integer::compareTo).get());
        System.out.println("返回流中元素的最小值: " +
                integerList.stream().min(Integer::compareTo).get());
    }

    // 流的终止操作
    @Test
    public void test3_2() {
        // 1.匹配集合操作
        // 2.规约操作 将流中的元素反复结合起来,得到一个值
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
                22, 23, 24);
        Integer integer1 = list.stream().reduce((x1, x2) -> x1 + x2).get();
        System.out.println("integer1 = " + integer1);
        Integer integer2 = list.stream().reduce(10, (x1, x2) -> x1 + x2);
        System.out.println("integer2 = " + integer2);
    }

    // 流的终止操作
    @Test
    public void test3_3() {
        // 3.收集操作
        List<Animal> animalList = Lists.newArrayList(
                new Animal("大象", 10, 1),
                new Animal("乌龟", 20, 2),
                new Animal("老鹰", 10, 3));
        // 1. 收集成一个list
        System.out.println("收集成一个list: " + animalList.stream().collect(Collectors.toList()));
        // 2.收集成一个set
        System.out.println("收集成一个set: " + animalList.stream().collect(Collectors.toSet()));
        // 3.收集成一个map (其中这个key不能相同.否则会报错)
        System.out.println("收集成一个map: " +
                animalList.stream().collect(Collectors.toMap(Animal::getName, Animal::getAge)));
        // 4.收集成一个以指定分隔符分隔的字符串
        System.out.println("收集成一个以指定分隔符分隔的字符串: " +
                animalList.stream().map(Animal::getName).collect(Collectors.joining(",")));
        // 5.集合操作,获取集合中最大的元素,最小的元素,元素总个数,元素值的和,元素值得平均值
        System.out.println("集合中的最大元素 :" +
                animalList.stream().map(Animal::getAge).collect(Collectors.maxBy(Integer::compareTo)));
        System.out.println("集合中的最小元素 :" +
                animalList.stream().map(Animal::getAge).collect(Collectors.minBy(Integer::compareTo)).get());
        System.out.println("集合中的元素总个数: " +
                animalList.stream().collect(Collectors.counting()));
        System.out.println("集合中元素的和: " +
                animalList.stream().collect(Collectors.summingInt(Animal::getAge)));
        System.out.println("集合中元素的平均值: " +
                animalList.stream().collect(Collectors.averagingDouble(Animal::getAge)));
        //带上以上所以的方法
        DoubleSummaryStatistics collect = animalList.stream().collect(Collectors.summarizingDouble(Animal::getAge));
        System.out.println("max: " + collect.getMax() + " min: " + collect.getMin() + " count: " + collect.getCount()
                + " sum: " + collect.getSum() + " avg: " + collect.getAverage());
        // 6.分组1
        System.out.println("分组");
        Map<Integer, List<Animal>> collect1 = animalList.stream().collect(Collectors.groupingBy(Animal::getAge));
        for (Map.Entry<Integer, List<Animal>> integerListEntry : collect1.entrySet()) {
            for (Animal animal : integerListEntry.getValue()) {
                System.out.println(animal);
            }
        }
        // 分组2 多重分组
        System.out.println("多重分组");
        Map<Integer, Map<Integer, List<Animal>>> collect2 =
                animalList.stream().collect(Collectors.groupingBy(Animal::getType,
                        Collectors.groupingBy(Animal::getAge)));
        for (Map.Entry<Integer, Map<Integer, List<Animal>>> integerMapEntry : collect2.entrySet()) {
            System.out.println("integerMapEntry: " + integerMapEntry);
            for (Map.Entry<Integer, List<Animal>> integerListEntry : integerMapEntry.getValue().entrySet()) {
                for (Animal animal : integerListEntry.getValue()) {
                    System.out.println("animal: " + animal);
                }
            }
        }
        // 7.分区
        Map<Boolean, List<Animal>> collect3 =
                animalList.stream().collect(Collectors.partitioningBy(vv -> vv.getAge() > 10));
        for (Map.Entry<Boolean, List<Animal>> booleanListEntry : collect3.entrySet()) {
            for (Animal animal : booleanListEntry.getValue()) {
                System.out.println("分区：" + animal);
            }
        }
        // 8.规约
        System.out.println("规约allAge: " + animalList.stream().map(Animal::getAge).collect(Collectors.reducing(Integer::sum)).get());
    }

    @Test
    public void testDistinct() {
        List<NeInterface> neInterfaces = Lists.newArrayList(new NeInterface(null, "GE4/2/1", "GE"),
                new NeInterface(null, "GE4/2/1", "GE"),
                new NeInterface(null, "FE4/2/1", "GE")
        );
        List<NeInterface> collect = neInterfaces.stream().distinct().collect(Collectors.toList());
        collect.stream().forEach(System.out::println);
    }

    @Test
    public void testDistinct2() {
        List<NeInterface> neInterfaces = Lists.newArrayList(
                new NeInterface(null, "GE4/2/1", "GE"),
                new NeInterface(null, "GE4/2/1", "GE"),
                new NeInterface(null, "FE4/2/1", "GE")
        );
        List<NeInterface> distinctedNeInterfaceList =
                neInterfaces.stream().collect(Collectors.collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(NeInterface::getIfName))),
                        ArrayList::new));
        distinctedNeInterfaceList.stream().forEach(System.out::println);
    }

    @Test
    public void testProtocolCheck() {
        Map<String, List<Map<String, Object>>> dataMap2 = new HashMap<>();
        Map<String, List<Map<String, Object>>> dataMap3 = new HashMap<>();
        Map<String, List<ProtocolRule>> groupedProtocolRule = new HashMap<>();
//        for (Map.Entry<String, ProtocolRule> stringProtocolRuleEntry : groupedProtocolRule.entrySet()) {
//            String key = stringProtocolRuleEntry.getKey();
//            ProtocolRule value = stringProtocolRuleEntry.getValue();
//        }
        for (Map.Entry<String, List<ProtocolRule>> stringListEntry : groupedProtocolRule.entrySet()) {
            // 要校验的页签的名称
            String sheetName = stringListEntry.getKey();
            // 该页签的下的所有要校验的列以及校验规则等信息.
            List<ProtocolRule> needCheckedColumnInfo = stringListEntry.getValue();
            // 先以页签的纬度校验
            for (Map.Entry<String, List<Map<String, Object>>> ddMapEntry : dataMap2.entrySet()) {
                if (sheetName.equals(ddMapEntry.getKey())) {
                    // 源网元dd表中校验页签下的数据
                    List<Map<String, Object>> sourceRows = ddMapEntry.getValue();
                    // 获取协议校验结果1(要判断是否为空)
                    List<ProtocolCheckResult> protocolCheckResult1 = getCheckResult1(dataMap3, sheetName,
                            needCheckedColumnInfo, sourceRows);
                    // 获取协议校验结果2(要判断是否为空)
                    List<ProtocolCheckResult> protocolCheckResult2 = getCheckResult2(dataMap3, sheetName,
                            needCheckedColumnInfo, sourceRows);
                    // 排除源网元dd独有的行
                    sourceRows = excludeSrcDDUniqueRows(dataMap3, sheetName, sourceRows);
                    List<ProtocolCheckResult> protocolCheckResult3_4 = Lists.newArrayList();
                    for (Map<String, Object> row : sourceRows) {
                        String rowId = (String) row.get("ID");
                        List<Map<String, Object>> matchedRow = dataMap3.get(sheetName).stream()
                                .filter(rowMap -> rowId.equals(rowMap.get("ID"))).collect(Collectors.toList());
                        // 获取协议校验结果3和4
                        List<ProtocolCheckResult> oneRowProtocolCheckResult = checkProtocolData(sheetName,
                                needCheckedColumnInfo, row, matchedRow);
                        protocolCheckResult3_4.addAll(oneRowProtocolCheckResult);
                    }
                }
            }
        }
    }

    private List<ProtocolCheckResult> checkProtocolData(String sheetName, List<ProtocolRule> needCheckedColumnInfo,
                                                        Map<String, Object> row, List<Map<String, Object>> matchedRow) {
        List<ProtocolCheckResult> oneRowProtocolCheckResult = Lists.newArrayList();
        for (ProtocolRule protocolRule : needCheckedColumnInfo) {
            ProtocolCheckResult checkResult = ProtocolCheckResult.builder().
                    sheetName(sheetName).columnName(protocolRule.getColumnName())
                    .srcRowId((String) row.get("ID")).dstRowId((String) row.get("ID"))
                    .paramCheckRule(protocolRule.getParamCheckRule()).checkResult("not_equal").build();
            if (row.get(protocolRule.getColumnName()).equals(matchedRow.get(0).get(protocolRule.getColumnName()))) {
                checkResult = checkResult.toBuilder().checkResult("equal").build();
            }
            oneRowProtocolCheckResult.add(checkResult);
        }
        return oneRowProtocolCheckResult;
    }

    private List<Map<String, Object>> excludeSrcDDUniqueRows(Map<String, List<Map<String, Object>>> dataMap3,
                                                             String sheetName, List<Map<String, Object>> sourceRows) {
        List<Object> sourceDdUniqueRowIds = getSrcDdUniqueRowIds(dataMap3, sheetName, sourceRows);
        if (!CollectionUtils.isEmpty(sourceDdUniqueRowIds)) {
            sourceRows =
                    sourceRows.stream().filter(row -> !sourceDdUniqueRowIds.contains(row.get("ID"))).collect(Collectors.toList());
        }
        return sourceRows;
    }


    private List<ProtocolCheckResult> getCheckResult1(Map<String, List<Map<String, Object>>> dataMap3,
                                                      String sheetName, List<ProtocolRule> needCheckedColumnInfo,
                                                      List<Map<String, Object>> sourceRows) {
        List<ProtocolCheckResult> protocolCheckResult1 = null;
        List<Object> sourceDdUniqueRowIds = getSrcDdUniqueRowIds(dataMap3, sheetName, sourceRows);
        if (!CollectionUtils.isEmpty(sourceDdUniqueRowIds)) {
            protocolCheckResult1 = getMissingRowCheckResult(sheetName, needCheckedColumnInfo, sourceDdUniqueRowIds,
                    true);
        }
        return protocolCheckResult1;
    }

    private List<ProtocolCheckResult> getCheckResult2(Map<String, List<Map<String, Object>>> dataMap3,
                                                      String sheetName, List<ProtocolRule> needCheckedColumnInfo,
                                                      List<Map<String, Object>> sourceRows) {
        List<ProtocolCheckResult> protocolCheckResult2 = null;
        List<Object> sourceDdUniqueRowIds = getDstDdUniqueRowIds(dataMap3, sheetName, sourceRows);
        if (!CollectionUtils.isEmpty(sourceDdUniqueRowIds)) {
            protocolCheckResult2 = getMissingRowCheckResult(sheetName, needCheckedColumnInfo, sourceDdUniqueRowIds,
                    false);
        }
        return protocolCheckResult2;
    }

    private List<ProtocolCheckResult> getMissingRowCheckResult(String sheetName,
                                                               List<ProtocolRule> needCheckedColumnInfo,
                                                               List<Object> sourceDdUniqueRowIds, boolean flag) {
        List<ProtocolCheckResult> protocolCheckResult1 = Lists.newArrayList();
        // 遍历源网元所特有的若干条行记录.
        for (Object sourceDdUniqueRowId : sourceDdUniqueRowIds) {
            // 源网元校验的该页签有这一行数据.,目标网元校验的该页签没有这一行数据.
            List<ProtocolCheckResult> rowCheckResult = needCheckedColumnInfo.stream().map(protocolRule -> {
                ProtocolCheckResult protocolCheckResult = ProtocolCheckResult.builder().
                        sheetName(sheetName).columnName(protocolRule.getColumnName())
                        .srcRowId((String) sourceDdUniqueRowId).dstRowId((String) sourceDdUniqueRowId)
                        .paramCheckRule(protocolRule.getParamCheckRule()).checkResult(flag ?
                                "Target_ne_does_not_exist" : "Source_ne_does_not_exist").build();
                return protocolCheckResult;
            }).collect(Collectors.toList());
            protocolCheckResult1.addAll(rowCheckResult);
        }
        return protocolCheckResult1;
    }

    private List<Object> getSrcDdUniqueRowIds(Map<String, List<Map<String, Object>>> dataMap3, String sheetName,
                                              List<Map<String, Object>> sourceRows) {
        // 目标网元dd表中校验页签的行id
        List<Object> targetRowIds =
                dataMap3.get(sheetName).stream().map(row -> row.get("ID")).collect(Collectors.toList());
        // 源网元dd表中校验页签的所特有的行id
        return sourceRows.stream()
                .filter(row -> !targetRowIds.contains(row.get("ID"))).map(row -> row.get("ID")).collect(Collectors.toList());
    }

    private List<Object> getDstDdUniqueRowIds(Map<String, List<Map<String, Object>>> dataMap3, String sheetName,
                                              List<Map<String, Object>> sourceRows) {
        // 源网元dd表中校验页签的行id
        List<Object> sourceRowIds = sourceRows.stream().map(row -> row.get("ID")).collect(Collectors.toList());
        // 目标网元dd表中校验页签的所特有的行id
        return dataMap3.get(sheetName).stream()
                .filter(row -> !sourceRowIds.contains(row.get("ID"))).map(row -> row.get("ID")).collect(Collectors.toList());
    }

    @Test
    public void test666() {
        // 1.查询sqlite源DD表数据库中某一个数据表中的所有数据.将他们映射到一个ProtocolCheckResult中.除了id所有的属性都需要填充.查不到的目标id,和value填充""
        List<ProtocolCheckResult> sourceDdData = Lists.newArrayList();
        // 2.查询sqlite目标DD表数据库中某一个数据表中的所有数据.将他们映射到一个ProtocolCheckResult中.除了id所有的属性都需要填充.
        List<ProtocolCheckResult> targetDdData = Lists.newArrayList();
        //3.将目标DD表中的与源DD表匹配的单元格数据填充到源DD表对应的ProtocolCheckResult模型中
        List<ProtocolCheckResult> mergedData = sourceDdData.stream().map(item -> {
            List<ProtocolCheckResult> matchedCellCheckResult =
                    targetDdData.stream()
                            .filter(element -> element.getDstRowId().equals(item.getSrcRowId()) && element.getColumnName().equals(item.getColumnName()))
                            .collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(matchedCellCheckResult)) {
                item.setNewNeValue(matchedCellCheckResult.get(0).getNewNeValue());
                item.setDstRowId(matchedCellCheckResult.get(0).getDstRowId());
            }
            return item;
        }).collect(Collectors.toList());
        // 4.将目标DD表中特有的行数据填充到源DD表对应的ProtocolCheckResult模型中.
        List<String> sourceDdRowIds =
                sourceDdData.stream().map(item -> item.getSrcRowId()).collect(Collectors.toList());
        List<ProtocolCheckResult> targetDdUniqueRowData =
                targetDdData.stream().filter(element -> !sourceDdRowIds.contains(element.getDstRowId())).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(targetDdUniqueRowData)) {
            mergedData.addAll(targetDdUniqueRowData);
        }
        //此时,源dd表特有的行对应的 rowId有值,dstRowId为"" oldNeValue有值 newNeValue""
        // 5.将要检查的页签要检查的列的检查结果设置到mergedData中.(校验时填充的行id,源dd表独有的,则目标dd的行id填充为"",反之亦然)
        List<ProtocolCheckResult> protocolCheeckResultData = Lists.newArrayList();

        //源DD表和目标Dd表都有的行.
        mergedData.stream().map(item -> {
            List<ProtocolCheckResult> matchedCellCheckResult =
                    protocolCheeckResultData.stream()
                            .filter(element -> element.getSrcRowId().equals(item.getSrcRowId()) && element.getDstRowId().equals(item.getDstRowId()) && element.getColumnName().equals(item.getColumnName()))
                            .collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(matchedCellCheckResult)) {
                item.setParamCheckRule(matchedCellCheckResult.get(0).getParamCheckRule());
                item.setCheckResult(matchedCellCheckResult.get(0).getCheckResult());
            }
            return item;
        }).collect(Collectors.toList());

        // 源dd表特有的行
        mergedData.stream().map(element -> {
            ProtocolCheckResult filledElement = element;
            List<ProtocolCheckResult> sourceDdUniqueRowCheckResult =
                    protocolCheeckResultData.stream().filter(result -> "".equals(result.getDstRowId())).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(sourceDdUniqueRowCheckResult)) {
                for (ProtocolCheckResult sourceDdUniqueRow : sourceDdUniqueRowCheckResult) {
                    filledElement =
                            element.toBuilder().dstRowId(sourceDdUniqueRow.getSrcRowId()).paramCheckRule(sourceDdUniqueRow.getParamCheckRule()).checkResult(sourceDdUniqueRow.getCheckResult()).build();
                }
            }
            return filledElement;
        }).collect(Collectors.toList());
        // 目标dd表特有的行
        mergedData.stream().map(element -> {
            ProtocolCheckResult filledElement = element;
            List<ProtocolCheckResult> targetDdUniqueRowCheckResult =
                    protocolCheeckResultData.stream().filter(result -> "".equals(result.getSrcRowId())).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(targetDdUniqueRowCheckResult)) {
                for (ProtocolCheckResult targetDdUniqueRow : targetDdUniqueRowCheckResult) {
                    filledElement =
                            element.toBuilder().srcRowId(targetDdUniqueRow.getDstRowId()).paramCheckRule(targetDdUniqueRow.getParamCheckRule()).checkResult(targetDdUniqueRow.getCheckResult()).build();
                }
            }
            return filledElement;
        }).collect(Collectors.toList());
    }

    @Test
    public void test777() {
        Map<String, List<Map<String, Object>>> dataMap = Maps.newHashMap();
        Map<String, List<List<String>>> listMap = Maps.newHashMap();
        for (Map.Entry<String, List<Map<String, Object>>> stringListEntry : dataMap.entrySet()) {
            List<List<String>> oneSheetData = Lists.newArrayList();
            List<Map<String, Object>> rows = stringListEntry.getValue();
            List<String> titles = rows.stream().map(rowMap -> rowMap.keySet().toString()).collect(Collectors.toList());
            oneSheetData.add(titles);
            for (Map<String, Object> row : rows) {
                List<String> oneRowValue =
                        titles.stream().map(columnName -> row.get(columnName).toString()).collect(Collectors.toList());
                oneSheetData.add(oneRowValue);
            }
            listMap.put(stringListEntry.getKey(), oneSheetData);
        }
    }
}

