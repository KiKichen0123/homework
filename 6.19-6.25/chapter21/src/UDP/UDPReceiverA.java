package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 该程序的说明如下：
 * 接收端
 */
public class UDPReceiverA {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9999);

        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
        //socket对象在端口上接收到的数据
        socket.receive(packet);

        //把packet 进行拆包，取出数据，并显示
        //实际接收到的数据长度
        int length = packet.getLength();
        //接收到的数据
        byte[] b = packet.getData();
        System.out.println(new String(b,0,length));

        byte[] data = "好，一言为定".getBytes();
        DatagramPacket packet1 = new DatagramPacket(data, 0, data.length, InetAddress.getLocalHost(), 9998);
        socket.send(packet1);

        socket.close();
    }
}
