import java.io.File;

/**
 * 该程序的说明如下：
 * 获取文件的信息，相关方法
 */
public class FileInformation {
    public static void main(String[] args) {
        File file = new File("A:\\news1.txt");

        System.out.println("文件名字=" + file.getName());
        System.out.println("文件绝对路径=" + file.getAbsolutePath());
        System.out.println("文件父级目录=" + file.getParent());
        System.out.println("文件大小(字节)=" + file.length());
        System.out.println("文件是否存在=" + file.exists());
        System.out.println("是不是一个文件=" + file.isFile());
        System.out.println("是不是一个目录=" + file.isDirectory());
    }
}
