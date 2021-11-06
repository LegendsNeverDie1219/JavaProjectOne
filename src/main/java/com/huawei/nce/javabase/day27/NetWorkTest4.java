package com.huawei.nce.javabase.day27;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/11/6 17:40
 */
public class NetWorkTest4 {
    /**
     * 类 DatagramSocket 和 DatagramPacket 实现了基于 UDP 协议网络程序。
     *  UDP数据报通过数据报套接字 DatagramSocket 发送和接收，系统不保证
     * UDP数据报一定能够安全送到目的地，也不能确定什么时候可以抵达。
     *  DatagramPacket 对象封装了UDP数据报，在数据报中包含了发送端的IP
     * 地址和端口号以及接收端的IP地址和端口号。
     *  UDP协议中每个数据报都给出了完整的地址信息，因此无须建立发送方和
     * 接收方的连接。如同发快递包裹一样。
     */
    @Test
    public void receiver() {
        DatagramPacket packet = null;
        try (DatagramSocket socket = new DatagramSocket(8089)) {
            byte[] bytes = new byte[1024];
            packet = new DatagramPacket(bytes, 0, bytes.length);
            socket.receive(packet);
            System.out.println(new String(packet.getData(), 0, packet.getLength()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sender() {
        try (DatagramSocket socket = new DatagramSocket()) {
            byte[] data = "我是UDP方式发送的导弹".getBytes(StandardCharsets.UTF_8);
            InetAddress host = InetAddress.getLocalHost();
            DatagramPacket packet = new DatagramPacket(data, 0, data.length, host, 8089);
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * URL(Uniform Resource Locator)：统一资源定位符，它表示 Internet 上某一
     * 资源的地址。
     * 它是一种具体的URI，即URL可以用来标识一个资源，而且还指明了如何locate
     * 这个资源。
     * 通过 URL 我们可以访问 Internet 上的各种网络资源，比如最常见的 www，ftp
     * 站点。浏览器通过解析给定的 URL 可以在网络上查找相应的文件或其他资源。
     *  URL的基本结构由5部分组成：
     * <传输协议>://<主机名>:<端口号>/<文件名>#片段名?参数列表
     * 例如:
     * http://192.168.1.100:8080/helloworld/index.jsp#a?username=shkstart&password=123
     * #片段名：即锚点，例如看小说，直接定位到章节
     * 参数列表格式：参数名=参数值&参数名=参数值....
     * <p>
     * 服务器没有开:
     * java.net.ConnectException: Connection refused: connect
     */
    @Test
    public void test() throws MalformedURLException, UnsupportedEncodingException {
        //javax.net.ssl.SSLException: Unrecognized SSL message, plaintext connection?
        // URL url = new URL("https://localhost:8080/examples/随风起舞.jpg");
        // 如果没有图片: java.io.IOException: Server returned HTTP response code: 400 for
        // URL: http://localhost:8080/examples/随风起舞.jpg
        String encode = URLEncoder.encode("桌面图标.png", "utf-8");
        URL url = new URL("http://localhost:8080/examples/"+ encode);
        InputStream inputStream = null;
        OutputStream outputStream = null;
        HttpURLConnection urlConnection = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();

            inputStream = urlConnection.getInputStream();
            byte[] bytes = new byte[1024 * 8];
            int length = inputStream.read(bytes);
            outputStream = new FileOutputStream("桌面图标GG.png");
            while (length != -1) {
                outputStream.write(bytes, 0, length);
                length = inputStream.read(bytes);
            }
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
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
    }
}
