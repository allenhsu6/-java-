package GUI;

import java.awt.*;

public class TestFrame {
    public static void main(String[] args) {
    MyFrame f1 = new MyFrame(100,100,Color.BLUE);

    MyFrame f2 = new MyFrame(400,100,Color.red);
    MyFrame f3 = new MyFrame(100,400,Color.black);
    MyFrame f4 = new MyFrame(400,400,Color.yellow);

    }

}

class MyFrame extends Frame {
    static int id = 0;

    MyFrame(int a, int b, Color color) {
        super(" my" + (++id) + "frame");
        setBackground(color);
        setLayout(null);
        setBounds(a, b, 300, 300);
        setSize(300, 300);
        setVisible(true);
    }
}
