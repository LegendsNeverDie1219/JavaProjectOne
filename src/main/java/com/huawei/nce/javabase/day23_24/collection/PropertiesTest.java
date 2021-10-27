package com.huawei.nce.javabase.day23_24.collection;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/24 15:07
 */
public class PropertiesTest {
    public static void main(String[] args){
        // Properties : Hashtable的子类,常用来处理配置文件,其中key,value 都是String
        //public class Properties extends Hashtable<Object,Object> {}
        Properties properties = new Properties();
        // 获取用户的工作目录,以便于知道该往哪里去放置文件
        // E:\IdeaProjects\javaproject
        System.out.println(System.getProperty("user.dir"));
        // 造文件对象
        File file = new File("E:\\IdeaProjects\\javaproject\\jdbc.properties");
        FileInputStream fileInputStream = null;
        try {
            // 造输入流对象.
            fileInputStream = new FileInputStream(file);
            // 操作流.把磁盘的文件读入的Properties对象中(角度: 内存的角度/程序的角度)
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        Object value = properties.get("username");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        // value: root_tmd
        System.out.println("value: " + value);
        // name: root_tmd, password: 7758250
        System.out.println("name: " + username + ", password: " + password);
    }
}
