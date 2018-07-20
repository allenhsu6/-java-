/**
 * 该模板实现排序算法这章的各种方法实现，仅需改动方法sort即可
 */


public class Insertion {
    public static void sort(Comparable[] a) {
        /**
         * 插入算法的实现，保证前面的那些数字是已经排好顺序的
         */
        for (int i = 1; i < a.length; i++) { //注意：i要从1开始，没必要从零开始
            /**另一种写法:这样的话可以省略掉 else break 这行
             * for (int j = i; 0<j&&less(a[j],a[j-1]); i--)
             */
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);

            }
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
//        selectSort(a);
//        assert issorted(a);
//        show(a);
//    }
}
