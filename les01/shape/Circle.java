package les1.shape;

public class Circle implements Shape{
    private double radius;

    public Circle(double radius) {
        this.radius = Math.abs(radius);
    }

    @Override
    public double getArea() {
        return 3.14 * radius * radius;
    }
}
