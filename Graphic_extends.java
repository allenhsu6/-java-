import java.awt.*;

public class Graphic_extends extends Java_Graphic {
    public Graphic_extends(){}

    public void paint(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(240, 70, 20, 200);
        g.drawLine(190, 50, 240, 230);
        g.drawLine(260, 245, 350, 60);
        g.drawLine(250, 20, 250, 70);
        g.setColor(Color.blue);
        g.fillOval(160, 20, 40, 40);
        g.fillOval(235, 10, 30, 30);
        g.fillOval(340, 40, 40, 40);
    }
}
