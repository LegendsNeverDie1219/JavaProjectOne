package com.huawei.nce.javabase.day18;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/6 10:14
 */
public class Window3 extends Thread {
    private static int ticket = 100;
    // private static Object object = new Object();

    public Window3() {
    }

    public Window3(String name) {
        super(name);
    }

    /**
     * 1.问题: 卖票过程中,出现了错票,重票 即线程安全问题
     * 2.问题产生的原因: 当某一个线程执行操作共享数据ticket的代码块时候,还没有操作完成,
     * 其他线程也进入操作共享数据ticket的代码块
     * 3.如何解决: 当一个线程a在操作共享数据的时候,其他线程不能参与进来.
     * 直到线程a操作完成,其他线程才可以操作, 这个过程中,即使线程a出现了阻塞(sleep())也不能改变
     * 4.在java中如何处理: 采用同步机制,来解决线程安全问题
     * 方式一:
     * 同步代码块
     * synchronized(同步监视器/锁) {
     * // 需要被同步的代码
     * }
     * 说明: 1.需要被同步的代码: 即操作共享数据的代码
     * 2.共享数据: 多个线程共同操作的变量,比如: 本类中的ticket
     * 3.同步监视器(锁): 任何一个类的对象,都可以充当一个监视器, 但是前提是多个线程要抢这一个对象.
     * 通常情况下.我们不会去专门创建一个对象作为锁. 都是用现成的
     * 如果采用继承thread的方式,有new了多个thread实例来调用start() 所以这个锁对应的对象: 需要是一个全局共享的变量/即static
     * 可以类对象. Window3.class
     * 如果采用实现Runnable接口的方式.因为从头到尾只new了一个Runnable接口实现类实例.其他线程对象都共享使用该对象.
     * 所以,可以使用当前的RunnableImpl对象. this
     * 方式二:
     * 同步方法
     * <p>
     * 在方法上加同步修饰符 synchronized
     * <p>
     * 5.优势和局限
     * 优点: 解决了线程安全问题
     * 缺点: 操作同步数据的时候,只能有一个线程操作,其他线程被阻塞.相当于一个单线程操作的过程. 效率低.
     *
     * 6.synchronized包含的范围一定要适当.
     * 范围太小：没锁住所有有安全问题的代码
     * 范围太大：没发挥多线程的功能
     *
     * 7.释放锁的操作VS不释放锁的操作
     * 释放锁的操作:
     *   ①当前线程的同步代码块/同步方法执行完成
     *   ②当前线程的同步代码块/同步方法遇到brek,return结束的
     *   ③当前线程的同步代码块/同步方法执行过程遇到了为处理的Error/Exception
     *   ④当前线程的同步代码块/同步方法 中执行了当前线程对象.wait().当前线程暂停,释放锁.
     * 不释放锁的操作
     * ①当前线程的同步代码块/同步方法  调用了wait() / yield()(屈服,主动放弃时间片)
     * ②当前线程的同步代码块/同步方法 ,  其他线程调用了该线程的suspend(),将该线程挂起.但不会释放锁.
     */
//    @Override
//    public void run() {
//        while (true) {
////            synchronized (object) {
//              synchronized (Window3.class) {
//                if (ticket > 0) {
//                    try {
//                        sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(getName() + "卖票,票号为: " + ticket);
//                    ticket--;
//                } else {
//                    break;
//                }
//            }
//        }
//    }
    @Override
    public void run() {
        while (true) {
            if (sellTickets()) {
                break;
            }
        }
    }

    /**
     * 1.同步方式仍然涉及到监视器,只不过我们不需要显式的声明而已
     * 2. 静态同步方法的同步监视器为当前类对象Window3.class. 实例同步方法的同步监视器为当前对象,this
     * 需要注意的是: 如果采用继承thread的方式, 则同步方法需要用static修饰.目的是保证同步监视器为类对象: Window3.class
     * @return
     */
    private static synchronized boolean sellTickets() {
        if (ticket > 0) {
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖票,票号为: " + ticket);
            ticket--;
        } else {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Window3 windowOne = new Window3("窗口一");
        windowOne.start();

        Window3 windowTwo = new Window3("窗口二");
        windowTwo.start();

        Window3 windowThree = new Window3("窗口三");
        windowThree.start();
    }
}
