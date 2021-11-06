package com.huawei.nce.javabase.day27;

import org.junit.jupiter.api.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/11/6 15:57
 */
public class NetworkTest {
    /**
     * 网络编程的目的: 直接或者间接的通过网络协议与其他计算机进行通信.
     * 一.网络编程中的两个问题:
     * 1.如何准确的定位到网络中的某一台主机,定位到某一台主机的某一个应用.
     * 2.找到主机之后如何安全可靠的进行网络传输.
     * 二.网络编程中的对应的解决方案:
     * 问题一方案: 确定通信双方的地址: IP地址 + 端口号
     * 问题二方案: 按照一定的规则进行数据的传输.
     * (OSI参考模型:模型过于理想化,不能再因特网上进行推广使用)
     * TCP/IP参考模型: (TCP/IP协议)事实上的国际标准.
     * OSI参考模型:         TCP/IP参考模型:                    TCP/IP各层参考模型对应的协议
     * 应用层                     应用层                             HTTP(超文本传输)/FTP(文件传输)/Telnet(远程连接)/DNS(域名解析)
     * 表示层
     * 会话层
     * 传输层                     传输层                             TCP/UDP
     * 网络层                     网络层                             IP/ICMP/ARP
     * 数据链路层
     * 物理层                 物理层+ 数据链路层                      Link
     *
     * 三.通信的要素:IP地址和端口号
     * IP地址: 网络中一台主机的唯一标识
     * 分类:
     *   方式一: IPV4  IPV6
     *     ipv4 : 4个字节组成的  4个0-255的数字  点分十进制 192.168.0.1
     *     ipv6: 16个字节组成的, 8个无符号的整数  :分十六进行 3ffe:3201:1401:1280:c8ff:fe4d:db39:1984
     *   万维网, 局域网
     *   局域网地址范围: 192.168.0.0~192.168.255.255
     *
     *   端口号: 主机上某一个应用/进程的唯一标识
     *   端口分类:
     *   公认端口: 0-1023 被预先定义的服务通信占用（如：HTTP占用端口80，FTP占用端口21，Telnet占用端口23）
     *   注册端口: 1024~19151 分配给用户进程/应用(如: Oracle: 1521 Mysql: 3306. Tomcat: 8080)
     *   私有/动态端口: 49152~65535
     *
     *  IP地址+端口号得到一个网络套接字: Socket
     */
    @Test
    public void test1() throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName("192.168.1.3");
        // /192.168.1.3
        System.out.println(inetAddress);
        InetAddress inetAddress1 = InetAddress.getByName("www.atguigu.com");
        //  www.atguigu.com/112.30.162.175
        System.out.println(inetAddress1);
        InetAddress inetAddress2 = InetAddress.getByName("www.baidu.com");
        InetAddress inetAddress3 = InetAddress.getByName("www.jd.com");
        InetAddress inetAddress4 = InetAddress.getByName("www.mi.com");
        InetAddress inetAddress5 = InetAddress.getByName("www.sina.com");
        InetAddress inetAddress6 = InetAddress.getByName("www.vip.com");
        //  www.baidu.com/36.152.44.95
        System.out.println(inetAddress2);
        // www.jd.com/111.48.197.3
        System.out.println(inetAddress3);
        // www.mi.com/111.47.221.245
        System.out.println(inetAddress4);
        // www.sina.com/111.48.132.35
        System.out.println(inetAddress5);
        // www.vip.com/120.232.167.204
        System.out.println(inetAddress6);
    }
    @Test
    public void test2() throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        InetAddress inetAddress2 = InetAddress.getByName("localhost");
        // /127.0.0.1(本地回路地址)
        System.out.println(inetAddress);
        // localhost/127.0.0.1
        System.out.println(inetAddress2);
        String hostName = inetAddress2.getHostName();
        String hostAddress = inetAddress2.getHostAddress();
        // host: localhost ,hostAddress:127.0.0.1
        System.out.println("host: " + hostName + " ,hostAddress:" + hostAddress);
    }
    /**
     * 传输层有两个很重要的协议:
     * TCP协议:传输控制协议(打电话)
     *  使用TCP协议之前,必须要先建立TCP连接,形成传输通道
     *  传输前,采用"三次握手"方式,点对点通信, 是可靠的
     *  TCP协议进行通信的两个应用进行: 客户端, 服务器
     *  在连接中可以进行大量数据的传输
     *  传输完毕后,需要释放建立的连接,效率低.
     *
     * UDP协议:用户数据报协议(发送短信,发送电报)
     *  将数据源封装成一个数据包,不需要建立连接
     *  每个数据包的大小<=64K
     *  发送方不管接收方是否准备好,接收方收到也不确认.
     *  可以广播发送
     *  发送数据完毕无需释放资源,速度快,开销小.
     *
     * 网络层有一个很重要的协议
     * IP协议: 网络互联协议
     */

}
