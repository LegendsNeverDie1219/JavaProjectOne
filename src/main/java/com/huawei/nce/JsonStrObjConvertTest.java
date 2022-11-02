package com.huawei.nce;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huawei.nce.pojo.Product;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author Administrator
 * @date 2022/2/12 14:23
 */
public class JsonStrObjConvertTest {
    private static final Gson GSON = new Gson();
    private  static final  List<Product> PRODUCT_LIST;
    static {
        PRODUCT_LIST = Lists.newArrayList(
                new Product("红色商品", "红色",6000D,1),
                new Product("蓝色商品", "蓝色",7000D,2),
                new Product("黄色商品", "黄色",6000D,3));
    }

    @Test
    public void test1() {
        String jsonStr = "[{\"name\":\"红色商品\",\"color\":\"红色\",\"price\":6000.0,\"num\":1},{\"name\":\"蓝色商品\"," +
                "\"color\":\"蓝色\",\"price\":7000.0,\"num\":2},{\"name\":\"黄色商品\",\"color\":\"黄色\",\"price\":6000.0," +
                "\"num\":3}]";
        List<Product> animals = GSON.fromJson(jsonStr, TypeToken.getParameterized(List.class, Product.class).getType());
        animals.forEach(System.out::println);
    }

    @Test
    public void test() {
        String str = GSON.toJson(PRODUCT_LIST);
        System.out.println(str);
    }
    @Test
    public void testList() {
        List<Product> productList = Lists.newArrayList(
                new Product("红色商品", "红色",6000D,1),
                new Product("蓝色商品", "蓝色",7000D,2),
                new Product("黄色商品", "黄色",6000D,3));

        List<Product> filterList = productList.stream().filter(item -> item.num == 1).collect(Collectors.toList());
        Product editProduct = filterList.get(0);
        Product tempProduct = new Product("黑色", "黑色商品", 1000D, 4);
        editProduct.name = tempProduct.name;
        editProduct.color = tempProduct.color;
        editProduct.price = tempProduct.price;
        editProduct.num = tempProduct.num;
        System.out.println(productList);


    }
}
