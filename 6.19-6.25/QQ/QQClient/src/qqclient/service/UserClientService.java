package qqclient.service;

import qqcommon.Message;
import qqcommon.MessageType;
import qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 该程序的说明如下：
 * 该类完成用户登录验证和用户注册等功能
 */
public class UserClientService {
    //因为可能在其他地方使用user信息，因此作出成员属性
    private User u = new User();
    //因为Socket在其他地方也可能使用，因此作出属性
    private Socket socket;

    //根据userId 和 pwd 到服务器验证该用户是否合法
    public boolean checkUser(String userId,String pwd){
        boolean b = false;
        //创建User对象
        u.setUserId(userId);
        u.setPasswd(pwd);

        //连接到服务端，发送u对象
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"),9999);
            //得到ObjectOutputStream对象
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(u); //发送User对象

            //读取从服务器回复的Message对象
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message ms =(Message) ois.readObject();

            //登录OK
            if(ms.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)){
                //创建一个和服务端保持通信的线程 -> 创建一个类 ClientConnectServerThread
                ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
                //启动客户端的线程
                clientConnectServerThread.start();
                ManageClientConnectServerThread.addClientConnectServerThread(userId,clientConnectServerThread);
                b = true;
            }else{
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }
}
