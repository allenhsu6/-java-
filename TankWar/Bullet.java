import java.awt.*;
import java.util.List;

public class Bullet {
    public static final int X_SPEED = 10;
    public static final int Y_SPEED = 10;
    private static final double XX_SPEED = 7;
    private static final double YY_SPEED = 7;
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private TankClient tc;

    public boolean isGood() {
        return good;
    }

    public void setGood(boolean good) {
        this.good = good;
    }

    private boolean good;

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

    public Bullet(int x, int y, boolean good, Tank.Direction direction, TankClient tc) {
        this(x, y, direction);
        this.good = good;
        this.tc = tc;
    }

    public void draw(Graphics g) {
        if (!isLive()) {
            tc.bullets.remove(this); //如果子弹死了，我们就从子弹包里移出去
            return;
        }
        Color c = g.getColor(); //保护画笔原色
        if (this.isGood()) {
            g.setColor(new Color(0xBB050C));
        } else {
            g.setColor(Color.BLACK);
        }
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
        if (this.isLive() && getRect().intersects(t.getRect()) && t.isLive() && this.isGood() != t.isGood()) {
            if (t.isGood()) {
                if (t.getLiveBlood() != 0 && !this.isGood()) {
                    int blood = t.getLiveBlood();
                    t.setLiveBlood(blood - 10);
                    this.live = false;
                    return true;
                }
                Explode e = new Explode(x, y, tc);
                tc.explodes.add(e);
                t.setLive(false);
            } else {
                Explode e = new Explode(x, y, tc);
                t.setLive(false);
                this.live = false;
                tc.explodes.add(e);
                return true;
            }
        }
        return false;
    }

    public Boolean hitTanks(List<Tank> tanks) {
        for (int i = 0; i < tanks.size(); i++) {
            Tank t = tanks.get(i);
            if (hitTank(t)) {
                tanks.remove(t);
                return true;
            }
        }
        return false;
    }

    public Rectangle getRect() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    public Boolean hitWall(Wall wall) {
            if (this.isLive() && getRect().intersects(wall.getRect())) {
                this.live = false;
                return true;
            }
        return false;
    }
}
