package com.huawei.nce.javabase.day14.block;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/1 15:13
 */
public class JDBCUtils {
    private static DataSource dataSource = null;

    // 通过静态代码块给dataSource 属性赋值
    static {
        InputStream inputStream = null;
        inputStream = DBCPTest.class.getClassLoader().getResourceAsStream("dbcp.properties");
        Properties pros = new Properties();
        try {
            pros.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //调用BasicDataSourceFactory的静态方法，获取数据源。
      // dataSource = BasicDataSourceFactory.createDataSource(pros);
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        return connection;
    }
}
