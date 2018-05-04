
public class VisualAccumulator {
    private double total;
    private int N;
    public VisualAccumulator(int trials, double max){
        //画幕布
        StdDraw.setXscale(0, trials);
        StdDraw.setYscale(0, max);
        StdDraw.setPenRadius(.005);
    }
    public void addDataValue(double val){
        //函数接口设定的数据你就正常写，如何IO使用例应该操心的事情
    N++;
    total += val;
    StdDraw.setPenColor(StdDraw.RED);
    StdDraw.point(N, total/N);
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.point(N, val);
    }
    public double mean(){
    return total/N;
    }
    public String tostring(){
    return "Mean (" +N+ "values):" + String.format("%7.5f", mean());
    }
    //用例
    public static void main(String [] args){
        VisualAccumulator a;
        a = new VisualAccumulator(1000, 1);
        for (int i = 0; i<1000; i++){
            a.addDataValue(StdRandom.random());
        }
        StdOut.println(a);
    }
}
