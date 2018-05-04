import java.io.*;

public class TestObjectIO {
    public static void main(String[] args) {
        T tk = new T();
        tk.a = 21;
        try {
            FileOutputStream fos = new FileOutputStream("/Users/allenhsu/Desktop/thanks.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(tk);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("/Users/allenhsu/Desktop/thanks.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            T read = (T) ois.readObject();
            System.out.println(read.a+" "+read.b+" "+read.c+" " +read.d);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
class T implements Serializable{
    int a = 11;
    double b = 33.3;
  transient   Boolean c = true;
    transient int  d = 20;
}
