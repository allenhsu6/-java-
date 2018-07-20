package GaoQi;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * UDP通信的服务器端
 */
public class Example12_3_2 {
    public static void main(String[] args) throws IOException {
        byte[] bytes = new byte[1024];
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);

        // 这个方法的关键是：接收回来的信息是放在参数datagramPacket中的
        // 与传出数据恰好相反
        datagramSocket.receive(datagramPacket);
        String s = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
        System.out.println(s);
    }
}
