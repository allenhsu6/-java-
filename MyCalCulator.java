import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class MyCalCulator {
    /**
     * 构造函数 主要处理各种监听事项
     */
    public MyCalCulator() {
        panel.setHorizontalAlignment(JTextField.RIGHT);//设置右对齐
        equal.setBackground(Color.RED);
        panel.setBackground(Color.pink);
        /**
         * 事件处理程序，其中包括五大类的逻辑响应
         */
        //数字键 这里对ss和str直接+仍然有疑问
        class Listener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ss = ((JButton) e.getSource()).getText();//将当前的text存入ss
                store = (JButton) e.getSource();
                vt.add(store); //顺手将点击的按钮名字存入vector
                if (k1 == 1) {
                    if (k3 == 1) {
                        str1 = "";
                        k5 = 1;//还原k5状态
                    }
                    str1 = str1 + ss;
                    k3 += 1;
                    panel.setText(str1);
                } else if (k1 == 2) {
                    if (k4 == 1) {
                        str2 = "";
                        k5 = 1;
                    }
                    str2 = str2 + ss;
                    k3 += 1;
                    panel.setText(str2);
                }
            }

        }
        //输入运算符的处理
        class Listener_signal implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                String ss2 = ((JButton) e.getSource()).getText();
                store = (JButton) e.getSource();
                vt.add(store);

                if (k2 == 1) {
                    // 开关 k1 为 1 时向数 1 写输入值，为2时向数2写输入值。
                    k1 = 2; // 判断是 str2
                    k5 = 1; //判断小数点
                    signal = ss2;
                    k2 = k2 + 1;// 按符号键的次数
                } else {
                    int a = vt.size();
                    JButton c = (JButton) vt.get(a - 2);

                    if (!(c.getText().equals("+"))
                            && !(c.getText().equals("-"))
                            && !(c.getText().equals("*"))
                            && !(c.getText().equals("/")))

                    {
                        cal();
                        str1 = result;
                        // 开关 k1 为 1 时，向数 1 写值，为2时向数2写
                        k1 = 2;
                        k5 = 1;
                        k4 = 1;
                        signal = ss2;
                    }
                    k2 = k2 + 1;

                }
            }
        }
        //清除建的逻辑
        class Listener_clear implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                store = (JButton) e.getSource();
                vt.add(store);
                k1 = 1;
                k5 = 1;
                k2 = 1;
                k3 = 1;
                k4 = 1;
                str1 = "0";
                str2 = "0";
                signal = "";
                result = "";
                panel.setText(result);
                vt.clear();
            }
        }
        //=键的处理
        class Listener_dy implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                store = (JButton) e.getSource();
                vt.add(store);
                cal();
                k1 = 1;
                k2 = 1;
                k3 = 1;
                k4 = 1;

                str1 = result; //不懂
            }
        }
        //小数点的处理
        class Listener_point implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                store = (JButton) e.getSource();
                vt.add(store);
                if (k5 == 1) {
                    String ss2 = ((JButton) e.getSource()).getText();
                    if (k1 == 1) {
                        if (k3 == 1) {
                            str1 = "";
                            // 还原开关k5状态
                            k5 = 1;
                        }
                        str1 = str1 + ss2;

                        k3 = k3 + 1;

                        // 显示结果
                        panel.setText(str1);

                    } else if (k1 == 2) {
                        if (k4 == 1) {
                            str2 = "";
                            // 还原开关k5的状态
                            k5 = 1;
                        }
                        str2 = str2 + ss2;

                        k4 = k4 + 1;

                        panel.setText(str2);
                    }
                }

                k5 = k5 + 1;
            }
        }

        //注册各个监听器
        Listener_dy jt_dy = new Listener_dy();
        Listener jt = new Listener();
        Listener_clear jt_clear= new Listener_clear();
        Listener_point jt_point = new Listener_point();
        Listener_signal jt_signal = new Listener_signal();

        a1.addActionListener(jt);
        a2.addActionListener(jt);
        a0.addActionListener(jt);
        a3.addActionListener(jt);
        a4.addActionListener(jt);
        a5.addActionListener(jt);
        a6.addActionListener(jt);
        a7.addActionListener(jt);
        a8.addActionListener(jt);
        a9.addActionListener(jt);
        plus.addActionListener(jt_signal);
        minus.addActionListener(jt_signal);
        multi.addActionListener(jt_signal);
        division.addActionListener(jt_signal);
        equal.addActionListener(jt_dy);
        point.addActionListener(jt_point);
        CLEAN.addActionListener(jt_clear);
    }



    public void cal() {
        //操作数
        double a2;
        double b2;
        //运算符
        String c = signal;
        //运算结果
        double result2 = 0;
        if (c.equals("")) {
            panel.setText("please input operator");
        } else {
            if (str1.equals("."))
                str1 = "0.0";
            if (str2.equals("."))
                str2 = "0.0";
            a2 = Double.parseDouble(str1);
            b2 = Double.parseDouble(str2);
            if (c.equals("+"))
                result2 = a2 + b2;
            if (c.equals("-"))
                result2 = a2 - b2;
            if (c.equals("*"))
                result2 = a2 * b2;
            if (c.equals("/"))
                if (b2 == 0)
                    result2 = 0;
                else
                    result2 = a2 / b2;
        }

        result = ((new Double(result2)).toString());
        panel.setText(result);

    }


    public static void main(String[] args) {
        //创建计算器主窗口
        JFrame frame = new JFrame("徐志的计算器");
        frame.setContentPane(new MyCalCulator().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocation(300, 200);//设置出现在主屏幕上的位置
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private JPanel panel1;
    private JButton plus;
    private JButton a7;
    private JButton CLEAN;
    private JButton division;
    private JButton equal;
    private JButton a4;
    private JButton multi;
    private JButton a8;
    private JButton a9;
    private JButton a6;
    private JButton a3;
    private JButton minus;
    private JButton a5;
    private JButton a2;
    private JButton a0;
    private JButton a1;
    private JTextField panel;
    private JButton point;


    private String str1 = "0";  //操作数1
    private String str2 = "0";  // 操作数2
    private String signal = "+"; //运算符
    private String result = ""; //结果
    int k1 = 1; //开关1用于选择输入为str1 或 str2
    int k2 = 1; //用于记录符号次数
    int k3 = 1; //标识str1 是否可以被清零
    int k4 = 1; //标识str2 是否可以被清零
    int k5 = 1; //控制小数点是否可被录入 =1可以录入
    JButton store; //记录是否连续按下符号键

    Vector vt = new Vector(20, 10);
}
