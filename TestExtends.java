import java.applet.Applet;
import java.awt.*;

public class TestExtends extends Applet {
    private Java_Graphic father;
    private Graphic_extends son;
    private Graphics g;

    public void init() {
        father = new Java_Graphic();
        son = new Graphic_extends();
        setBackground(Color.YELLOW);           //设置背景颜色
        father.paint(g);    //调用父类
        son.paint(g);       //调用子类
    }
    public static void main(String[] args){
        TestExtends ts = new TestExtends();
    }
}
