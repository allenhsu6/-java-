package GaoQi;

import java.util.Scanner;

public class Homework6_3 {

    int N;
    int total = 0;

    public static void main(String[] args) {
        System.out.println(new Homework6_3());
    }

    @Override
    public String toString() {
        return "平均分:" + averageValue() + "有效输入次数：" + N;
    }

    public int averageValue() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入所有学生的分数并以-1作为结束输入：");

        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            if (a == -1) {
                return total / N;
            } else if (a >= 0) {
                N++;
                total += a;
            } else try {
                throw new Exception("错误的输入值"); //抛出错误当场解决
            } catch (Exception e) {
                System.out.println("数字输入的不对啊，再输入该数");
            }

        }
        return total / N;
    }
}

