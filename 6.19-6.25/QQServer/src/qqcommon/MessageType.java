package qqcommon;

/**
 * 该程序的说明如下：
 * 表示消息类型
 */
public interface MessageType {
    //在接口中定义了一些常量，不同常量的值，表示不同的消息类型
    String MESSAGE_LOGIN_SUCCEED = "1"; //登录成功
    String MESSAGE_LOGIN_FAIL = "2";    //登录失败
}
