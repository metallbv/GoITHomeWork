package Practice.Lesson2;

/*
Додавання за основою 36

Дано 2 числа в системі числення з основою 36. Будь-яка цифра може бути в межах [0-9a-z].
Повернути суму чисел, також в системі 36.
Наприклад:
"9" + "1" = "a"
"z" + "1" = "10"
 */

import java.util.HashMap;
import java.util.Map;

public class AddNumberBase36 {

    public static void main(String[] args) {

        AddNumberBase36 addNumberBase36 = new AddNumberBase36();
        System.out.println(addNumberBase36.add("9", "1"));

    }

    public String add(String a, String b) {

        Map<Character, Integer> alphabet = new HashMap<>();
        StringBuilder result = new StringBuilder();
        int aLength = a.length();
        int bLength = b.length();
        int ostacha = 0;

        for(int i = 0; i < 10; i++){
            alphabet.put((char)('0' + i), i);
        }

        for(int i = 0; i < 26; i++){
            alphabet.put((char) ('a' + i), i+10);
            alphabet.put((char) ('A' + i), i+10);
        }


        for(int i = 0; i < aLength || i < bLength; i++){

            char charA = i < aLength ? a.charAt(aLength - i - 1) : '0';
            char charB = i < bLength ? b.charAt(bLength - i - 1) : '0';
            int sum = alphabet.get(charA) + alphabet.get(charB) + ostacha;

            if(sum < 36){
                result.append(fromInt(sum));
                ostacha = 0;
            } else {
                result.append(fromInt(sum % 36));
                ostacha = 1;
            }

        }

        if(ostacha > 0){
            result.append(fromInt(1));
        }

        result.reverse();

        return result.toString();
    }

    public char fromInt(int number){

        char result;
        if(number < 10) result = (char) ('0'+number);
        else result = (char) ('a' + number - 10);

        return result;
    }
}
