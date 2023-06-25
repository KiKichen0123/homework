package UDP;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

/**
 * 该程序的说明如下：
 */
public class UDPSenderB {
    public static void main(String[] args) throws IOException {
        //因为是在同一个主机上的接收端和发送端，所以端口要不一样
        //接收端与发送端的端口表示用来接收数据的，并不是两者连接的
        DatagramSocket socket = new DatagramSocket(9998);

        byte[] bytes = "hello,明天吃火锅！".getBytes();
        DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length, InetAddress.getByName("127.0.0.1"), 9999);
        socket.send(packet);

        byte[] bytes1 = new byte[1024];
        DatagramPacket packet1 = new DatagramPacket(bytes1, bytes1.length);
        socket.receive(packet1);
        int length = packet1.getLength();
        byte[] data = packet1.getData();
        System.out.println(new String(data,0,length));

        socket.close();

    }
}
