import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class First extends Applet implements ActionListener{
    //先生成各个小部件
    private Button bt, bt2;
    private TextField tf;
    private Panel p1;
    //初始化4个部件并添加，button设置监听
    public void init(){
        bt = new Button("name");
        bt2 = new Button("morning");
        tf = new TextField(20);
        p1 = new Panel();
        add(tf);
        add(bt);
        add(bt2);
        add(p1);

        bt.addActionListener(this);
        bt2.addActionListener(this);
// 设置布局
        p1.setLayout(new GridLayout(1,2));
        p1.add(tf);
        p1.add(bt);
    }
    // 开始监听活动，当听到bt就settext为good morning
    public void actionPerformed(ActionEvent e){
        if (e.getSource().equals(bt))
            tf.setText("good morning");
        else
            tf.setText("good evening");
    }

}
