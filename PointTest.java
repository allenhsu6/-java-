import static java.lang.Math.sqrt;

public class PointTest {
    private int x, y, z;
    public PointTest(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public double calculate(){
        double m =  sqrt(x*x+y*y+z*z);
        return  m;
    }

    public static void main (String[] args){
        PointTest pt;
        pt = new PointTest(3,4,5);
        System.out.println(pt.calculate());
    }
}
