package test_shapes;


public abstract class Shape {
    public abstract double area();

    public abstract double perimeter();

    @Override
    public String toString() {
        return getClass().getSimpleName()
        + " | aire =" + Math.round(area() * 100.0) / 100.0
        + " | périmètre=" + Math.round(perimeter() * 100.0) / 100.0;
    }
}
