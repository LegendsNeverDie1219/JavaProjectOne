package com.huawei.nce.javabase.day14.interfacetest;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/2 9:48
 */
public class FactoryTest {
    /**
     * 工厂模式: 实现了创建者和调用者的分离,
     * 即将创建对象的具体过程屏蔽隔离起来. 以达到灵活性的功能.
     * 对应现实生活的社会分工
     * 原始社会的人的什么都要会.打猎,生火,做饭,织衣
     * 现代社会的人: 不同分工的事情交给不同的专业的人来完成.
     *
     * 原来我们需要自己new 一个对象. 现在提供了一个工厂, 我们就可以把new 对象的工作交给工厂去做.
     *
     * 简单工厂模式：用来生产同一等级结构中的任意产品。（对于增加新的产品，
     * 需要修改已有代码）
     *  工厂方法模式：用来生产同一等级结构中的固定产品。（支持增加任意产品）
     *  抽象工厂模式：用来生产不同产品族的全部产品。（对于增加新的产品，无
     * 能为力；支持增加产品族）
     */
    public static void main(String[] args) {
        // 不使用工厂模式的写法
        System.out.println("不使用工厂模式的写法");
        Car carA = new Audi();
        Car carB = new BYD();
        carA.run();
        carB.run();

        System.out.println("使用简单工厂模式");
        // 使用简单工厂模式
        Car audi = SimpleCarFactory.getCar("奥迪");
        audi.run();
        Car byd = SimpleCarFactory.getCar("比亚迪");
        byd.run();
//        Car benchi = CarFactory.getCar("奔驰");
//        benchi.run();

        System.out.println("使用工厂方法模式");
        // 使用工厂方法模式
        Car audi2 = new AudiFactory().getCar();
        audi2.run();

        Car byd2 = new BydFactory().getCar();
        byd2.run();


    }
}

interface Car {
    void run();
}

class Audi implements Car {

    @Override
    public void run() {
        System.out.println("奥迪在跑");
    }
}

class BYD implements Car {

    @Override
    public void run() {
        System.out.println("比亚迪在跑");
    }
}

/**
 * 简单工厂模式: 即静态工厂模式，就是工厂类一般是使用静态方法，通过接收不同的参数来返回不同的实例对象。
 *
 * 优点: 把调用者与创建者分离
 * 缺点: 对于增加新产品，不修改代码的话，是无法扩展的。违反了开闭原则（对扩展开放；对修改封闭)
 *
 */
class SimpleCarFactory {
    public static Car  getCar (String type) {
        if ("奥迪".equals(type)) {
            return new Audi();
        } else if ("比亚迪".equals(type)) {
            return new BYD();
        } else {
            throw new RuntimeException();
        }
    }
}
/**
 * 工厂方法模式:
 * 工厂方法模式和简单工厂模式最大的不同在于，简单工厂模式只有一个（对于一个项目或者一个独立的模块而言）工厂类，
 * 而工厂方法模式有一组实现了相同接口的工厂类
 */
interface CarFacrtory {
    Car getCar();
}

class AudiFactory implements  CarFacrtory {

    @Override
    public Audi getCar() {
        return new Audi();
    }
}

class BydFactory implements  CarFacrtory {

    @Override
    public BYD getCar() {
        return new BYD();
    }
}

