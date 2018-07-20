import java.awt.*;
/*
关于血块的设计：
1、draw方法循环画出12个血块，组成心形
2、当吃掉一个血块的时候，坦克补充10滴血
  2.1 碰撞检测
  2.2 eat方法返回一个int值，表示当前剩余血块数量
3、在吃掉所有12个血块之后，，重新生成12个血块
   具体：放在大管家的paint处，调用eat方法的时候将数量取出到变量中
 */


public class Blood {
    int x_big = 400;
    int y_big = 285;
    boolean live = true;

    int[][] position;
    TankClient tc;  //添加大管家

    //构造方法
    Blood(TankClient tc) {
        this.tc = tc;
        position = new int[][]{
                {400, 200},
                {480, 150},
                {550, 100},
                {600, 150},
                {580, 200},
                {540, 250},
                {500, 300},
                {450, 330},
                {400, 370},
                {350, 330},
                {300, 300},
                {260, 250},
                {220, 200},
                {200, 150},
                {250, 100},
                {320, 150}
        };
    }

    //画一个小圆点
    public void draw(Graphics g) {
        Color c = g.getColor();
        for (int i = 0; i < position.length; i++) {
            g.setColor(new Color(0xBB3F79));
            g.fillOval(position[i][0], position[i][1], 15, 15);
        }
        if (isLive()) {
            g.setColor(new Color(0x8509BB));
            g.fillOval(x_big, y_big, 25, 25);
        }
        g.setColor(c);
    }

    //
    public int eatBlood(Tank t) {
        int count = 1;
        if (this.isLive() && getRect().intersects(t.getRect()) && t.isLive() && t.getLiveBlood() < 30) {
            t.setLiveBlood(t.getLiveBlood() + 10);
            count--;
            this.setLive(false);
        }
        return count;
    }

    public Rectangle getRect() {
        return new Rectangle(x_big, y_big, 25, 25);
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }
}

