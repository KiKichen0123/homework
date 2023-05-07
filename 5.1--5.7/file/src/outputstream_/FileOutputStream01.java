package outputstream_;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 该程序的说明如下：
 * 文件字节输出流
 */
public class FileOutputStream01 {
    public static void main(String[] args) {

    }

    @Test
    /**
     * 演示使用FileOutputStream 将数据写到文件中,
     * 如果该文件不存在，则创建该文件
     */
    public void writerFile(){
        String filePath = "A:\\a.txt";
        FileOutputStream fileOutputStream = null;

        try {
            //1. new FileOutputStream(filePath) 创建方式，当写入内容是，会覆盖原来的内容
            //2. new FileOutputStream(filePath, true) 创建方式，当写入内容是，是追加到文件后面
            fileOutputStream = new FileOutputStream(filePath, true);
            //写入一个字节
            fileOutputStream.write('H');
            //写入字符串
            String str = "hello,world";
            fileOutputStream.write(str.getBytes());
              /*
            write(byte[] b, int off, int len) 将 len字节从位于偏移量 off的指定字节数组写入此文件输出流
             */
            fileOutputStream.write(str.getBytes(),0,5);
            System.out.println("创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
