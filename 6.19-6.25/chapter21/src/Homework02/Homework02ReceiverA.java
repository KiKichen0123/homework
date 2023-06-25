package Homework02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 该程序的说明如下：
 * 接收端A
 */
public class Homework02ReceiverA {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8888);

        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
        System.out.println("等待接收问题");
        socket.receive(packet);


        int length = packet.getLength();
        byte[] data = packet.getData();
        System.out.println(new String(data,0,length));

        String s = new String(data,0,length);
        String answer = "";
        if("四大名著是哪些".equals(s)){
            answer = "四大名著是<<红楼梦>>";
        }else{
            answer = "What?";
        }

        data=answer.getBytes();
        DatagramPacket packet1 = new DatagramPacket(data,  data.length,InetAddress.getLocalHost(), 9999);
        socket.send(packet1);

        socket.close();
    }
}
