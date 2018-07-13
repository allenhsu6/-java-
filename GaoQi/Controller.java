package GaoQi;
// 递归求n的阶乘
public class Controller {
    // 这是我写的递归，觉得不好
    int i =1;
    public void again(int n){
        if (i > 10) return ;
       else
           n = i * n;
        i++;
        again(n);
    }

    //书上的递归
    static long factorial(int n){
        if (n == 1) return 1;
        else  return n * factorial(n-1);
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.again(1);
        System.out.println(controller.factorial(10));
    }
}
