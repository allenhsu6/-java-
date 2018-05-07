package Socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static java.lang.Thread.sleep;

public class TCPClient2 {
    public static void main(String[] args) {
        Socket s;
        {
            try {
                s = new Socket("127.0.0.1", 6677);
                sleep(10000);
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                dos.writeUTF("hello world");
                dos.close();
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
