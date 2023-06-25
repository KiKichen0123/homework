package qqserver.service;

import qqcommon.Message;
import qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * 该程序的说明如下：
 * 该类的一个对象和某个客户端保持通信
 */
public class ServerConnectClientThread extends Thread{

    private Socket socket;
    private  String userId;

    public ServerConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    public Socket getSocket() {
        return socket;
    }

    public void run(){
        while(true){
            try {
                System.out.println("服务端和客户端" + userId + "保持通信,读取数据...");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message=(Message) ois.readObject();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
