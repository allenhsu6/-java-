public class LearnAgain {
    public static void main(String[] args) {
       LearnKidCircle kc = new LearnKidCircle(500);
       int Number = 0;
        LearnKid k = kc.first;
        while (kc.count>1){
           Number++;
           if (Number==3){
               kc.delete(k);
               Number = 0;
           }
           k = k.right;
       }
       System.out.println(kc.first.id);
    }
}

class LearnKid {
    int id;  //我的id是从一开始的
    LearnKid left;
    LearnKid right;


}

class LearnKidCircle {
    int count;
    LearnKid first, last;

    LearnKidCircle(int n) {
        for (int i = 0; i < n; i++) {
            add();

        }
    }

    void add() {
        LearnKid k = new LearnKid();
        if (count <= 0) {
            first = k;
            last = k;
            k.left = k;
            k.right = k;
        } else {
            k.right = first;
            k.left = last;
            last.right = k;
            first.left = k;
            last = k;
        }
        count++;
        k.id = count;
    }

    void delete(LearnKid k) {
        if (count == 1) {
            first = last = null;
        } else {
            k.left.right = k.right;
            k.right.left = k.left;
        }
        if (k == first)
            first = k.right;
        if (k == last)
            last = k.left;
        count--;
    }
}
