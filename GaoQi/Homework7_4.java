package GaoQi;

public class Homework7_4 {
    int[] words = {1, 2, 3, 4, 5, 6, 7, 11, 55};
    int mid = words.length / 2;

    public static void main(String[] args) {
        Homework7_4 change = new Homework7_4();
        for (int number : change.words
                ) {
            System.out.print(number + "  ");
        }
        change.exchange();
        System.out.println();
        for (int number : change.words
                ) {
            System.out.print(number + "  ");
        }
    }

    // 做交换需要说明白，对谁进行的交换 要真正落实下来
    public void exch(int[] m, int a, int b) {
        int n = m[a];
        m[a] = m[b];
        m[b] = n;
    }

    public void exchange() {
        for (int i = 0; i < mid; i++) {
            exch(words, i, words.length - 1 - i);
        }
    }
}
