package UML.Temperature;

public class ConvertTemperature {

    public static void main(String[] args) {

        ConvertTemperature convertTemperature = new ConvertTemperature();
        System.out.println("36,6 celsium is a " + convertTemperature.convertToForengeyte(36.60) + " forengeit");
        System.out.println("451 forengeit is a " + convertTemperature.convertToCelsium(451.0) + " celsium");

    }

    public double convertToForengeyte(double celsium) {

        return celsium * 9 / 5 + 32;

    }

    public double convertToCelsium(double forengeit) {

        return (forengeit - 32) * 5 / 9;

    }

}
