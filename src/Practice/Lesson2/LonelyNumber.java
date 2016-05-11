package Practice.Lesson2;

/*
Самотнє Число

Дано масив цілих чисел. Всі числа в масиві повторюються рівно 5 разів і лише одне число не має дублікатів.
Знайти число, що неповторюється.
 */

public class LonelyNumber {

    public static void main(String[] args) {

        int[] array = {5,5,6,5,5,5,9,9,9,9,9};
        LonelyNumber lonelyNumber = new LonelyNumber();
        System.out.println(lonelyNumber.find(array));

    }

    public int find(int[] input) {

        // 0000 0000 0000 0000 0000 0000 0000 0101 5
        // 0000 0000 0000 0000 0000 0000 0000 0101 5
        // 0000 0000 0000 0000 0000 0000 0000 0101 5
        // 0000 0000 0000 0000 0000 0000 0000 0101 5
        // 0000 0000 0000 0000 0000 0000 0000 0101 5
        // 0000 0000 0000 0000 0000 0000 0000 0110 6

        // 0000 0000 0000 0000 0000 0000 0000 0615
        // 0000 0000 0000 0000 0000 0000 0000 0000

        int result = 0;
        int[] sums = new int[32];

        for(int i = 0; i < input.length; i++){
            int number = input[i];
            for(int j = 0; j < 32; j++){
                int mask = 1<<j;
                if((number&mask) != 0) sums[j]+=1;
            }
        }

        for(int i = 0; i < 32; i++){
            result <<= 1;
            result += sums[31-i]%5;
        }

        return result;
    }
}
