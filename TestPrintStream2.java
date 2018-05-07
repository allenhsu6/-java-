import java.io.*;
import java.util.Date;
//将终端输入的文字，通过buffer包装，同时输出到终端和指定文件
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
