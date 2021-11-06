package com.huawei.nce.javabase.day27;


import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/11/6 16:49
 */
public class NetworkTest2 {
    /**
     * 客户端发送信息给服务器,服务器将数据显示在控制台.
     * 需要先开启服务器,再开启客户端.否则
     * java.net.ConnectException: Connection refused: connect
     */
    @Test
    public void client() {
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            // 1.创建socket,指明ip地址,端口口号
            socket = new Socket(inetAddress, 8899);
            // 2.获取输出流.用于输出数据
            outputStream = socket.getOutputStream();
            // 3.写出数据的操作.
            outputStream.write("你好,我是客户端MM".getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            // 1.创建服务器端的serverSocket,指明服务器端的端口号
            serverSocket = new ServerSocket(8899);
            // 2.调用accept() 接收来自客户端的socket.
            socket = serverSocket.accept();
            // 3.基于客户端的socket获取输入流
            inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int length = inputStream.read(bytes);
            byteArrayOutputStream = new ByteArrayOutputStream();

            while (length != -1) {
                byteArrayOutputStream.write(bytes,0,length);
                length = inputStream.read(bytes);
            }
            System.out.println(byteArrayOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (byteArrayOutputStream!=null) {
                    byteArrayOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (inputStream!=null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket!=null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (serverSocket!=null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
