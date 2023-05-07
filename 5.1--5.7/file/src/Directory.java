import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * 该程序的说明如下：
 */
public class Directory {
    public static void main(String[] args) {

    }
@Test
    public void m1(){
        File file = new File("A:\\news1.txt");
        if(file.exists()){
            if(file.delete()){
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
            }
        }else{
            System.out.println("该文件不存在....");
        }
    }

    @Test
    public void m2(){
        File file = new File("A:\\demo");
        file.mkdir();
        if(file.exists()){
            if(file.delete()){
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
            }
        }else{
            System.out.println("该文件不存在....");
        }
    }

    @Test
    public void m3(){
        File file = new File("A:\\demo\\a\\b\\c");

        if(file.exists()){
            System.out.println("该目录已存在");
        }else{
            if (file.mkdirs()){
                System.out.println("创建成功!");
            }else{
                System.out.println("创建失败...");
            }
        }
    }
}
