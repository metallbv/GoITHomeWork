package Practice.Lesson1;

/*
Сума Цифр

Обчислити суму цифр числа.
Наприклад сума цифр числа 123 дорівнює  6.
 */

public class SumDigits {

    public static void main(String[] args) {

        SumDigits sumDigits = new SumDigits();
        System.out.println(sumDigits.sum(123));

    }

    public int sum(int number) {

        int sum = 0;

        while (number != 0){
            sum = sum + number%10;
            number = number / 10;
        }

        return Math.abs(sum);
    }

}
