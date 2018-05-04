import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Testtransform {
    public static void main(String[] args) {

        try {
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("/Users/allenhsu/Desktop/thanks.txt"));
            System.out.println(osw.getEncoding());
            osw.write("自律才能王道");
            System.out.println(osw.getEncoding());
            osw.close();
            //在后面加true，防止覆盖
            osw = new OutputStreamWriter(new FileOutputStream("/Users/allenhsu/Desktop/thanks.txt",true),"unicode");
            osw.write("我爱记歌词");
            System.out.println(osw.getEncoding());
            osw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
