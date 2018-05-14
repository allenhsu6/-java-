import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;

public class Tank {
    private static final int X_SPEED = 5;
    private static final int Y_SPEED = 5;
    private static final double XX_SPEED = 3.53;
    private static final double YY_SPEED = 3.53;
    private static final int WIDTH = 30;
    private static final int HEIGHT = 30;
    private static Random random = new Random();

    TankClient tc;
    private int x;
    private int y;
    private int oldx;
    private int oldy;

    public int getLiveBlood() {
        return liveBlood;
    }

    public void setLiveBlood(int liveBlood) {
        this.liveBlood = liveBlood;
    }

    private int liveBlood = 30;
    private boolean UP = false, RIGHT = false, LEFT = false, DOWN = false;

    public boolean isGood() {
        return good;
    }

    private boolean good;
    private int step = random.nextInt(15) + 3;

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

    Tank(int x, int y, Boolean good, Direction d, TankClient tc) {
        this(x, y, good);
        this.direction = d;
        this.tc = tc;
    }

    public void draw(Graphics g) {
        if (!isLive()) {
            return;
        }
        Color c = g.getColor(); //保护画笔原色
        if (this.good) {
            g.setColor(new Color(0xBB4B0B));
            g.fillRect(x, y - 10, liveBlood, 10);
        } else g.setColor(new Color(0x04B2BB));
        g.fillOval(x, y, WIDTH, HEIGHT);
        g.setColor(new Color(0x5105BB));
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

    void stay() {
        x = oldx;
        y = oldy;
    }

    void move() {
        oldx = x;
        oldy = y;
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
        if (!good) {
            Direction[] directions = Direction.values();
            if (step == 0) {
                int rn = random.nextInt(directions.length);
                direction = directions[rn];
                step = random.nextInt(15) + 3;
            }
            if (random.nextInt(10) > 7) Fire();
            step--;
        }
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
            case KeyEvent.VK_F2:
                if (this.isGood()) {
                    this.setLive(true);
                    this.setLiveBlood(30);
                }
            case KeyEvent.VK_F:
                Fire();
                break;
            case KeyEvent.VK_A:
                superFire();
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
        if (!live) return null;
        int x = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int y = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        Bullet b = new Bullet(x, y, true, barrelDirection, tc); //子弹的初始化
        if (!this.good) b.setGood(false);
        tc.bullets.add(b);
        return b;
    }

    public Bullet Fire(Direction dir) {
        if (!live) return null;
        int x = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int y = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        Bullet b = new Bullet(x, y, true, dir, tc); //子弹的初始化
        if (!this.good) b.setGood(false);
        tc.bullets.add(b);
        return b;
    }

    public void superFire() {
        Direction[] directions = Direction.values();
        for (int i = 0; i < 8; i++) {
            Fire(directions[i]);
        }
    }

    public Rectangle getRect() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    public Boolean tankHitWall(Wall wall) {
            if (this.isLive() && getRect().intersects(wall.getRect())) {
                stay();
                return true;
            }
        return false;
    }

    /*
    判断坦克不能相撞，主要是敌军的坦克
     */
    public Boolean tankHitTanks(List<Tank> tanks) {
        for (int i = 0; i < tanks.size(); i++) {
            Tank tank = tanks.get(i);
            if (this != tank && tank.isLive() && this.isLive() && getRect().intersects(tank.getRect())) {
                stay();
                return true;
            }
        }
        return false;
    }
}
