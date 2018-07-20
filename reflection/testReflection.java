package reflection;

import java.lang.reflect.Method;

public class testReflection {
    public static void main(String[] args) {
        String string = "TestBigMouse";
        TestBigMouse t = new TestBigMouse();
        t.getS();
        try {
            Class c = Class.forName(string); //装载名字为s的类
            Object o = c.newInstance();
            Method[] methods = c.getMethods();
            for (int i = 0; i < methods.length; i++) {
                System.out.println(methods[i].getName());

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}

//这里有问题，不知道为什么这个类无法编译
class TestBigMouse {
    static {
        System.out.println("T loaded!");
    }

    int i;
    String s = "小孩";

    public TestBigMouse() {
        System.out.println("T loaded big!");
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getS() {
        return s;
    }
}
