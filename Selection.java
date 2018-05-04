import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 该模板实现排序算法这章的各种方法实现，仅需改动方法sort即可
 */


public class Selection {
    public static void sort(Comparable[] a) {
        /**
         * 选择排序的实现
         */
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++)
                if (less(a[j], a[min])) min = j;
            exch(a, i,min);  //一次交换就可以
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
