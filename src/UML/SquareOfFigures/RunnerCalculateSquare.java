package UML.SquareOfFigures;

public class RunnerCalculateSquare {

    public static void main(String[] args) {
        Figure rectangle = new Rectangle(3.0, 5.0);
        Figure circle = new Circle(6.0);
        Figure triangle = new Triangle(3.0, 4.0, 5.0);

        rectangle.printSquare();
        circle.printSquare();
        triangle.printSquare();
    }

}
