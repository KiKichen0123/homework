import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * 该程序的说明如下：
 * 演示创建文件方式
 */
public class FileCreate {
    public static void main(String[] args) {

    }

    //方式1 new File(String pathname)
    @Test
    public void create01(){
        String filePath = "A:\\news1.txt";
        File file = new File(filePath);

        try {
            file.createNewFile();
            System.out.println("文件创建成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    //方式2 new File(File parent,String child) 根据父目录文件+子路径构建
    public void create02(){
        File parentFile = new File("A:\\");
        String fileName = "news2.txt";
        //这里的file对象，在java程序中，只是一个对象
        File file = new File(parentFile,fileName);

        try {
            //只有执行了createNewFile方法，才会真正的在磁盘创建该文件
            file.createNewFile();
            System.out.println("创建成功~");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    //方式3，new File(String parent,String child)，根据父目录+子路径构建
    //一个父目录下，可以创建多个子路径
    public void create03(){
        String parentPath = "A:\\"; //第一个斜杠是转义符 \\ || /
        String fileName = "news3.txt";
        File file = new File(parentPath, fileName);

        try {
            file.createNewFile();
            System.out.println("创建成功！！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
