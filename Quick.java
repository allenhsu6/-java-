import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Quick {
    public static void sort(Comparable[] a){
        StdRandom.shuffle(a); //先打乱序列a
        sort(a, 0 , a.length-1);
    }
    private static void sort(Comparable[] a, int lo, int hi){
        if (hi<=lo) return;
        int j = partition(a,lo,hi); //找到j值
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }

    /**
     * 实现切分，切分比较的次数是每个数都要和K做一次比较
     * @param a 输入数组
     * @param lo 头
     * @param hi 尾
     * @return 返回一个作为切分的数
     */
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi+1;
        Comparable v = a[lo];
        while (true)
        {
            while (less(a[++i], v)) {
                if (i == hi) break;
            }
            while (less(v,a[--j])) if (j==lo) break;
            if (i>=j) break;
            exch(a,i,j);
        }
        exch(a,lo,j);
        return j;
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

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
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