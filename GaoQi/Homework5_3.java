package GaoQi;

public class Homework5_3 {
    public static void main(String[] args) {
        Celebrity celebrity = new Celebrity("杨幂");
        celebrity.action();
        celebrity.filming();
        celebrity.Song();
    }
}

interface Movie {
    void filming(); //接口的方法没有方法体
}

interface TV {
    void action();
}

interface Music {
    void Song();
}

class Celebrity implements Movie, TV, Music {
    private String name;

    public Celebrity(String name) {
        this.name = name;
        System.out.println("大家好,我是"+name);

    }

    @Override
    public void filming() {
        System.out.println("我能演电影");
    }

    @Override
    public void action() {
        System.out.println("我能演电视剧");
    }

    @Override
    public void Song() {
        System.out.println("我还会唱歌");
    }
}