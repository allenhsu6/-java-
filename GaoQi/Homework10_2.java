package GaoQi;


import java.io.*;

/**
 * 实现字节数组和任何基本类型和引用类型执行的相互转换
 */
public class Homework10_2 {
    public static void main(String[] args) {
        ByteArrayInputStream bais = null;
        ByteArrayOutputStream baos = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        Student student = new Student(100, "allen", 88.8);
        try {
            baos = new ByteArrayOutputStream(1024);
            oos = new ObjectOutputStream(baos);
            oos.writeBoolean(true);
            oos.writeUTF("徐志是天才");
            oos.writeObject(student);
            //各种类型转化为字节数组
            byte[] bytes = baos.toByteArray();
            // 里面装的是255以内的数字
            System.out.println(bytes.length);

            bais = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(bais);
            System.out.println(ois.readBoolean());
            System.out.println(ois.readUTF());
            System.out.println(ois.readObject());


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
                bais.close();
                oos.close();
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
