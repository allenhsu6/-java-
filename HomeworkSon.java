import java.awt.*;

public class HomeworkSon extends HomeworkForExtends {
    public HomeworkSon() {
    }

    public void AddHead() {
        super.DrawPerson(50, 50);
        super.DrawPerson(100, 100);

    }

    public void paint(Graphics graphics) {
        // 必须先调用父类的paint方法
        // super.paint(graphics);
        // 用画笔Graphics，在画板JPanel上画一个小人
        graphics.drawOval(100, 40, 30, 30);// 头部（画圆形）
        graphics.drawRect( 50, 40, 20, 30);// 身体（画矩形）
        graphics.drawLine(111, 111, 75, 120);// 左臂（画直线）
        graphics.drawLine(125, 111, 150, 120);// 右臂（画直线）
        graphics.drawLine(125, 133, 75, 150);// 左腿（画直线）
        graphics.drawLine(125, 133, 150, 150);// 右腿（画直线）
    }

    public static void main(String[] args) {
        HomeworkSon son = new HomeworkSon();
        //son.AddHead();
        son.DrawPerson(150, 150);

    }
}
