import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class UF {
    private int count;
    private int[] id;
    private int[] sz;
    private int total;
    public int cost;
    private int i;

    public UF(int N) {
        //初始化联通分量id数组
        id = new int[N];
        sz = new int[N];
        count = N;
        cost = 1;
        total = 1;
        i = 1;
        StdDraw.setYscale(0, 1300);
        StdDraw.setXscale(0, 800);
        StdDraw.setPenRadius(0.005);
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    //第一种方法
    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        if (pid == qid) return;
        for (int i = 0; i < id.length; i++) {
            //因为此处的id[p]的数值在改变，所以此处必须使用pid
            cost++;
            if (pid == id[i]) id[i] = qid;
        }
        count--;
        total = total + cost;
    }

    //第三种方法：加权法
//    public void union(int p, int q) {
//        int proot = find(p);
//        int qroot = find(q);
//        if (proot == qroot) return;
//        if (sz[proot] <= sz[qroot]) {
//            id[proot] = qroot;
//            sz[qroot] += sz[proot];
//        } else {
//            id[qroot] = proot;
//            sz[proot] += sz[qroot];
//        }
//        count--;
//        total = cost + total;
//    }

//    private int find(int p) {
//        //根一定符合id[root]=root
//        //这个while保证了迭代循环找到最终的根
//        while (id[p] != p) {
//            p = id[p];
//            cost++;
//        }
//        return p;
//    }

    //第一种find方法实现
    public int find(int p) {
        cost++;
        return id[p];
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 画笔工具
     */
    public void Drawcost() {
        StdDraw.setPenColor(Color.red);
        StdDraw.point(i, cost);
        StdDraw.setPenColor(Color.gray);
        StdDraw.point(i, total / i);
        i++;
        cost = 0;
    }

    //测试
    public static void main(String[] args) {
        try {
            //args[0]就是program arguments填的内容
            FileInputStream input = new FileInputStream(args[0]);
            System.setIn(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int N = StdIn.readInt();
        UF uf = new UF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q); //打印连接
            /**
             * 在这里加入要画的点
             */
            uf.Drawcost();
        }
        StdOut.println(uf.count() + "components");
    }
}
