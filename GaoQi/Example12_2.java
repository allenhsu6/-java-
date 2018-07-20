package GaoQi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * 简单的网络爬虫
 * 所以在做爬虫的时候，学习正则表达式很重要很重要
 * 建议马士兵的正则表达式提上日程吧
 */
public class Example12_2 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        URL url = new URL("https://www.baidu.com");
        InputStream inputStream = url.openStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String temp;
        while ((temp = br.readLine()) != null) {
            sb.append(temp);
        }
        System.out.println(sb);

        br.close();
        inputStream.close();
    }
}
