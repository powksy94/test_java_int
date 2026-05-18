package test_shapes;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = List.of(
            new Circle(5),
            new Rectangle(4, 6),
            new Circle(3),
            new Rectangle(2, 2)
        );

        for (Shape s : shapes) {
            System.out.println(s);
        }

        Shape largest = shapes.get(0);
        for (Shape s : shapes) {
            if (s.area() > largest.area()) {
                largest = s;
            }
        }
        System.out.println("\nPlus grande aire : " + largest);
    }
}
