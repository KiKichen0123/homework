package qqserver.service;

import qqcommon.Message;
import qqcommon.MessageType;
import qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/**
 * 该程序的说明如下：
 * 这是服务器，在监听9999，等待客户端的连接并保持通信
 */
public class QQServer {

    private ServerSocket ss = null;

    //创建一个集合，存放多个用户，如果是这些用户登录，就认为是合法
    //可以使用 ConcurrentHashMap, 可以处理并发的集合，没有线程安全
    //HashMap 没有处理线程安全，因此在多线程情况下是不安全
    //ConcurrentHashMap 处理的线程安全,即线程同步处理, 在多线程情况下是安全

    private static HashMap<String,User> validUsers = new HashMap<String, User>();

    //在静态代码块，初始化 validUsers
    static{
        validUsers.put("陈淇淇",new User("陈淇淇","1234"));
        validUsers.put("王晓青",new User("王晓青","1234"));
        validUsers.put("陈晶晶",new User("陈晶晶","1234"));
        validUsers.put("刘玮鹏",new User("刘玮鹏","1234"));
    }

    //验证用户是否有效的方法
    public boolean checkUser(String userId,String passwd){
        User user = validUsers.get(userId);
        //过关的验证方式
        if(user == null){
            return false;
        }
        if(!(user.getPasswd().equals(passwd))){
            return false;
        }

        return true;
    }

    public QQServer() {
        //端口可以写在配置文件
        try {
            System.out.println("服务端在9999端口监听....");

            ss = new ServerSocket(9999);
            //当和某个客户端连接后，会继续监听，因此while
            while(true){
                Socket socket = ss.accept();
                //对象输入流
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                //对象输出流
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                //读取客户端发送的User对象
                User user =(User) ois.readObject();
                //创建一个Message对象，准备回复客户端
                Message message = new Message();
                //验证用户方法
                if(checkUser(user.getUserId(), user.getPasswd())){
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    //将message对象回复客户端
                    oos.writeObject(message);
                    //创建一个线程，和客户端保持通信，该线程需要持有socket对象
                    ServerConnectClientThread serverConnectClientThread = new ServerConnectClientThread(socket, user.getUserId());
                    serverConnectClientThread.start();

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
