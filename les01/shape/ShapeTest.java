package les1.shape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShapeTest {
    public static void main(String[] args) {
        List<Shape> shapes = Arrays.asList(new Circle(5.0), new Circle(4.0), new Square(3.0), new Triangle(4.0, 3.0, 5.0));
        for (Shape shape : shapes) {
            System.out.println(shape.getArea());
        }
    }
}
