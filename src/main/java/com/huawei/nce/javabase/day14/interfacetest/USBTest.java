package com.huawei.nce.javabase.day14.interfacetest;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/2 9:06
 */
public class USBTest {
    public static void main(String[] args) {
        Computer computer = new Computer();
        USB usb = new Disk();
        computer.transferDate(usb);
        System.out.println("=====================");
        computer.transferDate(new Phone());
        System.out.println("=====================");
        computer.transferDate(new USB() {
            @Override
            public void start() {
                System.out.println("打印机正在与目标设备建立连接,开始传输数据");
            }

            @Override
            public void stop() {
                System.out.println("打印机传输数据完成,与正在与目标设备断开连接");
            }
        });
    }
}

class Computer {
    public void transferDate(USB usb) {
        usb.start();
        System.out.println("具体的传输细节");
        usb.stop();
    }
}


interface USB {
    void start();

    void stop();
}

class Disk implements USB{

    @Override
    public void start() {
        System.out.println("u盘正在与目标设备建立连接,开始传输数据");
    }

    @Override
    public void stop() {
        System.out.println("u盘传输数据完成,与正在与目标设备断开连接");
    }
}

class Phone implements USB{

    @Override
    public void start() {
        System.out.println("手机正在与目标设备建立连接,开始传输数据");
    }

    @Override
    public void stop() {
        System.out.println("手机传输数据完成,与正在与目标设备断开连接");
    }
}