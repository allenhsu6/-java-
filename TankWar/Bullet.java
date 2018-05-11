import java.awt.*;

public class Bullet {
    public static final int X_SPEED = 10;
    public static final int Y_SPEED = 10;
    private static final double XX_SPEED = 7;
    private static final double YY_SPEED = 7;
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private TankClient tc;

    public boolean isLive() {
        return live;
    }

    private boolean live = true;

    private int x, y;
    Tank.Direction direction; //子弹发出的方向就是坦克的方向

    public Bullet(int x, int y, Tank.Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Bullet(int x, int y, Tank.Direction direction, TankClient tc) {
        this(x, y, direction);
        this.tc = tc;
    }

    public void draw(Graphics g) {
        if (!isLive()) {
            tc.bullets.remove(this);
            return;
        }
        Color c = g.getColor(); //保护画笔原色
        g.setColor(Color.BLACK);
        g.fillOval(x, y, WIDTH, HEIGHT);
        g.setColor(c);
        move();//改变的是x和y
    }

    public void move() {
        switch (direction) {
            case D:
                y += Y_SPEED;
                break;
            case L:
                x -= X_SPEED;
                break;
            case R:
                x += X_SPEED;
                break;
            case U:
                y -= Y_SPEED;
                break;
            case LD:
                x -= XX_SPEED;
                y += YY_SPEED;
                break;
            case LU:
                x -= XX_SPEED;
                y -= YY_SPEED;
                break;
            case RD:
                x += XX_SPEED;
                y += YY_SPEED;
                break;
            case RU:
                x += XX_SPEED;
                y -= YY_SPEED;
                break;
        }
        if (x < 0 || y < 0 || x > TankClient.GAME_WIDTH || y > TankClient.GAME_WEIGHT) {
            live = false;
            tc.bullets.remove(this);
        }
    }

    public Boolean hitTank(Tank t) {
        if (getRect().intersects(t.getRect()) && t.isLive()) {
            t.setLive(false);
            this.live = false;
            return true;
        }
        return false;
    }

    public Rectangle getRect() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }
}
