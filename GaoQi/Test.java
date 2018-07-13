package GaoQi;
// 告诉我们一个道理,程序从左到右运行，
public class Test {
    public static void main(String[] args) {
        int i = 1;
        int j;
        j = i++;  // 先j赋值，后i自加
        System.out.println(j + " "+ i);
        char big = 2 + '2';
        double d  = 11.1;
        System.out.println(big);
        int m = i++;
        System.out.println(j + " "+ i +" "+m);

        System.out.println(1.0-0.1-0.1-0.1-0.1-0.1);

        float a = 3434552345f;
        float a1 = a+1;
        if (a == a1) System.out.println("怎么可能");

        int x = 129;
        byte bx = (byte)x;
        System.out.println(bx);

        int money = 1000000000; // 赋值的时候要注意不能超出表数范围
        System.out.println(money);
        int year = 20;
        System.out.println(money*year);

        int l1;//不要出现这种情况的命名，谁能看清楚是1还是l啊

        int i1 = 99;
        mb_operate(i1);
        System.out.println(i1 + 100);
    }
    static void mb_operate(int i){
        i+=100; //这里只是操作了参数变量，并没有真正改变i值
    }
}
