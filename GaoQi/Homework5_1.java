package GaoQi;

public class Homework5_1 {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(3,5);
        System.out.println(cylinder.getRadius());
        System.out.println(cylinder.perimeter());
        System.out.println(cylinder.area());
        System.out.println(cylinder.volume());
    }
}


class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
    public double area(){
        return getRadius()*getRadius()*Math.PI;
    }

    public double perimeter(){
        return getRadius()*2*Math.PI;
    }
}


class Cylinder extends Circle{
    private double high;
    // 继承父类的话，自动继承父类的构造方法
    public Cylinder(double radius, double high) {
        super(radius);
        this.high = high;
    }

    public double volume(){
        return area()*high;
    }
}