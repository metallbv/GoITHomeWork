package Practice.Lesson2;

/*
Перший Унікальний Символ

Знайти і повернути перший унікальний символ в рядку.
Якщо всі символи повторюються, повернути null
 */

import java.util.HashSet;
import java.util.Set;

public class FirstUniqueCharacter {

    public static void main(String[] args) {

        FirstUniqueCharacter firstUniqueCharacter = new FirstUniqueCharacter();
        System.out.println(firstUniqueCharacter.find("asdfghjkldfghjl"));

    }

    public Character find(String s) {

        Character result = null;
        int index = 0;
        Set<Character> set = new HashSet<>();

        for(int i = 0; i < s.length(); i++){
            index = 0;
            for(int j = 0; j < s.length(); j++){
            if(s.charAt(i) == s.charAt(j)){
            index++;
            }
                if(index > 1) break;
            }

            if(index == 1){
                result = s.charAt(i);
                break;
            }
        }

        return result;
    }
}
