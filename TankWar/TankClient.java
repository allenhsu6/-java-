
import javafx.scene.paint.Stop;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class TankClient extends Frame {
    public static final int GAME_WIDTH = 800;
    public static final int GAME_WEIGHT = 600;
    Tank myTank = new Tank(50, 50, true, Tank.Direction.STOP, this);
    List<Tank> tanks = new ArrayList<>();
    List<Explode> explodes = new ArrayList<>();
    List<Bullet> bullets = new ArrayList<>();
    private Image offScreenImage;

    public void paint(Graphics g) {
        g.drawString("子弹数量: " + bullets.size(), 360, 50);
        g.drawString("爆炸数量: " + explodes.size(), 200, 50);
        g.drawString("敌军数量: " + tanks.size(), 100, 50);


        for (int i = 0; i < bullets.size(); i++) {
            Bullet b = bullets.get(i);
            b.hitTanks(tanks);
            b.hitTank(myTank);
            b.draw(g);
        }
        for (int i = 0; i < explodes.size(); i++) {
            Explode e = explodes.get(i);
            e.draw(g);
        }
        for (int i = 0; i < tanks.size(); i++) {
            Tank t = tanks.get(i);
            t.draw(g);
        }

        myTank.draw(g);
    }

    //双缓冲解决闪烁现象，添加一个虚拟图片，先全部画出来再搬家到屏幕上
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_WEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(new Color(0x89C896));
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_WEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);

    }


    public void tankLaunch() {
        for (int i = 0; i < 10; i++) {
            Tank t = new Tank(50 + 50 * (i + 1), 50, false, Tank.Direction.D, this);
            tanks.add(t);
        }
        setTitle("徐志作品：TankWar");
        setResizable(false);
        setBackground(new Color(0x89C896));
        setBounds(400, 300, GAME_WIDTH, GAME_WEIGHT);
        //内部类的使用
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setVisible(true);
        new Thread(new PaintThread()).start();
        this.addKeyListener(new KeyMonitor());
    }

    public static void main(String[] args) {
        TankClient tc = new TankClient();
        tc.tankLaunch();
    }

    private class KeyMonitor extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            myTank.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            myTank.keyReleased(e);
        }

    }

    private class PaintThread implements Runnable {
        public void run() {
            while (true) {
                repaint();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}