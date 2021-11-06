package com.huawei.nce.javabase.day27;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/11/4 19:34
 */
public class RandomAccessFileTest {
    /**
     * 1.RandomAccessFile 直接继承了java.lang.Object根父类
     * 实现了 DataInput DataOutput Closeable接口.
     * 2.RandomAccessFile 既可以做文件的输入流.又可以做文件的输出流.
     * public RandomAccessFile(File file, String mode)
     * r :只读的方式 读取一个已经存在的文件,如果文件不存在,则会报异常
     * rw:读写方式  读取/写出一个文件, 如果文件不存在,则会创建一个文件.
     */
    @Test
    public void test1() {
        try (RandomAccessFile randomAccessFileReader = new RandomAccessFile(new File("随风起舞.jpg"), "r"); RandomAccessFile randomAccessFileWriter = new RandomAccessFile(new File("随风起舞2.jpg"), "rw")) {
            byte[] byteArray = new byte[1024];
            int length = randomAccessFileReader.read(byteArray);
            while (length != -1) {
                randomAccessFileWriter.write(byteArray, 0, length);
                length = randomAccessFileReader.read(byteArray);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() throws IOException {
        RandomAccessFile randomAccessFileReader = new RandomAccessFile(new File("随风起舞MM.jpg"), "rw");
        byte[] byteBuffer = new byte[1024];
        int length = randomAccessFileReader.read(byteBuffer);
        while (length != -1) {
            length = randomAccessFileReader.read(byteBuffer);
            System.out.println(Arrays.toString(byteBuffer));
        }
    }
    /*
     3.RandomAccessFile 作为输出流时,写出的文件如果不存在,则会新建一个文件
     如果存在,则会覆盖原有文件的内容(从头开始覆盖.)
     4.可以通过相关操作,实现RandomAccessFile 插入'数据的效果.
     */
    @Test
    public void test3() throws IOException {
        File file = new File("hello.txt");
        RandomAccessFile randomAccessFileReaderWriter = new RandomAccessFile(file, "rw");
        // 将指针调用到下标为3的位置
        randomAccessFileReaderWriter.seek(3);
        // 保存指针3后面的数据先到byteBuffer,然后存入的Stringbuilder中.
        StringBuilder stringBuilder = new StringBuilder((int) file.length());
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] byteBuffer = new byte[1024];
        int length = randomAccessFileReaderWriter.read(byteBuffer);
        while (length != -1) {
            stringBuilder.append(new String(byteBuffer,0,length));
//            byteArrayOutputStream.write(byteBuffer, 0,length);
            length = randomAccessFileReaderWriter.read(byteBuffer);
        }

        // 再将指针调到下标为3的位置,然后开始插入对应的字符串.
        randomAccessFileReaderWriter.seek(3);
        randomAccessFileReaderWriter.write("胡东升".getBytes(StandardCharsets.UTF_8));
        // 将之前的StringBuilder中的字符串追加到文本内容的后面.
        randomAccessFileReaderWriter.write(stringBuilder.toString().getBytes(StandardCharsets.UTF_8));
//        randomAccessFileReaderWriter.write(byteArrayOutputStream.toString().getBytes(StandardCharsets.UTF_8));
        randomAccessFileReaderWriter.close();

    }
    
}
