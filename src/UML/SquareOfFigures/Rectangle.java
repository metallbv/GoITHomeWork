package UML.SquareOfFigures;

public class Rectangle extends Figure {

    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public double calculateSquare(){
        return height * width;
    }

    @Override
    public void printSquare() {
        System.out.println("Rectangle: " + "height: " + height + " width: " + width +
        " square = " + calculateSquare());
    }

}
