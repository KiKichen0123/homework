package upload;

import com.sun.security.ntlm.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 该程序的说明如下：
 */
public class TCPFileUploadServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket soc = serverSocket.accept();

        BufferedInputStream bus = new BufferedInputStream(soc.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bus);

        String destpath = "src\\qie2.jpg";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destpath));
        bos.write(bytes);

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(soc.getOutputStream()));
        writer.write("收到图片");
        writer.flush();

        writer.close();
        bos.close();
        bus.close();
        soc.close();
        serverSocket.close();
    }
}
