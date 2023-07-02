package qqclient.service;

import qqcommon.Message;
import qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * 该程序的说明如下：
 * 该类/对象，提供和消息相关的服务方法
 */
public class MessageClientService {

    public void sendMessageToAll(String content,String senderId){
        //构建message
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_TO_ALL_MES); //群发消息
        message.setSender(senderId);
        message.setContent(content);
        message.setSendTime(new Date().toString());
        System.out.println(senderId + " 对大家说：" + content);

        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void sendMessageToOne(String content,String senderId,String getterId){
        //构建message
        Message message = new Message();
        message.setSender(senderId);
        message.setSender(getterId);
        message.setContent(content);
        message.setSendTime(new Date().toString()); //发送时间设置到message对象
        System.out.println(senderId + " 对 " + getterId + " 说: " + content);

        //发送到服务端
        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
