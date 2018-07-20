
public class Transaction {
    public WordLinked wordLinked;

    // transaction的构造方法
    public Transaction() {
        this.wordLinked = new WordLinked();
    }

    public void learn(String english, String chinese) {
        wordLinked.learn(english, chinese);
    }

    public String search(String english) {
        String result;
        result = wordLinked.search(english.toUpperCase());
        if (result != null)
            return result;
        result = wordLinked.search(english.toLowerCase());
        if (result != null)
            return result;
        return result;
    }
}


// 输入输出流
//    public void load(String fileName){
//        try {
//            BufferedReader br = new BufferedReader(new FileReader(fileName));
//            while (br.ready()){
//                String temp = br.readLine(); //读进来之后分开放入英文和中文中
//
//            }
//            br.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public void toDB(String fileName){
//        try {
//            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
//            bw.write(db.toString(),0,db.toString().length());
//            bw.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

