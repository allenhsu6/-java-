import java.awt.*;
import javax.swing.*;

public class Example extends JFrame {

    public Example() {
        initGUI();
    }
    public void initGUI(){
        setTitle("Simple example");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        drawingPanel.setBounds(0,0,300,200);
        getContentPane().add(drawingPanel);
    }


    public static void main(String[] args) {
        Example ex = new Example();
        ex.setVisible(true);
    }
    DrawingPanel drawingPanel = new DrawingPanel();
}

class DrawingPanel extends JPanel{
    public DrawingPanel(){
    }

    public void paint(Graphics g){
        g.drawString("Un texte!",30,30);
    }
}
