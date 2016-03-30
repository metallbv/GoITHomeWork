package UML.DistanceBetweenDot;

public class RunnerCalculateDistance {

    public static void main(String[] args) {

        Dot a = new Dot(0, 0);
        Dot b = new Dot(5, 5);
        System.out.println("Distance between a: " + "x = " + a.getX() + " y = " + a.getY() + " & b: " +
                "x = " + b.getX() + " y = " + b.getY() + " = " + calculateDistance(a, b));
    }

    public static double calculateDistance(Dot a, Dot b) {
        return Math.sqrt(Math.pow((b.getX() - a.getX()), 2) + Math.pow((b.getY() - a.getY()), 2));
    }

}
