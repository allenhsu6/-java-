package thread;

import java.util.Date;

import static java.lang.Thread.sleep;

//sleep方法 interrupt方法以及stop方法
public class TestSleep {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread t =   new Thread(t1);
        t.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
        t.interrupt();
    }

}
//继承runnable接口，重写run方法
class Thread1 implements Runnable{

    @Override
    public void run() {
        Boolean flag = true;
        while (flag){
            System.out.println("==="+new Date()+"===");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}