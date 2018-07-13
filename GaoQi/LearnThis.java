package GaoQi;

/**
 * this关键字的作用
 */
public class LearnThis {
    int a;
    int b;
    int c;

    public LearnThis() {
    }

    public LearnThis(int a,int b) {
        this();
        this.a = a;
        this.b = b;
    }
    public LearnThis(int a,int c, int b){
        super();
        this.c = c;
    }
    //静态方法访问静态对象
    public void show(){
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        eat();
        this.eat();

    }
    public void eat(){
        System.out.println("eat");
    }

    public static void main(String[] args) {
        LearnThis learnThis = new LearnThis(1,2,3);
        learnThis.show();

    }
}
