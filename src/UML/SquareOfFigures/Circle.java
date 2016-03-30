package UML.SquareOfFigures;

public class Circle extends Figure{

    private double radius;
    static final double PI = Math.PI;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getPi() {
        return PI;
    }

    @Override
    public double calculateSquare() {
        return Math.pow(radius, 2) * PI;
    }

    @Override
    public void printSquare() {
        System.out.println("Circle: " + "radius " + radius + " square = " + calculateSquare());
    }

}
