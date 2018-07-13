package GaoQi;

public class Homework6_2 {
    public static void main(String[] args) {
       System.out.println(new Score(111).getScore());
    }
}
// 这里是自定义的一种exception
class InputException extends Exception{
    // 带详细信息的构造器
    public InputException(String message) {
        super(message);
    }
}

/**
 * 在开始使用的时候
 */
class Score{
    private int score;

    public int getScore() {
        return score;
    }

    public Score(int score) {
        try {
            setScore(score);
        } catch (InputException e) {
            e.printStackTrace();
        }
    }

    public void setScore(int score) throws InputException {
        if ( score > 100 || score < 0){
            throw new InputException("分数应该在0-100之间");
        }
        this.score = score;
    }
}