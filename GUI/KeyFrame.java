package GUI;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.VK_UP;

public class KeyFrame {
    public static void main(String[] args) {
        new TestKey().keyLaunch();
    }
}
class TestKey extends Frame{
    public void keyLaunch(){
        setBackground(Color.red);
        setBounds(40,40,200,200);
        setResizable(true);
        addKeyListener(new Mykey());
        setVisible(true);
    }
}
class Mykey extends KeyAdapter{
    @Override
    public void keyPressed(KeyEvent e) {
        int Keycode = e.getKeyCode();
        if (Keycode == VK_UP)
            System.out.println("up");
    }
}