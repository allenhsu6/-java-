import java.util.Iterator;
 // 类名+类型+继承接口
public class ResizingArrayStack<Item> implements Iterable{
    // 使用泛型
    private Item[] a = (Item[]) new Object();
    private int N = 0;
    public boolean isEmpty()  {return N==0;}
    public int size()  {return  N; }
    // 生成一个大小为max的新的数组来放置a
    private void resize(int max){
        // 将栈移动到大小为max的新数组
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++){
            temp[i] = a[i];
        }
        a = temp;
    }
    public void push(Item item){
        // 将元素加在栈顶
        if (N==a.length)  resize(2*N);
        a[N++]=item;
    }
    public Item pop(){
        // 从栈顶删掉元素
        Item item = a[--N];
        a[N]=null;
        if (N>0 && N==a.length/4) resize(a.length/2);
        return item;
    }
    //返回迭代器
    public Iterator<Item> iterator(){
       return new ReverseArrayIterator();
    }
    //接口源于Iterator，输入泛型，添加三种实例方法
    private class ReverseArrayIterator implements Iterator<Item>{
        //支持后进先出的迭代
        private int i = N;
        public boolean hasNext() {return i>0; }
        public Item next() {return a[--i];}
        public void remove() {}
    }
}
