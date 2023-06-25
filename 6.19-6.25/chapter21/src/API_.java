/**
 * 该程序的说明如下：
 * 获取计算机的主机名和IP地址相关API
 */
import java.net.InetAddress;
import java.net.UnknownHostException;

public class API_ {
    public static void main(String[] args) throws UnknownHostException {
        //1.获取本机InetAddress对象 getLocalHost
        InetAddress localhost = InetAddress.getLocalHost();
        System.out.println(localhost);

        //2.根据指定主机名/域名获取IP地址对象 getByName
        InetAddress host2=InetAddress.getByName("www.baidu.com");
        System.out.println(host2);

        //3.获取InetAddress对象的主机名getHostName
        String host2HostName=host2.getHostName();
        System.out.println(host2HostName);

        //获取InetAddress对象的地址 getHostAddress
        String host2Address = host2.getHostAddress();
        System.out.println(host2Address);
    }
}
