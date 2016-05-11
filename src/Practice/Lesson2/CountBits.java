package Practice.Lesson2;

/*
Кількість біт

Для даного числа порахувати кількість біт.
Наприклад:
Для числа 13 в бінарному вигляді 1101 повернути 3.
 */

public class CountBits {

    public static void main(String[] args) {

        CountBits countBits = new CountBits();
        System.out.println(countBits.count(8));
    }

    public int count(int num) {

        int counter = 0;

        for(int i = 0; i < 32; i++){
            int temp = num>>i;
            int mask = temp & 1;
            if(mask == 1) counter++;
        }
        return counter;
    }
}
