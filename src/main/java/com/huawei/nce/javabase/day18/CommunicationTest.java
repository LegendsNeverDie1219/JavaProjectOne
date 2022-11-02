package com.huawei.nce.javabase.day18;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/6 12:29
 */
public class CommunicationTest {
    /**
     * 线程通信: 使用两个线程打印1-100的数据,线程1,2交替打印.
     * 1.线程通信涉及到的三个方法:
     *   wait() 一旦执行该方法,当前线程就进入到了阻塞状态,会释放锁
     *   notify():一旦执行该方法,就会唤醒一个被wait()的线程,使他进入就绪状态,
     *   如果有多个线程被wait() 则唤醒优先级高的那个线程
     *   notifyAll()  唤醒所有被wait()的线程.
     * 2.线程通信的说明
     * ①wait() notify() notyfyAll() 必须使用在同步代码块/同步方法中
     * ②.这三个方法的调用者必须是同步监视器 否则会报 java.lang.IllegalMonitorStateException
     * ③.这三个方法中java.lang.Object根类中方法.
     *
     * 3.sleep() 和wait() 的区别
     * 相同点: 一旦执行,都会进入阻塞状态
     * 不同点:
     *  ①声明的地方不同,一个是声明在Thread类中的静态方法, 一个是Object中的实例方法.
     *  ②调用的要求不同,sleep() 可以任何需要的地方调用,wait() 只能在同步代码块中被调用,调用者必须为锁.
     *  ③sleep() 虽导致当前线程阻塞,但不会释放锁. wait() 则会释放锁
     *
     * @param args
     */
    public static void main(String[] args) {
        Communication communication = new Communication();
        new Thread(communication, "线程一").start();
        new Thread(communication, "线程二").start();
    }
}
class Communication implements Runnable{
    private int number = 1;
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                this.notify();
                if (number <=100) {
                    try {
                        //Thread.sleep(10);
                        System.out.println(Thread.currentThread().getName() + "-> " + number);
                        number++;
                        // 当前线程打印完,并且已经自增,调用wait() 进入阻塞,等待另一个线程打印
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}
