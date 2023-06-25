package Homework02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 * 该程序的说明如下：
 * 发送端B
 */
public class Homework02SenderB {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9999);

        System.out.println("请输入问题：");
        Scanner in = new Scanner(System.in);
        String s = in.next();
        byte[] bytes = s.getBytes();
        DatagramPacket packet = new DatagramPacket(bytes, 0,bytes.length, InetAddress.getLocalHost(),8888);
        socket.send(packet);

        byte[] bytes1 = new byte[1024];
        DatagramPacket packet1 = new DatagramPacket(bytes, bytes.length);
        socket.receive(packet1);

        int length = packet1.getLength();
        byte[] data = packet1.getData();
        s=new String(data,0,length);
        System.out.println(s);

        socket.close();
    }
}
