package GaoQi;
// 解决了一个问题，图片上下叠放位置不同显示效果不同
import  java.awt.*;
import javax.swing.*;

public class BallGame extends JFrame {

    Image ball = Toolkit.getDefaultToolkit().getImage("/Users/allenhsu/Desktop/ppaa.png");
    Image desk = Toolkit.getDefaultToolkit().getImage("/Users/allenhsu/Desktop/BallGame.jpg");

    double x = 100;    //小球的横坐标
    double y = 100; //小球的纵坐标

    double degree = 3.14 / 3;    //弧度。此处就是：60度

    //画窗口的方法
    public void paint(Graphics g) {
        g.drawImage(desk, 0, 0, null);  //先画桌子
        g.drawImage(ball, (int) x, (int) y, null); // 再画球 否则你永远看不见球，被桌子覆盖啊


        x = x + 10 * Math.cos(degree);
        y = y + 10 * Math.sin(degree);

        //碰到上下边界
        if (y > 500 - 40 - 30 || y < 40 + 40) {//500是窗口高度；40是桌子边框，30是球直径；最后一个40是标题栏的高度
            degree = -degree;
        }

        //碰到左右边界
        if (x < 40 || x > 856 - 40 - 30) {
            degree = 3.14 - degree;
        }

    }

    //窗口加载
    void launchFrame() {
        setSize(856, 500);
        setLocation(50, 50);
        setVisible(true);

        //重画窗口,每秒画25次
        while (true) {
            repaint();
            try {
                Thread.sleep(30);   //40ms,   1秒=1000毫秒.  大约一秒画25次窗口
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    //main方法是程序执行的入口
    public static void main(String[] args) {
        System.out.println(" 我是尚学堂高淇，这个游戏项目让大家体验编程的快感，寓教于乐！");
        BallGame game = new BallGame();
        game.launchFrame();
    }
}