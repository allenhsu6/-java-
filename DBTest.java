import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBTest extends Frame implements ActionListener {
    Label Lenglish, Lchinese;
    TextField tfEnglish, tfchinese;
    Button btLearn, btSearch, btDelete;

    //这部分缺少与数据库的连接，我这里想跟mysql直接连接
    Connection con = null;
    Statement statement = null;
    ResultSet resultSet = null;


    DBTest() {
        Lenglish = new Label("英文");
        Lchinese = new Label("中文");
        tfchinese = new TextField(15);
        tfEnglish = new TextField(15);
        btLearn = new Button("learn");
        btSearch = new Button("Search ");
        btDelete = new Button("Delete");
        setBounds(300, 200, 300, 200);
        setLayout(new FlowLayout());

        add(Lenglish);
        add(tfEnglish);
        add(Lchinese);
        add(tfchinese);
        add(btLearn);
        add(btSearch);
        add(btDelete);
        setVisible(true);
        btSearch.addActionListener(this);
        btLearn.addActionListener(this);
        btDelete.addActionListener(this);
        addWindowListener(new Window());
    }

    public static void main(String[] args) {
        DBTest dt = new DBTest();
    }

    //原始方法
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btLearn)) {
            String sql = "insert into dic (english, chinese) values('gao','lian')"; //这里加sql语句
        }
        if (e.getSource().equals(btSearch)) {

        }
        if (e.getSource().equals(btDelete)) {

        }
    }

    //写成内部类的形式
    class Window extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }
}

