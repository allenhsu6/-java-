package GUI;

import java.awt.*;
//f.repaint 强制重画,重新绘制，update+paint
//每次需要重新画的时候，自动调用paint，paint方法是自动传递的
//恢复现场（原来画笔的颜色），编程的良好习惯，
public class TestPaint {
    public static void main(String[] args) {
        new PFrame().launchFrame();
    }
}
class PFrame extends Frame{
    public void launchFrame(){
        setBackground(new Color(0x4769FF));
        setBounds(50,50,300,300);
        setVisible(true);

    }

    public void paint(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.CYAN);
        g.fillOval(40,40,100,30);
        g.setColor(Color.pink);
        g.fillRect(70,70,100,40);
        g.setColor(c);
    }

}