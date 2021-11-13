package com.huawei.nce.javabase.day28;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/11/10 23:12
 */
public class ClassLoaderTest {
    @Test
    public void test1() {
        ClassLoader systemClassLoader = ClassLoaderTest.class.getClassLoader();
        // sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(systemClassLoader);
        ClassLoader extensionClassLoader = systemClassLoader.getParent();
        // sun.misc.Launcher$ExtClassLoader@4517d9a3
        System.out.println(extensionClassLoader);
        ClassLoader parent = extensionClassLoader.getParent();
        // null
        System.out.println(parent);

        ClassLoader classLoader = String.class.getClassLoader();
        // null
        System.out.println(classLoader);
    }

    @Test
    public void test2() {
        Properties properties = new Properties();
        // 默认读取当前工程下的
        try (InputStream inputStream = new FileInputStream("jdbchds.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String username = properties.getProperty("username");

        String userName = properties.getProperty("userName");

        String password = properties.getProperty("password");
        //username: 吴雨霏, password: abc123
        //userName: null
        System.out.println("username: " + username + ", password: " + password);
        System.out.println("userName: " + userName);
    }
    
    @Test
    public void test3() throws IOException {
        Properties properties = new Properties();
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        // maven项目,默认读取main/resources目录下的文件
        // 普通的java项目,默认读取的是src目录下的文件
        InputStream resourceAsStream = classLoader.getResourceAsStream("jdbchds.properties");
        properties.load(resourceAsStream);
        String username = properties.getProperty("username");

        String password = properties.getProperty("password");
        System.out.println("username: " + username + ", password: " + password);
    }
}
