package Socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPserver {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(6677);
        while (true){
            Socket s = ss.accept();
            DataInputStream dis = new DataInputStream(s.getInputStream());
            System.out.println(dis.readUTF());
            dis.close();
            s.close();
            //System.out.println("congratulation! a client connected!");
        }
    }
}
