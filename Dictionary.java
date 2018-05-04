import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dictionary extends Frame implements ActionListener {
    Label Lenglish, Lchinese;
    TextField tfEnglish, tfchinese;
    Button btLearn, btSearch;
    Transaction transaction;

    public static void main(String[] args) {
        Dictionary dc = new Dictionary();
        dc.show();
    }

    public Dictionary() {
        Lenglish = new Label("英文");
        Lchinese = new Label("中文");
        tfchinese = new TextField(15);
        tfEnglish = new TextField(15);
        btLearn = new Button("learn");
        btSearch = new Button("Search ");
        transaction = new Transaction();

        setLayout(new FlowLayout());
        add(Lenglish);
        add(tfEnglish);
        add(Lchinese);
        add(tfchinese);
        add(btLearn);
        add(btSearch);

        btSearch.addActionListener(this);
        btLearn.addActionListener(this);
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
}





