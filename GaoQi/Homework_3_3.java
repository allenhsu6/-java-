package GaoQi;
//又一次的递归练习，斐波那契数列，感觉还是不熟练

/**
 * 我觉得递归中，这个函数就是一个工具，就代表一个数
 * 找准结尾的地方，其他部位都使用函数递归，定义的是一种通用的方法
 */
public class Homework_3_3 {

    public static void main(String[] args) {
        System.out.println(fibonacci(9));
    }

    static public int fibonacci(int n){
        if (n <=2)
            return 1;
        else{
            return fibonacci(n-1)+fibonacci(n-2);
        }
    }
}
