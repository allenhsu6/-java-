import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestInputStream {
    public static void main(String[] args) {
        int b = 0;
        FileReader in = null;
        try {
            in = new FileReader("/Users/allenhsu/Documents/IDEA/JAVA/src/TestInputStream.java");

        }catch (FileNotFoundException e){
            System.out.println("找不到指定文件");
            System.exit(-1);
        }
        try {
            long num = 0;
            while ((b = in.read()) != -1) {
                System.out.print((char) b);
                num++;
            }
            in.close();
            System.out.println();
            System.out.print("共打印了"+ num +"个字符");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);//如果文件读写错误就退出系统

        }
    }
}
