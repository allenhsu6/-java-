package GaoQi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Example10_2 {
    public static void main(String[] args) {
        new Example10_2().copyFile("/Users/allenhsu/Desktop/test.txt", "/Users/allenhsu/Desktop/test2.txt");
    }

    public void copyFile(String src, String dec) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        byte[] buffer = new byte[1024];
        int temp;
        try {
            fis = new FileInputStream(src);   //这是输入口
            fos = new FileOutputStream(dec);    //这是输出口
            // 意味着这个一直在读,都读到了buffer中,buffer可以装好之后直接做输出的
            // 一次性读取buffer1024个字节才会显示，并输出！！！
            while ((temp = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, temp);  //这里的0是buffer的开始位置
                System.out.println(temp);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
