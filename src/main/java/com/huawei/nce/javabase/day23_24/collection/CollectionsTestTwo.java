package com.huawei.nce.javabase.day23_24.collection;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/24 21:47
 */
public class CollectionsTestTwo {
    /**
     * 请从键盘上录入10个整数,保存到List集合中.并按照倒序,从大到小的顺序显示出来.
     */
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请从键盘上录入10个整数, 遇到0结束");
        List<Integer> list = new ArrayList<>();
//        int i = 1;
//        while(scanner.hasNextLine()) {
//            System.out.println("请从键盘上录入第" + i + "个整数");
//            Integer number = null;
//            try {
//                number = Integer.valueOf(scanner.nextLine());
//            } catch (IllegalArgumentException e) {
//                System.out.println("你输入的整数有误，请重新输入");
//                i--;
//                continue;
//            }
//
//            if (number == 0 || i > 10) {
//                break;
//            } else {
//                list.add(number);
//                i++;
//            }
//        }
        for (int i = 1; i <= 10; i++) {
            System.out.println("请从键盘上录入第" + i + "个整数");
            Integer number = null;
            try {
                number = Integer.valueOf(scanner.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println("你输入的整数有误，请重新输入");
                break;
            }

            if (number == 0) {
                break;
            } else {
                list.add(number);
            }
        }
        //[6, 5, 7, 4, 8, 3, 9, 2, 10, 1]
        //[10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
        Collections.reverse(list);
        System.out.println(list);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -o1.compareTo(o2);
            }
        });
        System.out.println(list);
    }

    /**
     * 姓氏统计:一个文本文件中存储着北京高校的所有在校生的姓名
     * 格式如下: 每行一个名字,姓和名以空格分开
     * 张 三
     * 李 四
     * 王 小五
     * <p>
     * 现在想统计所有的姓氏在文件中出现的次数
     */
    @Test
    public void test2() {
        // String property = System.getProperty("user.dir");
        File file = new File("name.txt");
        BufferedReader bufferedReader = null;
        HashMap<String, Integer> hashMap = new HashMap<>();
        try {
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String oneRowStr = bufferedReader.readLine();
            while (oneRowStr != null) {
                setLastNameFrequency(oneRowStr, hashMap);
                oneRowStr = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        printMapContent(hashMap);
    }

    private void printMapContent(HashMap<String, Integer> hashMap) {
        hashMap.forEach((key, value) -> {
            System.out.println(key + " -> " + value);
        });
    }

    private void setLastNameFrequency(String oneRowStr, HashMap<String, Integer> hashMap) {
        String trimOneRowStr = oneRowStr.trim();
        int i = trimOneRowStr.indexOf(" ");
        String lastNameStr = trimOneRowStr.substring(0, i);
        if (hashMap.containsKey(lastNameStr)) {
            Integer count = hashMap.get(lastNameStr);
            count++;
            hashMap.put(lastNameStr, count);
        } else {
            hashMap.put(lastNameStr, 1);
        }
    }

    @Test
    public void test3() {
        BufferedReader bufferedReader = null;
        HashMap<String, Integer> hashMap = new HashMap<>();
        try {
            bufferedReader = new BufferedReader(new FileReader("name.txt"));
            String oneRowStr = bufferedReader.readLine();
            StringBuilder stringBuilder = new StringBuilder();
            while (oneRowStr != null) {
                String trimOneRowStr = oneRowStr.trim();
                char[] chars = trimOneRowStr.toCharArray();
                for (char aChar : chars) {
                    if (aChar != ' ') {
                        stringBuilder.append(aChar);
                    } else {
                        String lastNameStr = stringBuilder.toString();
                        if (hashMap.containsKey(lastNameStr)) {
                            int count = hashMap.get(lastNameStr);
                            hashMap.put(lastNameStr, count + 1);
                        } else {
                            hashMap.put(lastNameStr, 1);
                        }
                        stringBuilder.delete(0, stringBuilder.length());
                        break;
                    }
                }
                oneRowStr = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        printMapContent(hashMap);
    }

    @Test
    public void test4() {
        BufferedReader bufferedReader = null;
        HashMap<String, Integer> hashMap = new LinkedHashMap<>();
        try {
            bufferedReader = new BufferedReader(new FileReader("name.txt"));
            String oneRowStr;
            StringBuilder stringBuilder = new StringBuilder();
            whileLoop: while ((oneRowStr = bufferedReader.readLine()) != null) {
                String trimOneRowStr = oneRowStr.trim();
                char[] chars = trimOneRowStr.toCharArray();
                for (char aChar : chars) {
                    if (aChar != ' ') {
                        stringBuilder.append(aChar);
                    } else {
                        String lastNameStr = stringBuilder.toString();
                        if (hashMap.containsKey(lastNameStr)) {
                            int count = hashMap.get(lastNameStr);
                            hashMap.put(lastNameStr, count + 1);
                        } else {
                            hashMap.put(lastNameStr, 1);
                        }
                        stringBuilder.delete(0, stringBuilder.length());
                        continue whileLoop;
                    }
                }
                System.out.println("有问题的字符串如下: ");
                System.out.println(stringBuilder);
                stringBuilder.delete(0, stringBuilder.length());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        printMapContent(hashMap);
    }
}
