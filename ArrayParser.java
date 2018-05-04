public class ArrayParser {
    public static void main(String[] args) {
        Double[][] d;
        String s = "1,2;3,4,5;6,7,8";
        String[] sFirst = s.split(";");//学着一点点的往前做，
        d = new Double[sFirst.length][];
        for (int i = 0; i < sFirst.length; i++) {
            String[] sSecond = sFirst[i].split(",");
            d[i] = new Double[sSecond.length];
            for (int j = 0; j < sSecond.length; j++) {
                d[i][j] = Double.parseDouble(sSecond[j]);
            }
        }
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[i].length; j++) {
                System.out.print(d[i][j]+" ");
            }
            System.out.println();
        }
    }
}
