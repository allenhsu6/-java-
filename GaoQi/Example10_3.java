package GaoQi;

/**
 * 这个例子没有参考价值
 */

import java.io.FileWriter;
import java.io.IOException;

public class Example10_3 {
    public static void main(String[] args) throws IOException {
        String str = "文件写入练习";
        FileWriter fw = null;        //1
        try {
            fw = new FileWriter("/Users/allenhsu/Desktop/test.txt");  //2
            fw.write(str);   //3
        } catch (IOException e) {   //4
            e.printStackTrace();
        } finally {
            fw.close();
        }
    }
}
