public class TestArray {
    public static void main(String[] args) {
        int[] a = {4, 7, 3, 9, 8, 5, 1, 2, 6};
        print(a);
        int k,temp;
        for (int i = 0; i < a.length; i++) {
            k = i;
            for (int j = k; j < a.length; j++) {
                if (a[j] < a[k]) {
                    k = j;
                }
            }
            temp = a[k];
            a[k] = a[i];
            a[i] = temp;
        }
        print(a);

    }
    private static void print(int[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}
