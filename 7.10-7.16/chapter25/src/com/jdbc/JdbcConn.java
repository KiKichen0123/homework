package com.jdbc;

import org.junit.Test;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 该程序的说明如下：
 */

public class JdbcConn {

    @Test
    public void connect05() throws IOException, ClassNotFoundException, SQLException {
        //通过Properties对象获取配置文件的信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));

        //获取相关的值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);

        String sql = "INSERT INTO actor VALUES(3,'kangkang'),(4,'jery'),(5,'liming');";
        String sql2="UPDATE actor SET name = 'cqq' WHERE id = 1;";
        String sql3="DELETE  FROM actor WHERE id = 3;";
        Statement statement = connection.createStatement();
//        int i = statement.executeUpdate(sql);
        int i1 = statement.executeUpdate(sql2);
        int i2 = statement.executeUpdate(sql3);
//        System.out.println(i > 0 ? "成功": "失败");
        System.out.println(i1 > 0 ? "成功": "失败");
        System.out.println(i2 > 0 ? "成功": "失败");
        statement.close();
        connection.close();

    }

}
