package thread;

public class TestSyna implements Runnable{
    Timer timer = new Timer();//要使用的资源
    public static void main(String[] args) {
        TestSyna ts = new TestSyna();
        Thread t1 = new Thread(ts);
        Thread t2 = new Thread(ts);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        timer.add(Thread.currentThread().getName());
    }
}
class Timer{
    private static int num = 0;
    public synchronized void add(String name) {
        //synchronized (this) {
            num++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + "是第" + num + "个使用timer的线程");
        }
    //}
}