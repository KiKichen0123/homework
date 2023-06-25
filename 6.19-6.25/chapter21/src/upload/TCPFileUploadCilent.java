package upload;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 该程序的说明如下：
 */
public class TCPFileUploadCilent {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);

        String filepath="A:\\qie.jpg";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filepath));


        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write( StreamUtils.streamToByteArray(bis));
        socket.shutdownOutput();

        //接收从服务器回复的消息
        InputStream inputStream = socket.getInputStream();
        String s = StreamUtils.streamToString(inputStream);
        System.out.println(s);

        inputStream.close();
        bos.close();
        bis.close();
        socket.close();

    }
}
