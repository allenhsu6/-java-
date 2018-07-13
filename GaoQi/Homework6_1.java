package GaoQi;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Homework6_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入数字：");
        try {
            int num = input.nextInt();
            if (num < 1 || num > 4) {
                throw new Exception("必须在1-4之间！");
            }
        } catch (InputMismatchException e) {
            System.out.println("InputMismatchException");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}