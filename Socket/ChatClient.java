package Socket;

import java.io.*;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) {
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            String string;
            while(!(string = br.readLine()).equalsIgnoreCase("bye")){
                //System.out.println(string);
                Socket s = new Socket("127.0.0.1", 5888);
                DataOutputStream clientSpeck = new DataOutputStream(s.getOutputStream());
                clientSpeck.writeUTF(string);
                DataInputStream serverRead = new DataInputStream(s.getInputStream());
                System.out.println("服务器："+serverRead.readUTF());
                //s.close();
            }
            //br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
