import java.io.File;

public class TestFile{
    public static void main(String[] args) {
        File f = new File("/Users/allenhsu/Documents/IDEA/UI");
        System.out.println(f.getName());
        tree(f,1);
    }
    private static void tree(File f, int level){
        File[] childs = f.listFiles();
       String appendChr = "";
        for (int d = 0; d < level; d++) {
            appendChr += "  ";
        }
        for (int i = 0; i < childs.length; i++) {
            System.out.println(appendChr + childs[i].getName());
            if (childs[i].isDirectory())
                tree(childs[i], level+1);
        }
    }
}


