package Homework03;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * 该程序的说明如下：
 */
public class TCPFileUploadCilent {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);

        Scanner in = new Scanner(System.in);
        String name = in.next();

        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(name.getBytes());
        socket.shutdownOutput();

        String filepath = "A:\\iii.mp3";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        bos=new BufferedOutputStream(new FileOutputStream(filepath));
        bos.write(StreamUtils.streamToByteArray(bufferedInputStream));


        bufferedInputStream.close();
        bos.close();
        socket.close();

    }
}
