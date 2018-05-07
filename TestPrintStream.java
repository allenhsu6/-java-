import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
//把if循环中的东西通过print重新定位，打印到了目标文件中
public class TestPrintStream {
    public static void main(String[] args) {
        PrintStream ps = null;
        try {
            FileOutputStream ops = new FileOutputStream("/Users/allenhsu/Desktop/thanks.dat");
            ps = new PrintStream(ops);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (ps != null){
            System.setOut(ps);
        }
        int n = 100;
        for (char i = 0; i < 60000; i++) {
            System.out.print(i+" ");
            if (i == n)
                System.out.println();
                n+=i;
        }
    }
}
