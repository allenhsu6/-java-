
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Dictionary extends Frame implements ActionListener {
    static Transaction transaction;
    Label Lenglish, Lchinese;
    TextField tfEnglish, tfchinese;
    Button btLearn, btSearch;

    // 构造函数，初始化字典
    public Dictionary() {
        Lenglish = new Label("英文");
        Lchinese = new Label("中文");
        tfchinese = new TextField(15);
        tfEnglish = new TextField(15);
        btLearn = new Button("learn");
        btSearch = new Button("Search ");
        transaction = new Transaction();
        setBounds(300, 200, 300, 200);
        setLayout(new FlowLayout());

        add(Lenglish);
        add(tfEnglish);
        add(Lchinese);
        add(tfchinese);
        add(btLearn);
        add(btSearch);
        setVisible(true);
        btSearch.addActionListener(this);
        btLearn.addActionListener(this);
        addWindowListener(new Window());
    }

    public static void main(String[] args) {
        Dictionary dc = new Dictionary();
        //dc.show();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btLearn)) {
            transaction.learn(tfEnglish.getText(), tfchinese.getText());
        }
        if (e.getSource().equals(btSearch)) {
            String result = transaction.search(tfEnglish.getText());
            tfchinese.setText(result);
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





