package com.huawei.nce.javabase.day18.produceconsume1;

/**
 * TODO
 *
 * @author Administrator
 * @date 2022/10/11 15:10
 */
public class Clerk {
    public int productQuantity = 0;

    // 共享数据是clerk
    // 同步监视器是this,也是clerk
    public synchronized void addProduct() {

        while (productQuantity >= 3) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        productQuantity++;
        System.out.println("开始生产第" + productQuantity + "个产品");
        this.notifyAll();

    }

    public synchronized void consumeProduct() {
        while (productQuantity <= 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("开始消费第" + productQuantity + "个产品");
        productQuantity--;
        this.notifyAll();
    }
}