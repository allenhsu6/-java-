import java.io.*;
import java.util.Date;

public class TestPrintStream2 {
    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            FileWriter fw = new FileWriter("/Users/allenhsu/Desktop/thanks.log",true);
            PrintWriter pw = new PrintWriter(fw);
            String s ;
            while (!(s = br.readLine()).equalsIgnoreCase("exit")) {
                System.out.println(s.toUpperCase());
                pw.println("---------");
                pw.println(s.toUpperCase());

            }
            pw.println("===" + new Date() + "===");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
