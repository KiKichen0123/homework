import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 该程序的说明如下：
 * 演示FileInputStream的代码
 */
public class FileInputStream_ {

    public static void main(String[] args) {

    }

    /**
     * 演示读取文件
     * 单个字节的读取，效率比较低
     */
    @Test
    public void readFile01(){
        String filePath="A:\\hello.txt";
        File file = new File(filePath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileInputStream fileInputStream = null;

        int readDate = 0;
        try {
            //创建 FileInputStream 对象，用于读取文件
            fileInputStream = new FileInputStream(filePath);
            //从该输入流读取一个字节的数据。如果没有输入可用，此方法将阻止
            //返回-1，表示读取完毕
            while ((readDate = fileInputStream.read()) != -1){
                System.out.print((char)readDate);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭文件流，释放资源
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 演示读取文件
     * 使用byte[] b 字节数组
     */
    @Test
    public void readFile02(){
        String filePath="A:\\hello.txt";
        File file = new File(filePath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileInputStream fileInputStream = null;
        int readDate = 0;
        //字节数组
        byte[] buf = new byte[8];//一次性读取8个字节
        int readLen = 0;
        try {
            //创建 FileInputStream 对象，用于读取文件
            fileInputStream = new FileInputStream(filePath);
            //从该输入流读取一个字节的数据。如果没有输入可用，此方法将阻止
            //如果返回-1，表示读取完毕
            //如果读取正常，返回实际读取的字节数
            while ((readLen=fileInputStream.read(buf)) != -1){
                System.out.print(new String(buf,0,readLen));//若超出8个字节，则剩下的字节从数组第一个又开始存入输出
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭文件流，释放资源
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
