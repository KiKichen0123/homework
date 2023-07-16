package com.jdbc.myjdbc;

/**
 * 该程序的说明如下：
 * 我们规定的jdbc接口(方法)
 */
public interface JdbcInterface {

    //连接
    public Object getConnection() ;
    //crud
    public void crud();
    //关闭连接
    public void close();
}
