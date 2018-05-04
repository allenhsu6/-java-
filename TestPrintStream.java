import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;


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
