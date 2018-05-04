import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 该模板实现排序算法这章的各种方法实现，仅需改动方法sort即可
 */

/**
 * 第三种 希尔算法的实现
 */
public class Shell {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) h = h * 3 + 1; // 找出最大的能被N/3整除的项，保证h最后为1
        //对序列a进行h有序
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a) {
        //在单行中打印数组
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i] + " ");
        }
    }

    public static boolean issorted(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            if (less(a[i + 1], a[i]))
                return false;
        }
        return true;
    }

//    public static void main(String[] args) {
//        try {
//            //args[0]就是program arguments填的内容
//            FileInputStream input = new FileInputStream(args[0]);
//            System.setIn(input);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        String[] a = In.readStrings();
//        sort(a);
//        assert issorted(a);
//        show(a);
//    }
}
