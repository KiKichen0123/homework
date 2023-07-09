package qqcommon;

/**
 * 该程序的说明如下：
 * 表示消息类型
 */
public interface MessageType {
    //在接口中定义了一些常量，不同常量的值，表示不同的消息类型
    String MESSAGE_LOGIN_SUCCEED = "1"; //登录成功
    String MESSAGE_LOGIN_FAIL = "2";    //登录失败
    String MESSAGE_COMM_MES = "3"; //普通信息包
    String MESSAGE_GET_ONLINE_FRIEND="4";   //要求返回在线用户列表
    String MESSAGE_RET_ONLINE_FRIEND="5";   //返回在线用户列表
    String MESSAGE_CLIENT_EXIT = "6";   //客户端请求退出
    String MESSAGE_TO_ALL_MES="7";  //群发消息报
    String MESSAGE_FILE_MES = "8";  //文件消息
}