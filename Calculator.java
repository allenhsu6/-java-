public class Calculator {
    private int i;
    public Calculator() {
        i = 1;
        ++i;
    }
    public static void main(String[] args){
        Calculator a = new Calculator();
        System.out.println(a.i);
    }
}
