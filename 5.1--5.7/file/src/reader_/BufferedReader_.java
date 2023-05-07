package reader_;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * 该程序的说明如下：
 * 演示bufferedReader 使用
 */
public class BufferedReader_ {
    public static void main(String[] args) throws Exception {

        String filePath = "A:\\a.java";
        //创建bufferedReader
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        //读取
        String line; //按行读取, 效率高
        //说明
        //1. bufferedReader.readLine() 是按行读取文件
        //2. 当返回null 时，表示文件读取完毕
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        bufferedReader.close();

    }
}
