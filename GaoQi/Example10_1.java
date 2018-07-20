package GaoQi;
/**
 * 一种经典的读入数据的写法，希望能够学着
 */


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Example10_1 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("/Users/allenhsu/Desktop/test.txt");
            int temp = 0;
            StringBuilder sb = new StringBuilder();
            while ((temp = fis.read()) != -1) {
                sb = sb.append((char) temp + "  ");
            }
            System.out.println(sb);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
