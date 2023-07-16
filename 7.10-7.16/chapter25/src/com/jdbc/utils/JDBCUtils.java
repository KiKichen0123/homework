package com.jdbc.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * 该程序的说明如下：
 * 这是一个工具类，完成mysql的连接和关闭资源
 */
public class JDBCUtils {
    //定义相关的属性（4个），因为只需要一份，所以做成static
    private static String user;//用户名
    private static String password; //密码
    private static String url;  //url
    private static String driver;   //驱动名

    //在static 代码块去初始化
    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src\\mysql.properties"));
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
        } catch (IOException e) {
            //将编译异常 转成 运行异常
            //调用者，可以选择捕获该异常，也可以选择默认处理该异常
            throw new RuntimeException(e);
        }

    }

    public static Connection getConnection() throws SQLException {

        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //关闭相关资源
    public static void close(ResultSet set, Statement statement, Connection connection){
        try {
            if(set != null){
                set.close();
            }
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
