import java.awt.*;
import java.util.Random;

import static java.awt.image.ImageObserver.HEIGHT;

/*墙的功能
 我方的坦克可以穿越，敌军坦克无法穿越
 子弹都无法穿越
 要开始意识到，我的游戏中有很多重复的类，使用抽象类，然后再重写可以保证代码整洁
 */
public class Wall {
    TankClient tc;
    private int x,y,width,height;
    private static Random random = new Random();
    //这里加入随机的墙壁
    public Wall( TankClient tc) {
        this.x = random.nextInt(500)+50;
        this.y = random.nextInt(400)+50;
        width = random.nextInt(200)+5;
        height = random.nextInt(200)+5;
        this.tc = tc;
    }

    public void draw(Graphics g){
        Color c = g.getColor();
        g.setColor(new Color(0x467CC8));
        g.fillRect(x,y,width,height);
        g.setColor(c);
    }
    public Rectangle getRect() {
        return new Rectangle(x, y, width, height);
    }

}
