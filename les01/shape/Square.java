package les1.shape;

public class Square implements Shape {
    private double side;

    public Square(double side) {
        this.side = Math.abs(side);
    }

    @Override
    public double getArea() {
        return side * side;
    }
}
