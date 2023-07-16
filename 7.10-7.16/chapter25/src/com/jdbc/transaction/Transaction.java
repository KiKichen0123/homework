package com.jdbc.transaction;

import com.jdbc.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 该程序的说明如下：
 * 在 jdbc 中如何使用事务
 */
public class Transaction {

    public void noTransaction(){
        //操作转账业务
        Connection connection = null;
        String sql = "update account set balance = balance - 100";
        String sql2 = "update account set balance = balance + 100";
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();

            int i = 1/0;
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(null,preparedStatement,connection);
        }
    }

    public void useTransaction(){
        Connection connection = null;
        String sql = "update account set balance - 100";
        String sql2 = "update account set balance + 100";
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            //将connection设置为不自动提交
            connection.setAutoCommit(false);    //开启事务
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();

            int i = 1/0;

            preparedStatement=connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JDBCUtils.close(null,preparedStatement,connection);
        }

    }
}
