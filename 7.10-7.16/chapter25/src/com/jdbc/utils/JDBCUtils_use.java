package com.jdbc.utils;

import org.junit.Test;

import java.sql.*;

/**
 * 该程序的说明如下：
 *该类演示如何使用JDBCUtils工具类，完成dml 和 select
 */
public class JDBCUtils_use {

    @Test
    public void testSelect() {
        Connection connection = null;
        String sql = "select * from actor where id = ?";
        PreparedStatement preparedStatement = null;
        ResultSet set = null;

        try {
            connection = JDBCUtils.getConnection();
            System.out.println(connection.getClass());
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,5);
            set = preparedStatement.executeQuery();
            while(set.next()){
                int id = set.getInt("id");
                String name = set.getString("name");
                String sex = set.getString("sex");
                Date borndate = set.getDate("borndate");
                String phone = set.getString("phone");
                System.out.println(id + "\t" + name + "\t" + sex + "\t" + borndate + "\t" + phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(set,preparedStatement,connection);
        }
    }

    @Test
    public void testDML(){
        Connection connection = null;
        String sql = "update actor set name = ? where id = ?";
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"周星驰");
            preparedStatement.setInt(2,4);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(null,preparedStatement,connection);
        }
    }

}
