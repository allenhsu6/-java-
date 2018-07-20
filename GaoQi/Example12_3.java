package GaoQi;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * UDP通信的实现之客户端
 */
public class Example12_3 {
    public static void main(String[] args) throws IOException {
        byte[] bytes = "有志者事竟成".getBytes();
        // 数据打包，并指定
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length,
                new InetSocketAddress("localhost", 9999));
        DatagramSocket client = new DatagramSocket();
        client.send(datagramPacket);
        client.close();
    }
}
