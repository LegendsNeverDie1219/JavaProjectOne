package com.huawei.nce.javabase.day27;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/31 8:24
 */
public class IOTest {
    /**
     * 一.IO : input output
     * 用途: 用于读取文件到内存/写出文件到磁盘
     * 视角: 内存视角.
     *  从磁盘中读取文件到内存   input
     *  从内存写出文件到磁盘     output
     */

    /**
     * 二.流的分类:
     * 按数据的流向不同: input  output
     * 按操作的数据类型不同: 字符流,  字节流
     * 按流的角色不同: 节点流, 处理流
     *
     * 抽象父类  字节流              字符流
     * 输入流    InputStream       Reader
     * 输出流    OutputStream      Writer
     */

    /**
     * 三.流的体系
     * 抽象基类        节点流               缓冲流
     * InputStream    FileInputStream       BufferedInputStream
     * OutputStream   FileOutputStream      BufferedOutputStream
     * Reader         FileReader            BufferedReader
     * Writer         FileWriter            BufferedWriter
     */
    @Test
    public void testFileReaderRead() {
        // 1.实例化File 对象
        File file = new File("hello.txt");
        FileReader fileReader = null;
        try {
            // 2.实例化流对象
            fileReader = new FileReader(file);
            int data = fileReader.read();
            // 3.操作数据.
            // 返回读入的一个字符, 如果到达文件末尾,则返回 -1
            while (data != -1) {
                System.out.println((char) data);
                data = fileReader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    // 4.关闭资源
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testFileReaderRead2() {
        File file = new File("hello.txt");
        Reader reader = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            reader = new FileReader(file);
            char[] charArray = new char[5];
            int length = reader.read(charArray);
            while (length != -1) {
                //[z, o, u, l, i]
                //[n, g, u, l, i]
                // System.out.println(Arrays.toString(charArray));
                for (int i = 0; i < length; i++) {
                    // System.out.print(charArray[i]);
                    stringBuilder.append(charArray[i]).append(' ');
                }
                length = reader.read(charArray);
            }
            System.out.println(stringBuilder.deleteCharAt(stringBuilder.length() - 1));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testFileWriterWrite() {
        File file = new File("hello1.txt");
        Writer writer = null;
        String lineSeparator = System.lineSeparator();
        try {
            writer = new FileWriter(file);
            writer.write("I have a dream" + lineSeparator);
            writer.write("You need to have a dream" + lineSeparator);
            writer.write(new char[]{'Y', 'o', 'u', ' ', 'a', 'r', 'e', ' ', 'a', ' ', 'p', 'e', 'r', 's', 'o', 'n'});
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 结论:
     * 1.对于文本文件(.txt, .java, .xml) 最好使用字符流去处理
     * 2.对于非文本文件(.jpg, .mp3, .avi,doc,.xlsx 文件) 需要使用字节流去处理.
     */
    @Test
    public void testFileReaderAndWriter() {
//        File srcFile = new File("hello1.txt");
//        File dstFile = new File("hello2.txt");
        // 不能使用字符流来处理图片,音乐,视频等字节信息.会出现文件无法打开的问题.
        File srcFile = new File("6.jpg");
        File dstFile = new File("666.jpg");

        Reader reader = null;
        Writer writer = null;
        try {
            reader = new FileReader(srcFile);
            writer = new FileWriter(dstFile);
            char[] charBuffer = new char[8];
            int length = reader.read(charBuffer);
            while (length != -1) {
                writer.write(charBuffer, 0, length);
                // writer.write(charBuffer);
                length = reader.read(charBuffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testInputStreamOutputStream() {
        File srcFile = new File("7.jpg");
        File dstFile = new File("777.jpg");
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(srcFile);
            outputStream = new FileOutputStream(dstFile);
            byte[] byteBuffer = new byte[10];
            int length = inputStream.read(byteBuffer);
            while (length != -1) {
                outputStream.write(byteBuffer, 0, length);
                length = inputStream.read(byteBuffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testCopyFile1() {
        long startTime = System.currentTimeMillis();
//        String srcFilePath = "G:\\尚硅谷视频1-3\\视频1\\";
//        String dstFilePath = "G:\\尚硅谷视频1-3\\视频2\\";
//        String srcFilePath = "G:\\尚硅谷视频1-3\\视频1\\05-尚硅谷-Java语言高级-IO流概述与流的分类.avi";
//        String dstFilePath = "G:\\尚硅谷视频1-3\\视频1\\0555-尚硅谷-Java语言高级-IO流概述与流的分类.avi";
        String srcFilePath = "G:\\尚硅谷视频1-3\\视频1\\课件笔记源码资料.zip";
        String dstFilePath = "G:\\尚硅谷视频1-3\\视频1\\111课件笔记源码资料.zip";
        copyFile(srcFilePath, dstFilePath);
        long endTime = System.currentTimeMillis();
        // 1437ms(1024*8)  6361ms(1024)
        System.out.println("花费的时间为: " + (endTime - startTime));
    }

    @Test
    public void testCopyFile2() {
        long startTime = System.currentTimeMillis();
        String srcFilePath = "G:\\尚硅谷视频1-3\\视频1\\课件笔记源码资料.zip";
        String dstFilePath = "G:\\尚硅谷视频1-3\\视频1\\222课件笔记源码资料.zip";
        copyFile(srcFilePath, dstFilePath);
        // 1354ms(1024*8)  1459ms(1024)
        long endTime = System.currentTimeMillis();
        System.out.println("花费的时间为: " + (endTime - startTime));
    }

    private void copyFile(String srcFilePath, String dstFilePath) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            // 1.造文件,造流(其中这个传入的路径必须是一个文件路径.(带后缀) 不能是文件夹路径.)
            inputStream = new FileInputStream(new File(srcFilePath));
            outputStream = new FileOutputStream(new File(dstFilePath));
//            inputStream = new BufferedInputStream(new FileInputStream(new File(srcFilePath)));
//            outputStream = new BufferedOutputStream(new FileOutputStream(new File(dstFilePath)));
            byte[] byteArray = new byte[1024];
            // 2.通过流操作数据,实现读入写出.
            int length = inputStream.read(byteArray);
            while (length != -1) {
                outputStream.write(byteArray, 0, length);
                length = inputStream.read(byteArray);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 3.关闭流.
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testBufferedReader() {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File("dbcp.txt")));
            bufferedWriter = new BufferedWriter(new FileWriter(new File("dbcp2.txt")));

            char[] charArray = new char[14];
            int length = bufferedReader.read(charArray);

            while (length != -1) {
                bufferedWriter.write(charArray, 0, length);
                // 将流中的缓存的数据强制写入到磁盘中,并清空流中的缓存.
                bufferedWriter.flush();
                length = bufferedReader.read(charArray);
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


    @Test
    public void testBufferedReader2() {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File("dbcp.txt")));
            bufferedWriter = new BufferedWriter(new FileWriter(new File("dbcp3.txt")));

            String oneRowData = bufferedReader.readLine();
            // readLine() 返回文件一行的数据,并且不包含换行符, 到达文件的末尾返回的是null .
            while (oneRowData != null) {
                bufferedWriter.write(oneRowData + System.lineSeparator());
                // 将流中的缓存的数据强制写入到磁盘中,并清空流中的缓存.
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
