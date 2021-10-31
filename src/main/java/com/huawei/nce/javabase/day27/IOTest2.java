package com.huawei.nce.javabase.day27;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/31 15:22
 */
public class IOTest2 {
    /**
     * Java API 提供了两个转换流
     * InputStreamReader 将 InputStream 转化为 Reader
     * OutputStreamWriter 将 Writer转化为 OutputStream
     * 作用: 提供了字节流和字符流之间的转化.
     * 目的:
     * 1,如果字节流中的数据都是文本类型的.则 转化为字符流效率更高
     * 2.转化为字符流的时候可以指定编码格式, 可以处理文件乱码.
     * <p>
     * 解码:  字节,字节数组 -> 字符,字符数组
     * 编码: 字符,字符数组  -> 字节,字节数组.
     */
    /**
     * 转换流复制文件,文件编码集:GBK -> utf-8
     */
    @Test
    public void testInputOutStreamReader() {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("dbcp.txt"),
                    "GBK"));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Redirect.txt"),
                    StandardCharsets.UTF_8));
            String oneRowData = bufferedReader.readLine();
            while (oneRowData != null) {
                bufferedWriter.write(oneRowData + System.lineSeparator());
                bufferedWriter.flush();
                oneRowData = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
