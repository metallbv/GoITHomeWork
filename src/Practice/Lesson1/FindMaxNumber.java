package Practice.Lesson1;

/*
Максимальне Число

Знайти максимальне число в масиві.
Гарантується, що масив завжди не пустий.
 */

public class FindMaxNumber {

    public int max(int[] input) {

        int max = input[0];

        for(int i = 1; i < input.length; i++){

            if(max < input[i]) max=input[i];
        }
        return max;
    }
}
