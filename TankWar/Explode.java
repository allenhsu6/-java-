import java.awt.*;

public class Explode {
    private TankClient tc;
    int x,y;
    private boolean live = true;
    int[] diameter = {2,6,12,23,45,36,23,11,4};
    int step = 0;

    public Explode(int x, int y, TankClient tc) {
        this.x = x;
        this.y = y;
        this.tc = tc;
    }
    public void draw(Graphics g){

        if (step == diameter.length){
            live = false;
            step = 0;
            tc.explodes.remove(this);
            return;
        }
        Color c  = g.getColor();
        g.setColor(new Color(0xBB050C));
        g.fillOval(x,y,diameter[step],diameter[step]);
        step++;
        g.setColor(c);
    }
}

