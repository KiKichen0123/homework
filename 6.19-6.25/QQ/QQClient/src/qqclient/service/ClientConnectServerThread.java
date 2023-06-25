package qqclient.service;

import qqcommon.Message;
import qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * 该程序的说明如下：
 */
public class ClientConnectServerThread extends Thread {
    //该线程需要持有Socket
    private Socket socket;

    //构造器可以接受一个Socket对象
    public ClientConnectServerThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        //因为Thread 需要在后台和服务器通信，因此我们while循环
        while(true){
            try {
                System.out.println("客户端线程，等待读取从服务端发送的消息");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                //如果服务器没有发送Message对象，线程会阻塞在这里
                Message message = (Message) ois.readObject();
                //判断这个message类型，然后做相应的业务处理
                //如果是读取到的是 服务端返回的在线用户列表
//                if(message.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED))
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

    public Socket getSocket() {
        return socket;
    }
}
