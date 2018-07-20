
public class Word {
    String chinese;
    String english;

    public Word(String english, String chinese) {
        this.chinese = chinese;
        this.english = english;
    }

    public String getChinese() {
        return chinese;
    }

    public String getEnglish() {
        return english;
    }

    @Override
    public String toString() {
        return english + "/" + chinese;
    }
}
