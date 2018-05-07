package Socket;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        //有用的测试：如何传递long类型
        long l = 10000L;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeLong(l);
        byte[] b = baos.toByteArray();
        DatagramPacket dp = new DatagramPacket(b,b.length, new InetSocketAddress("127.0.0.1", 7272));
        DatagramSocket socket = new DatagramSocket(9999);
        socket.send(dp);
        socket.close();
    }
}
