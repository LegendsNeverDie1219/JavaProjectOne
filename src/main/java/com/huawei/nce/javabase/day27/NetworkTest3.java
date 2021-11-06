package com.huawei.nce.javabase.day27;


import org.junit.jupiter.api.Test;

import java.io.*;
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
public class NetworkTest3 {
    /**
     * 客户端发送信息给服务器,服务器将数据显示在控制台.
     * 需要先开启服务器,再开启客户端.否则
     * java.net.ConnectException: Connection refused: connect
     */
    @Test
    public void client() {
        Socket socket = null;
        OutputStream outputStream = null;
        FileInputStream fileInputStream = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream =null;
        try {
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            // 1.创建socket,指明ip地址,端口口号
            socket = new Socket(inetAddress, 8899);
            // 2.获取输出流.用于输出数据
            outputStream = socket.getOutputStream();
            fileInputStream = new FileInputStream(new File("随风起舞.jpg"));
            byte[] byteBuffer = new byte[1024 * 8];
            int length;
            while ((length = fileInputStream.read(byteBuffer)) != -1) {
                outputStream.write(byteBuffer, 0, length);
            }
            // 关闭图片的输出.
            socket.shutdownOutput();

            // 5.接受来自服务器端的响应.,并返回到控制台
            inputStream = socket.getInputStream();
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024*8];
            int len = inputStream.read(bytes);
            while (len != -1) {
                byteArrayOutputStream.write(bytes,0,len);
                len = inputStream.read(bytes);
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
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
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
        FileOutputStream fileOutputStream = null;
        OutputStream outputStream = null;
        try {
            // 1.创建服务器端的serverSocket,指明服务器端的端口号
            serverSocket = new ServerSocket(8899);
            // 2.调用accept() 接收来自客户端的socket.
            socket = serverSocket.accept();
            // 3.基于客户端的socket获取输入流
            inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            fileOutputStream = new FileOutputStream("随风起舞_服务器路径.jpg");
            int length = inputStream.read(bytes);
            while (length != -1) {
                fileOutputStream.write(bytes, 0, length);
                length = inputStream.read(bytes);
            }
            System.out.println("图片从客户端传输到服务器完成");
            outputStream = socket.getOutputStream();
            outputStream.write("美女,照片已经收到,非常漂亮".getBytes(StandardCharsets.UTF_8));
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
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (inputStream != null) {
                    inputStream.close();
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
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
