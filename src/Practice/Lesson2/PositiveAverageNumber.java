package Practice.Lesson2;

/*
Додатнє Середнє Арифметичне

Знайти середнє арифметике двух додатніх чисел.
Наприклад:
average( 2, 4 ) = 3
average( 4, 7 ) = 5
 */

public class PositiveAverageNumber {

    public static void main(String[] args) {

        PositiveAverageNumber positiveAverageNumber = new PositiveAverageNumber();
        System.out.println(positiveAverageNumber.average(2147483647,2147483645));
    }

    public int average(int a, int b) {

        int result = 0;
        result = (a+b)>>>1;

        return result;
    }
}
