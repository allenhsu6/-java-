import edu.princeton.cs.algs4.KWIK;

/**
 *
 * @param <Key> 参数Key数据类型可替换，可比较
 */
public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;  //基于堆的完全二叉树
    private int N = 0;

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN+1]; //前面的强制类型转化，后面的可比较类型
    }

    /**
     * 堆中的交换
     * @param i 要交换的元素
     * @param j 要交换的元素
     */
    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k))
            exch(k / 2, k);
    }

    private void sink(int k) {

    }
}
