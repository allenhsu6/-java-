package PreparedForAmzon;

public class Assignment {
    private int m = 0;

    public static void main(String[] args) {
        Assignment a = new Assignment();
        a.increment();
        System.out.println(a.m);
        Assignment b = a;
        b.increment();
        System.out.println(a.m);
    }

    public void increment() {
        m++;
    }
}
