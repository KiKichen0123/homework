package Homework01;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 该程序的说明如下：
 */
public class Homework01Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9998);

        //发送name

            OutputStream outputStream = socket.getOutputStream();
            BufferedWriter buf = new BufferedWriter(new OutputStreamWriter(outputStream));
            Scanner scanner = new Scanner(System.in);
            String data = scanner.next();
            buf.write(data);
            buf.newLine();
            buf.flush();


            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String s = reader.readLine();
            System.out.println(s);

        reader.close();
        buf.close();
        socket.close();
    }
}
