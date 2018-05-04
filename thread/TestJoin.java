package thread;

import java.util.Date;

public class TestJoin {
    public static void main(String[] args) {
        Runner2 r2 = new Runner2("name");
        r2.start();
        try {
            r2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("this is mainthread");
        }
    }
}
class Runner2 extends Thread{
    Runner2(String s){ //传入的s是名字
        super(s);
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("==="+new Date()+"===");
            try {
                sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}