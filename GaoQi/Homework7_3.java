package GaoQi;

import java.util.Arrays;

public class Homework7_3 {
    int n = 100;
    int[] randoms = new int[n];

    public static void main(String[] args) {
        Homework7_3 findRandom = new Homework7_3();
        findRandom.setRandoms();
        Arrays.sort(findRandom.randoms);
        int count = 0;
        for (int i = 0; i < findRandom.randoms.length; i++) {
            if (findRandom.randoms[i] > 60) {
                System.out.print(findRandom.randoms[i] + " ");
                count++;
            }
        }
        System.out.println();
        System.out.println(count);
    }

    public void setRandoms() {
        for (int i = 0; i < n; i++) {
            int random = (int) (n * Math.random());
            randoms[i] = random;
        }
    }
}
