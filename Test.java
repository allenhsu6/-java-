//动态绑定，多态，迟邦定，运行起来后，重写的方法实际是什么绑定什么
//多态三条件：继承（对类），重写(对方法)，父类引用指向子类对象
//当三条件满足的时候，父类引用动态绑定子类方法
//调用方法，方法放在code seg中，当你实际调用方法的时候决定
//继承抽象类必须将之抽象方法实现，否者必须把自己编程抽象类
//抽象类不能实例化
abstract class Animal {
    private String name;
    public abstract void enjoy();

    Animal(String name){
        this.name = name;
    }
}

class ThisCat extends Animal{
    private String eyescolor;
    ThisCat(String n, String eyesColor){
        super(n); //调用父类的构造函数
        this.eyescolor = eyesColor;
    }

    @Override
    public void enjoy() {
        System.out.println("猫叫声");
    }
}

class ThisDog extends Animal{
    private String furcolor;
    ThisDog(String n, String furColor){
        super(n);
        this.furcolor = furColor;
    }

    @Override
    public void enjoy() {
        System.out.println("狗叫声...");
    }
}

class Lady{
    private String name;
    private Animal pet;  //父类引用
    Lady(String n, Animal a){
        name = n;
        pet = a;
    }
    public void enjoy(){
        pet.enjoy();
    }
}
public class Test{
    public static void main(String[] args) {
        Test ts = new Test();
        ThisDog d = new ThisDog("ahuang","yellow");
        ThisCat cat = new ThisCat("lanmao","blue");
        Lady l1 = new Lady("l1", d); //父类引用指向子类对象
        Lady l2 = new Lady("l2", cat);
        l1.enjoy();
        l2.enjoy();
    }
}
