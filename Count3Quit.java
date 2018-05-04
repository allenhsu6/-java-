public class Count3Quit {
    public static void main(String[] args) {
        boolean[] kids = new boolean[500];
        for (int i = 0; i < kids.length; i++) {
            kids[i] = true;
        }
        int count = 0;
        int inCircle = kids.length;
        int i = 0;
        while (inCircle > 1) {
            if (kids[i] == true) {
                count++;

                if (count == 3) {
                    kids[i] = false;
                    count = 0;
                    inCircle--;
                }
            }
            i++;
            if (i == kids.length)
                i = 0;
        }
        for (i = 0; i < kids.length; i++) {
            if (kids[i])
                System.out.println(i);
        }
    }
}
