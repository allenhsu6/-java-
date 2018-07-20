
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//该类实现对word数据的两种操作
public class WordLinked {
    List<Word> words = new LinkedList<>();

    public void learn(String english, String chinese) {
        Word word = new Word(english, chinese);
        words.add(word);
    }

    // 使用iterator的时候，要先定义Iterator
    // 迭代过程中，for循环和while循环使用起来有区别，感觉while使用起来舒服一些

    public String search(String english) {
        Iterator i = words.iterator();
        while (i.hasNext()) {
            Word word = (Word) i.next();
            if (word.english.equalsIgnoreCase(english)) {
                return word.getChinese();
            }
        }
//        for ( ;i.hasNext();) {
//            Word word = (Word) i.next();
//            if (word.english.equalsIgnoreCase(english)){
//                return word.getChinese();
//            }
//        }

        return null;
    }
}
