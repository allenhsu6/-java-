package thread;

import static java.lang.Thread.sleep;

public class TT implements Runnable {
    int b = 100;

    public synchronized void m1() {
        System.out.println("m1中第一次的b：" + b);
        try {
            sleep(5000);
            b = 250;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m1中第二次的b：" + b);
    }

    public synchronized void m2(){
        try {
            sleep(2000);
            b = 200;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2中第一次的b：" + b);
    }

    @Override
    public void run() {
        m1();
    }

    public static void main(String[] args) {
        TT tt = new TT();
        Thread thread =  new Thread(tt);
        thread.start();
        tt.m2();
    }
}
