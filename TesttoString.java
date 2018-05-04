public class TesttoString {
    public static void main(String[] args) {
        Dog d = new Dog();
        System.out.println(d);
    }
}
class Dog{
    //重写toString父类方法
    public String toString(){
        return "i'm a cool dog";
    }
}
//hashcode代表对象独一无二的编码，通过这个code可以寻找到对应对象
//classpash中的同名class非常麻烦，命名很重要