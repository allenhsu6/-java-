package Socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1",6677);
            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeUTF("this is the first time i have connected with you!");
            dos.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
