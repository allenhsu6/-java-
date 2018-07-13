package GaoQi;

/**
 * 有没有感受到多态带来的便捷？
 * 在你具体事例使用的时候，不知道到底要用到那个类，我就传入父类，然后现场父类引用指向子类对象
 */
public class Homework5_2 {
    public static void main(String[] args) {
        Musician musician = new Musician();
        musician.play(new Erhu());
        musician.play(new Pinao());
    }
}

class Instrument{
    public void makeSound(){
        System.out.println("使用乐器发出声音");
    }
}
class Erhu extends Instrument{
    @Override
    public void makeSound() {
        System.out.println("使用二胡在演奏");
    }
}
class Pinao extends Instrument{
    @Override
    public void makeSound() {
        System.out.println("天噜惹，他还会钢琴");
    }
}

/**
 * 要能想到，乐手想要弹奏乐器，乐器是一个引用类型，是一个可实例化的对象啊
 * 要学会作为参数传入乐手的技能列表中
 */
class Musician{
    public void play(Instrument instrument){
        instrument.makeSound();
    }
}