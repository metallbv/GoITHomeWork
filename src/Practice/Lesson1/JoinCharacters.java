package Practice.Lesson1;

/*
Злиття Цифр

З'єднати масив символів в число.
Приклад:
Для [ '1', '2', '3'] повернути 123
 */

public class JoinCharacters {

    public static void main(String[] args) {

        JoinCharacters joinCharacters = new JoinCharacters();
        char[] chars = {'1','2','3','4','5','6','7','8','9','0'};
        System.out.println(joinCharacters.join(chars));
    }

    public int join(char[] input) {
        // '1' is 49
        int result = 0;
        for(int i = 0; i < input.length; i++){
            result = result * 10 + (input[i]-48);
        }

        return result;
    }
}
