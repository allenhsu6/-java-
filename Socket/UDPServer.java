package Socket;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) throws IOException {
        byte[] b = new byte[1024];
        DatagramPacket dp = new DatagramPacket(b,b.length);
        DatagramSocket socket = new DatagramSocket(7272);

        while (true){
            socket.receive(dp);
            ByteArrayInputStream bais = new ByteArrayInputStream(b);
            DataInputStream dis = new DataInputStream(bais);
            System.out.println(dis.readLong());//调用String类，构造方法为字符串数组，起点，长度
        }
    }
}
