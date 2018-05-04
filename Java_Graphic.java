import java.awt.*;

public class Java_Graphic {
    public Java_Graphic() {
    }

    public void paint(Graphics g) {
        Font font = new Font("Arial", Font.BOLD, 18);//设置字体
        g.setFont(font);
        g.setColor(Color.red);
        g.drawString("绿色球是父类", 20, 40);
        g.drawString("蓝色球是子类", 20, 60);
        g.setColor(Color.black);
        g.drawString("学号：SY1714201", 20, 80);
        g.drawString("姓名：徐志", 20, 100);
        g.setColor(Color.green);
        g.fillRect(230, 250, 40, 250); //画矩形
        g.drawLine(180, 300, 230, 450);
        g.drawLine(270, 400, 380, 230);
        g.fillOval(160, 280, 50, 50);
        g.fillOval(370, 200, 50, 50);
    }
}