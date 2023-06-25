package Homework01;

import com.sun.security.ntlm.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 该程序的说明如下：
 */
public class Homework01Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9998);
        Socket socket = serverSocket.accept();

        //收到消息并输出
        InputStream inputStream = socket.getInputStream();
        BufferedReader read = new BufferedReader(new InputStreamReader(inputStream));
        String s = read.readLine();

        String answer = "";
        if("name".equals(s)){
            answer="我是陈淇淇";
        }else if("hobby".equals(s)){
            answer="玩电脑";
        }else{
            answer = "你说啥";
        }

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        writer.write(answer);
        writer.newLine();
        writer.flush();

        writer.close();
        read.close();
        socket.close();
        serverSocket.close();
    }
}
