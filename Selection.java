import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 该模板实现排序算法这章的各种方法实现，仅需改动方法sort即可
 * 选择算法的本质是遍历整个数组，寻找其中的最小值，然后放在第一个位置，以此类推，感觉可以写成递归的形式
 * 所以最多交换n次，但是必须要比较n*(n-1)/2次
 */


public class Selection {
//    public static void selectSort(Comparable[] a) {
//        /**
//         * 选择排序的实现
//         */
//        for (int i = 0; i < a.length; i++) {
//            int min = i;
//            for (int j = i + 1; j < a.length; j++)
//                if (less(a[j], a[min])) min = j;
//            exch(a, i,min);  //一次交换就可以
//        }
//    }

    /**
     * 自上而下的归并排序
     *
     * @param a  实现Comparable接口的比较对象
     * @param lo  a序列的头
     * @param mid  中间
     * @param hi    尾巴
     */
    private static Comparable[] aux;

    /**
     * 仔细想想发现，这里就是典型的多态，传入的a是任意实现comparable接口的类型都可以
     * 最开始不知道要比较的是什么类型，所以我们传入comparable
     *
     * @param a 参数a是string类型 本身已经实现了comparable接口
     */
    public static void selectSort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int less = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], a[less])) {
                    less = j;
                }
            }
            exch(a, less, i);
        }
    }

    public static void bubbleSort(Comparable[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (less(a[j + 1], a[j])) exch(a, j, j + 1);
            }
        }
    }

    public static void insertSort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    /**
     * 这个算法有很多陷阱需要注意 首先间距n的选取，在使用while选取的时候，注意上界
     * 外层循环注意 i是i++的
     *
     * @param a
     */
    public static void shellSort(Comparable[] a) {
        int N = a.length;
        int n = 1;
        while (n < N / 3) {
            n = 3 * n + 1;
        }
        while (n >= 1) {
            for (int i = n; i < N; i++) {
                for (int j = i; j >= n && less(a[j], a[j - n]); j -= n) {
                    exch(a, j, j - n);
                }
            }
            n = n / 3;
        }
    }

    public static void mergeAbstract(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];//会在上层方法一次性开辟空间
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    // 是递归的初始  public包装并统一借口
    public static void mergeSort(Comparable[] a) {
        aux = new Comparable[a.length]; //放在这里一次性完成初始化即可
        mergeSort(a, 0, a.length - 1);
    }

    //递归的本质，调用自己 ，首先要提炼出这个通项，大家都用这个来实现
    private static void mergeSort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(a, lo, mid);  //左边排好
        mergeSort(a, mid + 1, hi); //右边排好
        mergeAbstract(a, lo, mid, hi);//通用的操作房子最后，先分开，然后再调用
    }

    /**
     * 自下向上的归并方法，用不到递归
     * 两两归并，其中步长是从lo到mid的距离，lo到hi时2倍步长
     *
     * @param a
     */
    public static void mergeDU(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int i = 1; i < N; i = i + i) { //确定步长
            for (int lo = 0; lo < N - i; lo += i + i) {
                mergeAbstract(a, lo, lo + i - 1, Math.min(lo + i + i - 1, N - 1));
            }
        }
    }

    /**
     * 这里是快排的实现
     *
     * @param a
     */
    public static void quickSort(Comparable[] a) {
        StdRandom.shuffle(a);
        quickSort(a, 0, a.length - 1);
    }

    public static void quickSort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int j = part(a, lo, hi);
        quickSort(a, lo, j - 1);
        quickSort(a, j + 1, hi);
    }


    private static int part(Comparable[] a, int lo, int hi) {
        int k = lo;
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (less(a[++i], a[k])) if (i >= hi) break;
            while (less(a[k], a[--j])) if (j <= lo) break;
            if (i >= j) break;  //找到比切分元素大的i和j下标之后，先要比较是否已经擦肩而过
            exch(a, i, j);
        }
        exch(a, k, j);
        return j;   //j的位置才是关键，返回的是一个位置
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

    public static void main(String[] args) {
        try {
            //args[0]就是program arguments填的内容
            FileInputStream input = new FileInputStream(args[0]);
            System.setIn(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String[] a = In.readStrings();
        //selectSort(a);
        //bubbleSort(a);
        //insertSort(a);
        //shellSort(a);
        //mergeSort(a);
        //mergeDU(a);
        quickSort(a);
        assert issorted(a);
        show(a);
    }
}
