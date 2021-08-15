package com.huawei.nce.myimplements;


import com.huawei.nce.myinterface.MyPredicate;
import com.huawei.nce.pojo.Product;

/**
 * TODO
 *
 * @author Administrator
 * @date 2020/9/6 17:23
 */
public class ColorMyPredicate implements MyPredicate<Product> {
    private static final  String RED = "红色";
    @Override
    public boolean fileter(Product product) {
        return RED.equals(product.getColor());
    }
}
