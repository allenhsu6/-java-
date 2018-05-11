import java.awt.*;
import java.awt.event.KeyEvent;

public class Tank {
    private static final int X_SPEED = 5;
    private static final int Y_SPEED = 5;
    private static final double XX_SPEED = 3.53;
    private static final double YY_SPEED = 3.53;
    private static final int WIDTH = 30;
    private static final int HEIGHT = 30;


    TankClient tc;
    private int x;
    private int y;
    private boolean UP = false, RIGHT = false, LEFT = false, DOWN = false;
    private boolean good;

    public void setLive(boolean live) {
        this.live = live;
    }

    public boolean isLive() {
        return live;
    }

    private boolean live = true;

    //枚举类型的使用 学会使用这个类 使用方法有点和调用class的方式一样
    enum Direction {
        U, D, L, R, LU, LD, RU, RD, STOP
    }

    private Direction direction = Direction.STOP;
    private Direction barrelDirection = Direction.D;

    public Tank(int x, int y, Boolean good) {
        this.x = x;
        this.y = y;
        this.good = good;
    }

    Tank(int x, int y, Boolean good, TankClient tc) {
        this(x, y, good);
        this.tc = tc;
    }

    public void draw(Graphics g) {
        if (!isLive()) {
            return;
        }
        Color c = g.getColor(); //保护画笔原色
        if (this.good) g.setColor(new Color(0xBB4B0B));
        else g.setColor(new Color(0x04B2BB));
        g.fillOval(x, y, WIDTH, HEIGHT);
        g.setColor(new Color(0x6801BB));
        switch (barrelDirection) {
            case D:
                g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x + Tank.WIDTH / 2, y + HEIGHT + 6);
                break;
            case L:
                g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x - 6, y + Tank.HEIGHT / 2);
                break;
            case R:
                g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x + Tank.WIDTH + 6, y + Tank.HEIGHT / 2);
                break;
            case U:
                g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x + Tank.WIDTH / 2, y - 6);
                break;
            case LD:
                g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x, y + HEIGHT);

                break;
            case LU:
                g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x, y);

                break;
            case RD:
                g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x + Tank.WIDTH, y + HEIGHT);

                break;
            case RU:
                g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x + Tank.WIDTH, y);

                break;
        }
        g.setColor(c);
        move();
    }

    void move() {
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
            case STOP:
                break;
        }
        if (direction != Direction.STOP)
            this.barrelDirection = this.direction;
        if (x < 0) x = 0;
        if (x + Tank.WIDTH > TankClient.GAME_WIDTH) x = TankClient.GAME_WIDTH - Tank.WIDTH;
        if (y < 25) y = 25;
        if (y + Tank.HEIGHT > TankClient.GAME_WEIGHT) y = TankClient.GAME_WEIGHT - Tank.HEIGHT;
    }

    public void keyPressed(KeyEvent e) {
        int Key = e.getKeyCode();
        switch (Key) {
            case KeyEvent.VK_UP:
                UP = true;
                break;
            case KeyEvent.VK_DOWN:
                DOWN = true;
                break;
            case KeyEvent.VK_RIGHT:
                RIGHT = true;
                break;
            case KeyEvent.VK_LEFT:
                LEFT = true;
                break;
        }
        setDirection();
    }

    public void keyReleased(KeyEvent e) {
        int Key = e.getKeyCode();
        switch (Key) {
            case KeyEvent.VK_F:
                Fire();
                break;
            case KeyEvent.VK_UP:
                UP = false;
                break;
            case KeyEvent.VK_DOWN:
                DOWN = false;
                break;
            case KeyEvent.VK_RIGHT:
                RIGHT = false;
                break;
            case KeyEvent.VK_LEFT:
                LEFT = false;
                break;
        }
        setDirection();
    }

    void setDirection() {
        if (UP && !DOWN && !LEFT && !RIGHT) direction = Direction.U;
        else if (!UP && DOWN && !LEFT && !RIGHT) direction = Direction.D;
        else if (!UP && !DOWN && !LEFT && RIGHT) direction = Direction.R;
        else if (!UP && !DOWN && LEFT && !RIGHT) direction = Direction.L;
        else if (!UP && DOWN && LEFT && !RIGHT) direction = Direction.LD;
        else if (!UP && DOWN && !LEFT && RIGHT) direction = Direction.RD;
        else if (UP && !DOWN && !LEFT && RIGHT) direction = Direction.RU;
        else if (UP && !DOWN && LEFT && !RIGHT) direction = Direction.LU;
        else direction = Direction.STOP;

    }

    public Bullet Fire() {
        int x = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int y = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;

        Bullet b = new Bullet(x, y, barrelDirection, tc); //子弹的初始化
        tc.bullets.add(b);
        return b;
    }
    public Rectangle getRect() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }
}
