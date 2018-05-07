package thread;

import static java.lang.Thread.sleep;

public class ProducerConsumer{
    public static void main(String[] args) {
        Box box = new Box();
        Consumer consumer = new Consumer(box);
        Producer producer1 = new Producer("一号厨师",box);
        Producer producer2 = new Producer("二号厨师",box);
        Thread t1 = new Thread(producer1);
        Thread t2 = new Thread(producer2);
        Thread t3 = new Thread(consumer);
        t1.start();
        t2.start();
        t3.start();
    }
}

class Bread{
    int id; //馒头的id，意味着第id个馒头被做出来或者被吃掉
    Bread(int id){
        this.id = id;
    }
    public String toString(){
        return "第"+(id+1)+"个面包";
    }
}
class Box{
    int count; //箱子里面的面包数量
    Bread[] breads = new Bread[6];

    public synchronized void add(Bread bread){
        while (count==breads.length){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notifyAll();
        breads[count] = bread;
        count++;
    }
    public synchronized Bread pop(){
        while (count== 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notifyAll();
        count--;
        return breads[count];
    }
}

class Producer implements Runnable{
    Box box;
    String name;
    Producer(String name, Box box){ //每次调用厨师类的时候给厨师起好名字,传进来box就解决了针对两个box不一致的问题
      this.name = name;
      this.box = box;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            box.add(new Bread(i));
            System.out.println(name+"做出的第"+(i+1)+"个面包");
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name+"下班了");

    }
}

class Consumer implements Runnable{
    Box box;
    Consumer(Box box){
        this.box = box;
    }
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("筐子里还有"+(box.count)+"个面包");
            box.pop();
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("客人吃掉第" + (i+1) + "个面包");
        }
        System.out.println("客人吃饱了");

    }
}