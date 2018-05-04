public class TestInterface {
    public static void main(String[] args) {
    Worker xu = new Worker();
    Farmer zhi = new Farmer();
    xu.feed();
    zhi.play();
    }
}
interface CarePet{
    void play();
    void feed();
}
class Worker implements CarePet{

    @Override
    public void play() {
        System.out.println("工人玩宠物");
    }

    @Override
    public void feed() {
        System.out.println("Worker喂宠物ing");
    }
}
class Farmer implements CarePet{

    @Override
    public void play() {
        System.out.println("农民玩宠物ing");
    }

    @Override
    public void feed() {
        System.out.println("农民喂宠物ing");
    }
}