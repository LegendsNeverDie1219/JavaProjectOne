package com.huawei.nce.myimplements;


import com.huawei.nce.myinterface.MyPredicate;
import com.huawei.nce.pojo.Product;

/**
 * TODO
 *
 * @author Administrator
 * @date 2020/9/6 17:42
 */
public class PriceMyPredicate implements MyPredicate<Product> {
    @Override
    public boolean fileter(Product product) {
        return product.getPrice() < 8000;
    }
}
