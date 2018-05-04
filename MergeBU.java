import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MergeBU {
    private static Comparable[] aux;

    /**
     *
     * @param a 比较对象
     */
    public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz)// sz为宽度
            for (int lo = 0; lo < N - sz; lo += sz + sz) //从lo =0 开始，到最后
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;

        // 复制a到aux中
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        // mid不变 i和j是索引， i,j一直在++，索引最后一次如果i>mid，代表前半截已经检索结束，后半截同理
        for (int k = lo; k <= hi; k++)
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
    }


    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
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
        public static void main(String[] args) {
        try {
            //args[0]就是program arguments填的内容
            FileInputStream input = new FileInputStream(args[0]);
            System.setIn(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String[] a = In.readStrings();
        sort(a);
        assert issorted(a);
        show(a);
    }
}
