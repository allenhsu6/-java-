

public class WordDb {
    Word[] myWord;
    int top;
    int size, increment;

    public WordDb() {
        top = -1;
        size = 3;
        increment = 3;
        myWord = new Word[size];
    }


    public void addWord(String english, String chinese) {
        //if循环中实现数据存储的动态扩充
        if (top == size - 1) {
            Word[] temp1 = new Word[size + increment];
            size = size + increment;
            for (int i = 0; i <= top; i++) {
                temp1[i] = myWord[i];
            }
            myWord = temp1;
        }
        top++;
        myWord[top] = new Word(english, chinese); //new和构造函数是好搭档
    }


    public String Search(String englishParam) {
        for (int i = 0; i <= top; i++) {
            if (myWord[i].getEnglish().equals(englishParam))
                return myWord[i].getChinese();
        }
        return null;
    }

    /*
      这里记得修改toString方法
     */
    @Override
    public String toString() {
        System.out.println();
        return "11";
    }
}
