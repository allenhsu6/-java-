import java.io.*;

public class TestBufferStream {
    public static void main(String[] args) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/allenhsu/Desktop/thanks.txt"));
            BufferedReader br = new BufferedReader(new FileReader("/Users/allenhsu/Desktop/thanks.txt"));
            String s = null;
            for (int i = 0; i < 100; i++) {
                s = String.valueOf(Math.random());
                bw.write(s);
                bw.newLine();
            }
            bw.flush();
            while ((s = br.readLine()) != null){
                System.out.println(s);
            }
            bw.close();
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
