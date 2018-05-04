public class Transaction {
    public WordDb db;
    public Transaction(){
        db = new WordDb();
    }
    public void learn(String english, String chinese){
        db.addWord(english, chinese);
    }
    public String search(String english){
        String result;
        result = db.Search(english.toUpperCase());
        if (result!= null)
            return result;
        result = db.Search(english.toLowerCase());
        if (result!= null)
            return result;
        return result;
    }
}
