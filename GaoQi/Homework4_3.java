package GaoQi;

// 没看懂题
public class Homework4_3 {
    int id;
    String password;
    String address;

    public Homework4_3(int id, String password, String address) {
        this.id = id;
        this.password = password;
        this.address = address;
    }

    @Override
    public String toString() {
        return "重写toString";
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    public static void main(String[] args) {
        Homework4_3 homework4_3, homework4_31;
        homework4_3 = new Homework4_3(1,"123","qq.com");
        homework4_31  = new Homework4_3(2,"345","34e3");
       Homework4_3 c = homework4_3;
       c.address = "weew";
       Boolean a = c == homework4_3;
       Boolean b = c.equals(homework4_3);
        System.out.println(a +"  "+ b +"  "+ homework4_3.address);
        System.out.println(c);
    }
}
