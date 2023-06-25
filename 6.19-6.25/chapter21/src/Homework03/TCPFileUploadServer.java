package Homework03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 该程序的说明如下：
 */
public class TCPFileUploadServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket soc = serverSocket.accept();
        //接收并上传文件
        BufferedInputStream bus = new BufferedInputStream(soc.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bus);
        String s = bytes.toString();
        String musicpath = "";
        if("暗恋的代价".equals(s)){
            musicpath = "A:\\草蜢 - 暗恋的代价.mp3";
        }else{
            musicpath = "A:\\张信哲 - 爱如潮水.mp3";
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(musicpath));
        BufferedOutputStream bos = new BufferedOutputStream(soc.getOutputStream());
        bos.write(StreamUtils.streamToByteArray(bufferedInputStream));
        soc.shutdownOutput();


        bos.close();
        bus.close();
        soc.close();
        serverSocket.close();
    }
}
