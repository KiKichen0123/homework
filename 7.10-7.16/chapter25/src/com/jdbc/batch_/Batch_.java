package com.jdbc.batch_;

import com.jdbc.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 该程序的说明如下：
 * java的批处理
 */
public class Batch_ {

    //传统方法
    public void noBatch() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into admin2 values(null,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("开始执行");
        long start = System.currentTimeMillis();    //开始时间
        for(int i = 0;i < 5000;i++){
            preparedStatement.setString(1,"jack" + i);
            preparedStatement.setString(2,"666");
            preparedStatement.executeUpdate();
        }
        long end = System.currentTimeMillis();
        System.out.println("传统的方式 耗时=" + (end - start));
        JDBCUtils.close(null,preparedStatement,connection);
    }

    //批量方式添加数据
    public void batch() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into admin2 values(null,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("开始执行");
        long start = System.currentTimeMillis();
        for(int i = 0;i < 5000;i++){
            preparedStatement.setString(1,"jack" + i);
            preparedStatement.setString(2,"666");
            //将sql语句加入到批处理包中
             /*
            //1. //第一就创建 ArrayList - elementData => Object[]
            //2. elementData => Object[] 就会存放我们预处理的sql语句
            //3. 当elementData满后,就按照1.5扩容
            //4. 当添加到指定的值后，就executeBatch
            //5. 批量处理会减少我们发送sql语句的网络开销，而且减少编译次数，因此效率提高
            public void addBatch() throws SQLException {
                synchronized(this.checkClosed().getConnectionMutex()) {
                    if (this.batchedArgs == null) {

                        this.batchedArgs = new ArrayList();
                    }

                    for(int i = 0; i < this.parameterValues.length; ++i) {
                        this.checkAllParametersSet(this.parameterValues[i], this.parameterStreams[i], i);
                    }

                    this.batchedArgs.add(new PreparedStatement.BatchParams(this.parameterValues, this.parameterStreams, this.isStream, this.streamLengths, this.isNull));
                }
            }

             */
            preparedStatement.addBatch();
            if((i+1)%1000 == 0){
                preparedStatement.executeBatch();
                //清空
                preparedStatement.clearBatch();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("批量方式 耗时=" + (end - start));
        JDBCUtils.close(null,preparedStatement,connection);
    }
}
