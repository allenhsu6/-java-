package GaoQi;
// 第二章编程作业第三题
import java.util.Scanner;

public class Encryption {
    public static void main(String[] args) {
        System.out.print("请输入将要加密的四位正整数数字： ");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        String s = String.valueOf(a);
        String s1 = "";
        for (int i = s.length()-1; i >= 0; i--) {
            int m = s.charAt(i);
            int n = (m-48+5)%10;
            s1 = s1 + n;
        }
        System.out.println(s1);
    }

}
