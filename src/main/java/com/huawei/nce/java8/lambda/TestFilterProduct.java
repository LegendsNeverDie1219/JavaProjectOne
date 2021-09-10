package com.huawei.nce.java8.lambda;

import com.google.common.collect.Lists;
import com.huawei.nce.java8.myimplements.ColorMyPredicate;
import com.huawei.nce.java8.myimplements.PriceMyPredicate;
import com.huawei.nce.java8.myinterface.MyPredicate;
import com.huawei.nce.pojo.NumberConstant;
import com.huawei.nce.pojo.Product;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

/**
 * 过滤商品方法最原始的写法
 *
 * @author Administrator
 * @date 2020/9/6 15:09
 */
public class TestFilterProduct {
    private  static final  List<Product> productList;
    static {
         productList = Lists.newArrayList(
                new Product("红色商品", "红色",6000D,1),
                new Product("蓝色商品", "蓝色",7000D,2),
                new Product("黄色商品", "黄色",6000D,3));
    }
    @Test
    public void test1() {
        List<Product> fileteredProductList = filterProductByColor(productList);
        for (Product product : fileteredProductList) {
            System.out.println(product.toString());
        }
        System.out.println("======================================================");
        List<Product> fileteredProductList2 = filterProdectByPrice(productList);
        for (Product product : fileteredProductList2) {
            System.out.println(product.toString());
        }
    }
    // 筛选颜色为红色的产品
    private List<Product> filterProductByColor(List<Product> productList) {
        ArrayList<Product> proList = new ArrayList<>(NumberConstant.NUM_1);
        for (Product product : productList) {
            if ("红色".equals(product.getColor())) {
                proList.add(product);
            }
        }
        return proList;
    }
    //筛选价格小于8000的产品
    private List<Product> filterProdectByPrice (List<Product> productList) {
        List<Product> proList = new ArrayList<>(NumberConstant.NUM_1);
        for (Product product : productList) {
            if (product.getPrice() < 8000) {
                proList.add(product);
            }
        }
        return proList;
    }
    @Test
    public void test2() {
        MyPredicate colorMyPredicate = new ColorMyPredicate();
        // 定义一个过滤方法的接口,将接口当作方法来进行传递
        List<Product> fileteredProductList = filterProductByPredicate(productList, colorMyPredicate);
        for (Product product : fileteredProductList) {
            System.out.println(product.toString());
        }
        System.out.println("======================================================");
        MyPredicate priceMyPredicate = new PriceMyPredicate();
        List<Product> fileteredProductList2 = filterProductByPredicate(productList, priceMyPredicate);
        for (Product product : fileteredProductList2) {
            System.out.println(product.toString());
        }
    }

    @Test
    public void test3() {
        //传的一个匿名内部类(相当于接口的实现类实例),继承了接口,并且重写了接口中的抽象方法
        List<Product> fileteredProductList = filterProductByPredicate(productList, new MyPredicate<Product>() {
            @Override
            public boolean fileter(Product product) {
                return "红色".equals(product.getColor());
            }
        });
        for (Product product : fileteredProductList) {
            System.out.println(product.toString());
        }
        System.out.println("======================================================");
        List<Product> fileteredProductList2 = filterProductByPredicate(productList, new MyPredicate<Product>() {
            @Override
            public boolean fileter(Product product) {
                return product.getPrice() < 8000;
            }
        });
        for (Product product : fileteredProductList2) {
            System.out.println(product.toString());
        }
    }

    @Test
    public void test4() {
        /***
         * @param
         * @return {}
         * lambda表达式就是一个匿名的,可传递的,函数表达式,可以像参数一样进行传递的代码(本质上就是一个匿名内部类) ,
         * 它有参数 有返回值,有方法体,但是没有名字
         * 参数就是匿名内部类中的方法的形参,方法体就是匿名内部类中的方法的方法体
         * 参数就是函数式接口中的形参,方法体就是函数式接口实现类中方法体
         **/
        List<Product> fileteredProductList = filterProductByPredicate(productList, (p) -> "红色".equals(p.getColor()));
        for (Product product : fileteredProductList) {
            System.out.println(product.toString());
        }
        System.out.println("======================================================");
        List<Product> fileteredProductList2 = filterProductByPredicate(productList, (product) -> product.getPrice() < 8000);
        for (Product product : fileteredProductList2) {
            System.out.println(product.toString());
        }
    }
    @Test
    public void test5() {
        //根据颜色进行过滤
        productList.stream() //将集合转化成一个流
                .filter((product) -> "红色".equals(product.getColor())) //给定一个条件,filter会根据这个条件截取符合条件的元素,重新生成一个流
                .limit(2) //截取流中前2个元素,重新生成一个流
                .forEach(System.out :: println);//引用实例方法
        //根据价格进行过滤
        System.out.println("=================================");
        productList.stream()
                .filter((product) ->product.getPrice() < 8000)
                .limit(2)
                .forEach(System.out :: println);
        //遍历输出商品的名称
        productList.stream()
                .map(Product :: getName) //使用map中的lambda表达式,将流中的每一个元素转换成新的类型,并重新生成一个流
                .forEach(System.out :: println);
    }

    private List<Product> filterProductByPredicate(List<Product> productList, MyPredicate<Product> myPredicate) {
        List<Product> newList = new ArrayList<>();
        for (Product product : productList) {
            if(myPredicate.fileter(product)) {
                newList.add(product);
            }
        }
        return newList;
    }
}
