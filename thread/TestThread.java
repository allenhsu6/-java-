package thread;

//所有你曾经没有敲过的代码，都会让你难受，还要回头再来熬过
public class TestThread {
    public static void main(String[] args) {
        Runner1 r = new Runner1();
        //r.run();
        r.start();//start只是一个就绪状态，等待cpu给你信息
        //在运行过程中，可能被某件事情的发生导致阻塞
       // Thread t = new Thread(r);
        //t.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("Main thread---" + i);
        }
    }
}
//原则：接口比较灵活，继承比较死板，建议使用接口来做多线程
//class Runner1 implements Runnable{
//第二种方法
class Runner1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("thread1----" + i);
        }
    }
}
