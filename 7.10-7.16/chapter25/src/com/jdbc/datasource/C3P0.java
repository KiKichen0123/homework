package com.jdbc.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 该程序的说明如下：
 * C3P0的使用
 */
public class C3P0 {

    @Test
    public static void main(String[] args) throws IOException, PropertyVetoException, SQLException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        //给数据源comboPooledDataSource 设置相关的参数
        //连接管理是由 comboPooledDataSource 来管理
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);

        //设置初始化连接数
        comboPooledDataSource.setInitialPoolSize(10);
        //最大连接数
        comboPooledDataSource.setMaxPoolSize(50);

        long start = System.currentTimeMillis();
        for(int i = 0; i < 5000; i++){
            Connection connection = comboPooledDataSource.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    //第二种方式 使用配置文件模板来完成

    //1. 将c3p0 提供的 c3p0.config.xml 拷贝到 src目录下
    //2. 该文件指定了连接数据库和连接池的相关参数

    @Test
    public void testC3P0_02() throws SQLException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("student01");
        long start = System.currentTimeMillis();
        for(int i = 0; i < 5000; i++){
            Connection connection = comboPooledDataSource.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }

}
