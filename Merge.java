import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 自顶向下的归并排序
 */
public class Merge {
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }
    //保证方法对外接口的一致性，将真正的sort弄成私有方法
    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid+1, hi);
        merge(a, lo, mid, hi);
    }

    /**
     * 在这里定义的是通用的方法，所以一定要抽象出来，不要随便将lo在方法中赋值为0
     *
     * @param a   要比较的数组
     * @param lo  数组的头
     * @param mid 数组的中间
     * @param hi  数组的尾巴
     */
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
