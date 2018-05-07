package GUI;
// 这个例子值得细细品味，其中有很多知识
//mouseadapt和repaint 以及ArrayList迭代等知识点的混合使用
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class MyMouseAdapter {
    public static void main(String[] args) {
        new MouseFrame("i love this  world");
    }
}
class MouseFrame extends Frame{
    ArrayList points;
    MouseFrame(String s){
        super(s);
        points = new ArrayList();
        setLayout(null);
        setBackground(new Color(0x5DBB75));
        setBounds(30,30,500,500);
        setVisible(true);
        addMouseListener(new Monitor());
        addWindowListener(new Windows());
    }
    class Windows extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent e) {
            setVisible(false);
            System.exit(0);
        }
    }
    public void paint(Graphics g){
        Iterator<Point> i = points.iterator();
        while (i.hasNext()){
            Point p = i.next();
            if (p.x>250){
                g.setColor(new Color(0xB4BB57));
                g.fillOval(p.x,p.y,15,15);
            }else{
                g.setColor(new Color(0xBB6F74));
                g.fillOval(p.x,p.y,20,20);
            }

        }
    }
    public void addpoint(Point p){
        points.add(p);
    }
}
class Monitor extends MouseAdapter{
    @Override
    public void mousePressed(MouseEvent e) {
        MouseFrame m =(MouseFrame) e.getSource();
        m.addpoint(new Point(e.getX(),e.getY()));
        m.repaint(); //repaint方法很重要，不然无法刷新整个页面
    }
}