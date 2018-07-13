package GaoQi;

/**
 * 这个例子好好看看
 */

public class Example8_1 {
    public static void main(String args[]) {
        String s = "abc";
        String ss = "abc";
        String s3 = "abc" + "def";
        String s4 = "abcdef";
        String s5 = ss + "def";
        String s2 = new String("abc");
        System.out.println(s == ss); // String已经重写了equal方法，所以比较的是内容
        System.out.println(s3 == s4);
        System.out.println(s4 == s5);
        System.out.println(s4.equals(s5));
        System.out.println(s2 == s);
        System.out.println(s2.equals(s));
    }
}
