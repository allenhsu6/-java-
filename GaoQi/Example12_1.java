package GaoQi;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URL;

public class Example12_1 {
    public static void main(String[] args) throws IOException {

        InetAddress inetAddress = InetAddress.getLocalHost();
        // 他的背后是跟计算机操作系统打交道
        // 通过java本身提供的包，通过java的虚拟机和操作系统做联络
        // 这里就是拿到ip和域名的各种手段
        System.out.println(inetAddress.getHostAddress() + " " + inetAddress.getHostName());

        InetAddress inetAddress1 = InetAddress.getByName("www.sina.com");
        System.out.println(inetAddress1.getHostAddress() + " " + inetAddress1.getHostName());

        InetAddress inetAddress2 = InetAddress.getByName("192.168.0.1");
        System.out.println(inetAddress2.getHostAddress() + " " + inetAddress2.getHostName());

        // 测试下socket通信中的一个类
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 8080);
        System.out.println(inetSocketAddress.getAddress() + "  " + inetSocketAddress.getHostName() + "  " + inetSocketAddress.getHostString());

        //URL唯一地标记计算机上的资源
        URL url = new URL("https://github.com/jawil/blog/issues/14");
        System.out.println("ip地址后面的内容：" + url.getFile());
        System.out.println("主机名：" + url.getHost());
        System.out.println("路径" + url.getPath());
        System.out.println(url.openConnection());
        System.out.println(url.getQuery());

        // 相对路径构建URL对象
        URL url1 = new URL("https://www.jianshu.com/writer#/notebooks");
        URL url2 = new URL(url1, "/27107159/notes/31093626/preview");
        System.out.println(url2);
    }
}
