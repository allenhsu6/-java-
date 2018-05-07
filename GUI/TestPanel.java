package GUI;

import java.awt.*;

public class TestPanel {
    public static void main(String[] args) {
        Frame f = new Frame("i love you");
        Panel p = new Panel(null);
        f.setLayout(null);
        f.setBackground(Color.black);
        f.setBounds(100,100,500,500);
        p.setBounds(50,50,400,400);//相对于frame的起点坐标
        p.setBackground(new Color(96, 200, 133));
        f.add(p);
        f.setVisible(true);
    }
}
