package reader_;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 该程序的说明如下：
 * 字符流的输入流
 */
public class FileReader_ {
    public static void main(String[] args) {

    }

    @Test
    /**
     * 单个字符读取文件
     */
    public void readFile01(){
        String filePath = "A:\\news2.txt";
        FileReader fileReader = null;
        int data = 0;

        try {
            fileReader = new FileReader(filePath);
            //循环读取 使用read, 单个字符读取
            while((data = fileReader.read()) != -1){
                System.out.print((char)data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    /**
     * 多个字符读取文件
     */
    public void readFile02(){
        System.out.println("多个字符读取文件....");
        String filePath = "A:\\news2.txt";
        FileReader fileReader = null;
        int readLen = 0;
        char[] buf = new char[8];

        try {
            fileReader = new FileReader(filePath);
            //循环读取 使用read, 单个字符读取
            while((readLen = fileReader.read(buf)) != -1){
                System.out.print(new String(buf,0,readLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
