import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HomeworkForExtends {
    public HomeworkForExtends() {

    }

    public void DrawPerson(int x, int y) {
        /** 创建相框
         * 相框实例名字为jFrame
         */
        JFrame jFrame = new JFrame();
        /** 创建画板
         * 我的画板名字为jpanel
         */
        JPanel jpanel = new JPanel() {
            // 重写paint方法
            @Override
            public void paint(Graphics graphics) {
                // 必须先调用父类的paint方法
               // super.paint(graphics);
                // 用画笔Graphics，在画板JPanel上画一个小人
                graphics.drawOval(x, y-30, 30, 30);// 头部（画圆形）
                graphics.drawRect(x+5, y, 20, 30);// 身体（画矩形）
                graphics.drawLine(x+5, y, 75, 120);// 左臂（画直线）
                graphics.drawLine(x+25, y, 150, 120);// 右臂（画直线）
                graphics.drawLine(x+5, y, 75, 150);// 左腿（画直线）
                graphics.drawLine(x+25, y, 150, 150);// 右腿（画直线）
            }
        };
        //将绘有小人图像的画板嵌入到相框中
        jFrame.add(jpanel);
        // 设置画框大小（宽度，高度），默认都为0
        jFrame.setSize(300, 300);
        // 将画框展示出来。true设置可见，默认为false隐藏
        jFrame.setVisible(true);
    }
}

