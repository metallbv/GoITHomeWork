package Practice.Lesson2;

/*
Знайти середнє значення двох цілих чисел.
Приклади:
average( 4, 6 ) = 5
average( -4, -7 ) = -5
average( -4, 7 ) = 1
 */

public class AverageNumber {

    public static void main(String[] args) {

        AverageNumber averageNumber = new AverageNumber();
        /*System.out.println("Max value : " + Integer.MAX_VALUE);
        System.out.println("Max value + 1 : " + (Integer.MAX_VALUE + 1));
        System.out.println("Max value + Max value : " + (Integer.MAX_VALUE + Integer.MAX_VALUE));
        System.out.println("Min value : " + Integer.MIN_VALUE);
        System.out.println("Min value - 1 : " + (Integer.MIN_VALUE - 1));
        System.out.println("Min value + Min value : " + (Integer.MIN_VALUE + Integer.MIN_VALUE));*/

        int a = 1000, b = 2000;
        //int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
        //int a = Integer.MAX_VALUE, b = Integer.MIN_VALUE;
        //int a = Integer.MIN_VALUE, b = Integer.MIN_VALUE;
        //int a = Integer.MIN_VALUE, b = -2147483646;

        /*System.out.println("a :     " + Integer.toBinaryString(a) + " " + a + " ~ " + ~a);
        System.out.println("b :     " + Integer.toBinaryString(b) + " " + b + " ~ " + ~b);
        System.out.println("a + b : " + Integer.toBinaryString(a+b) + " " + (a+b) + " ~ " + ~(a+b));*/

        System.out.println(averageNumber.average(a, b));

    }

    public int average(int a, int b) {

        int result = 0;

        if(((a > 0 & b > 0) & (a + b) <= 0))
            result = (a+b)>>>1;
        else if((a < 0 & b < 0) & (a + b) >= 0)
            result = ~((~a+~b)>>>1);
        else
            result = (a+b)/2;

        return result;
    }
}
