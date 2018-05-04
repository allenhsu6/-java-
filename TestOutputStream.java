import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestOutputStream {
    public static void main(String[] args) {
        int b = 0;
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("/Users/allenhsu/Documents/IDEA/JAVA/src/TestOutputStream.java");
            out = new FileOutputStream("/Users/allenhsu/Desktop/learn.java");
            while ((b = in.read())!= -1){
                out.write((byte)b);
            }
            in.close();
            out.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
            System.exit(-1);
        }
        catch (IOException e){
            System.out.println("无法复制文件");
            System.exit(-1);
        }
        System.out.println("完成复制");
    }

}
