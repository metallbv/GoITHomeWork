package UML.Cipher;

import java.util.HashMap;

/**
 * Created by v.babiak on 02.06.2016.
 */
public class CaesarCipher {

    private HashMap<Integer, Character> upperCaseLetterMap = new HashMap<Integer, Character>();

    {
        for (int i = 0; i < 26; i++) {
            upperCaseLetterMap.put(i, (char) ('A' + i));
        }
    }

    private HashMap<Integer, Character> lowerCaseLetterMap = new HashMap<Integer, Character>();

    {
        for (int i = 0; i < 26; i++) {
            lowerCaseLetterMap.put(i, (char) ('a' + i));
        }
    }

    private HashMap<Integer, Integer> numberMap = new HashMap<Integer, Integer>();

    {
        for (int i = 0; i < 10; i++) {
            numberMap.put((Integer) ('0' + i), i);
        }
    }

    public String encryption(String inputString, int shift) {

        StringBuilder outputString = new StringBuilder();

        for (int i = 0; i < inputString.length(); i++) {
            int indexNewSymbol = 0;
            char currentSymbol = inputString.charAt(i);
            if (upperCaseLetterMap.containsValue(currentSymbol)) {
                indexNewSymbol = currentSymbol - 'A' + shift;
                if (indexNewSymbol > 25) {
                    indexNewSymbol -= 26;
                }
                outputString.append(upperCaseLetterMap.get(indexNewSymbol));

            } else if (lowerCaseLetterMap.containsKey(currentSymbol)) {

                indexNewSymbol = currentSymbol - 'a' + shift;
                if (indexNewSymbol > 25) {
                    indexNewSymbol -= 26;
                }
                outputString.append(upperCaseLetterMap.get(indexNewSymbol));

            } else if (numberMap.containsKey(currentSymbol)) {

                indexNewSymbol = currentSymbol - '0' + shift;
                if (indexNewSymbol > 9) {
                    indexNewSymbol -= 10;
                }
                outputString.append(upperCaseLetterMap.get(indexNewSymbol));

            } else {

                outputString.append(currentSymbol);

            }


        }
        return outputString.toString();
    }

    public String decryption(String inputString, int shift) {

        StringBuilder outputString = new StringBuilder();

        for (int i = 0; i < inputString.length(); i++) {
            int indexNewSymbol = 0;
            char currentSymbol = inputString.charAt(i);
            if (upperCaseLetterMap.containsValue(currentSymbol)) {
                indexNewSymbol = currentSymbol - 'A' - shift;
                if (indexNewSymbol < 0) {
                    indexNewSymbol += 26;
                }
                outputString.append(upperCaseLetterMap.get(indexNewSymbol));

            } else if (lowerCaseLetterMap.containsKey(currentSymbol)) {

                indexNewSymbol = currentSymbol - 'a' - shift;
                if (indexNewSymbol < 0) {
                    indexNewSymbol += 26;
                }
                outputString.append(upperCaseLetterMap.get(indexNewSymbol));

            } else if (numberMap.containsKey(currentSymbol)) {

                indexNewSymbol = currentSymbol - '0' - shift;
                if (indexNewSymbol < 0) {
                    indexNewSymbol += 10;
                }
                outputString.append(upperCaseLetterMap.get(indexNewSymbol));

            } else {

                outputString.append(currentSymbol);

            }


        }
        return outputString.toString();
    }

}
