import java.awt.*;

public class Explode {
    private TankClient tc;
    int x, y;
    private boolean live = true;
    private static Toolkit tk = Toolkit.getDefaultToolkit();
    private static Image[] images = {
            tk.getImage("/Users/allenhsu/Documents/IDEA/JAVA/src/image/111.gif"),
            tk.getImage("/Users/allenhsu/Documents/IDEA/JAVA/src/image/222.gif"),
            tk.getImage("/Users/allenhsu/Documents/IDEA/JAVA/src/image/333.gif"),
            tk.getImage("/Users/allenhsu/Documents/IDEA/JAVA/src/image/444.gif"),
            tk.getImage("/Users/allenhsu/Documents/IDEA/JAVA/src/image/555.gif"),
            tk.getImage("/Users/allenhsu/Documents/IDEA/JAVA/src/image/666.gif"),
            tk.getImage("/Users/allenhsu/Documents/IDEA/JAVA/src/image/777.gif"),
            tk.getImage("/Users/allenhsu/Documents/IDEA/JAVA/src/image/888.gif"),

    };
    int step = 0;

    public Explode(int x, int y, TankClient tc) {
        this.x = x;
        this.y = y;
        this.tc = tc;
    }

    public void draw(Graphics g) {

        if (step == images.length) {
            live = false;
            step = 0;
            tc.explodes.remove(this);
            return;
        }
        g.drawImage(images[step], x, y, null);
        step++;
    }
}

