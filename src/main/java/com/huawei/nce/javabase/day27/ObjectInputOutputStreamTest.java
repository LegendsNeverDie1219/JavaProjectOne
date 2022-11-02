package com.huawei.nce.javabase.day27;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/11/3 8:08
 */
public class ObjectInputOutputStreamTest {
    /**
     * 内存中的数据输出到磁盘中
     * 说明:
     * 1.输出操作,对应的文件可以不存在,不会报异常. 但是该文件所在的目录必须存在.否则会异常
     * 2.输出操作, File对象对应磁盘中的文件如果不存在, 则新建一个文件
     *           File对象对应磁盘中的文件如果存在:
     *               如果使用的构造器是FileWriter(file,false),则是覆盖动作
     *               如果使用的构造器是FileWriter(file,true),则是在原文件的基础上追加内容.
     */

    /**
     * IDEA:
     * 如果是单元测试,则相对路径是当前的Module
     * 如果是main方法,则相对路径是当前的工程.
     */
    /**
     * 常见的编码表:
     * ASCII:(美国编码表):
     * 用一个字节的7位表示所有的英文字符.
     * ISO8859-1(欧洲编码表):
     * 融合了欧洲字符. 用一个字节的8位表示表示所有的字符.
     * GBK:(中国编码表)
     * 融合了中文字符. 用两个字节表示所有的字符.
     * <p>
     * Unicode:(国际编码表):
     * 融合了人类所有的字符,用两个字节表示所有的字符
     * <p>
     * UTF-8:变长的编码方式
     * 可以用1-4个字节来表示一个字符.
     * <p>
     * 编码后后面学习的启示:
     * 客户端/浏览器  -> 后台服务器(java,GO,python,Node.js,php)  -> 数据库服务器
     * 要求前前后后的字符集编码都要一致. UTF-8
     */
    @Test
    public void testOutputStreamWriter() throws IOException {
        //运行两次.
        // abcdef
        FileWriter fileWriter = new FileWriter("writer.txt");
        fileWriter.write("abcdef");
        fileWriter.flush();
        fileWriter.close();
        // 123456123456
        FileWriter fileWriterTwo = new FileWriter("writer2.txt", true);
        fileWriterTwo.write("123456");
        fileWriterTwo.flush();
        fileWriterTwo.close();
    }

    /**
     * 对象流:
     * ObjectInputStream ObjectOutputStream
     * 用于存储和读取基本数据类型/对象的数据流.
     * 可以java中的对象写入的数据源中(磁盘中的文件/网络中的某一个节点),也可以把数据源中的数据还原成一个java对象
     *
     * 序列化:用ObjectOutputStream将对象中的数据/基本类型中的数据,写出到数据源中
     * 反序列化: 用ObjectInputStream读取数据源(磁盘/网络中的某一个节点)中的数据. 进而转化为对象/基本类型的数据.
     *
     * ObjectOutputStream 和ObjectInputStream不能序列化/反序列化,static /transient 修饰的属性.
     */
    /**
     * 对象的序列化机制:
     * 允许将java内存中的对象转化为与操作系统无关的二进制的字节流.
     * 进而保存到磁盘上的文件中.或者基于网络从一个网络节点传输到另一个网络点,
     * <p>
     * 当其他程序获取了这种字节流, 就可以恢复成一个对象.
     * <p>
     * 前提: 该对象所在的类必须实现Serializable标识接口, 并且对象中属性也是可以序列化的.同时也要在类中添加serialVersionUID全局常量字段.
     * 否则会报NotSerializableException的异常.
     */
    @Test
    public void testObjectOutputInputStreamTest() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("object.dat"))) {
            objectOutputStream.writeObject(new String("我爱北京天安门广场"));
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("object.dat"))) {
            String str = (String) objectInputStream.readObject();
            System.out.println(str);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testObjectOutputInputStreamTest2() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("person.dat"))) {
            List<Person> peopleList = Lists.newArrayList(new Person("胡歌", 30), new Person("杨幂", 30));
            objectOutputStream.writeObject(peopleList);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("person.dat"))) {
            List<Person> str = (List<Person>) objectInputStream.readObject();
            System.out.println(str);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4() {

    }

}
