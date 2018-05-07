package Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss  = new ServerSocket(5888);
            while (true) {
                Socket socket = ss.accept();
                DataInputStream serverRead = new DataInputStream(socket.getInputStream());
                System.out.println("客户端："+serverRead.readUTF());
                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(isr);
                String string = br.readLine();
                //while(!(string = br.readLine()).equalsIgnoreCase("bye")){
                    //System.out.println(string);
                    DataOutputStream serverSpeck = new DataOutputStream(socket.getOutputStream());
                    serverSpeck.writeUTF(string);
                //}
                //br.close();
                //isr.close();
                //ss.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
