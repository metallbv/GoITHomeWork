package UML.DistanceBetweenDot;

public class Dot {

    private double x;
    private double y;

    public Dot(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void printDot() {
        System.out.println("x: " + x + " y: " + y);
    }

}
