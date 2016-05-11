package Practice.Lesson1;

/*
Перше Непарне Число

Знайти перше непарне число і повернути його індекс.
Якщо такого немає, повернути -1
 */

public class FirstOddNumber {

    public int find(int[] input) {
        int odd = -1;
        for(int i = 0; i < input.length; i++){
            if(input[i]%2 != 0){
                odd = i;
                break;
            }
        }
        return odd;
    }
}
