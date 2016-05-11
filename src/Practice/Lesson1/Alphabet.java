package Practice.Lesson1;

/*
Алфавіт

Дано рядок. Перевірити чи містить він всі букви англійського алфавіту a-zA-Z.
 */

import java.util.HashSet;
import java.util.Set;

public class Alphabet {

    public static void main(String[] args) {

        Alphabet alphabet = new Alphabet();
        System.out.println(alphabet.check("abcABC"));
        System.out.println(alphabet.check("qwertyuioplkjhgfdsazxcvbnmQWERTYUIOPLKJHGFDSAZXCVBNM"));

    }

    public boolean check(String input) {

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            set.add(input.charAt(i));
        }

        for (int i = 0; i < 26; i++) {
            if (!set.contains((char) ('a' + i)) && !set.contains((char) ('A' + i)))
                return false;
        }

        return true;
    }

}
