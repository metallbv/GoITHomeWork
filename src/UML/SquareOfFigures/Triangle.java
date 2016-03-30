package UML.SquareOfFigures;

public class Triangle extends Figure{

    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    @Override
    public double calculateSquare(){
        return Math.sqrt((side1 + side2 + side3) * (side1 + side2 - side3) *
                (side1 + side3 - side2) * (side2 + side3 - side1)) / 4.0;
    }

    @Override
    public void printSquare() {
        System.out.println("Triangle: " + "side1: " + side1 + " side2: " + side2 +
        " side3: " + side3 + " square = " + calculateSquare());
    }

}
