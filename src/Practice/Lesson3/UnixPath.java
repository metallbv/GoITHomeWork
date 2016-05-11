package Practice.Lesson3;

/*
Unix Шлях

Дано повний шлях до файла в Unix системі.
Наприклад /home/../var/./lib//file.txt
Необхідно повернути спрощений варіант. (/var/lib/file.txt)
 */

import java.util.LinkedList;

public class UnixPath {

    public static void main(String[] args) {

        UnixPath unixPath = new UnixPath();
        System.out.println(unixPath.simplify("/home/../var/./lib//file.txt")); // /. // /home/../var/./lib//file.txt

    }

    public String simplify(String input) {

        LinkedList<String> path = new LinkedList<>();
        StringBuilder wordBuffer = new StringBuilder();
        String word = wordBuffer.toString();

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (symbol == '/') {
                word = wordBuffer.toString();
                if ("..".equals(word) && !path.isEmpty()) {
                    path.pop();
                } else if (wordBuffer.toString().length() > 0 && !".".equals(word) && !"..".equals(word)) {
                    path.push(wordBuffer.toString());
                }
                wordBuffer = new StringBuilder();
            } else {
                wordBuffer.append(symbol);
            }
        }

        word = wordBuffer.toString();
        if (wordBuffer.toString().length() > 0 && !".".equals(word) && !"..".equals(word)) {
            path.push(wordBuffer.toString());
        }

        StringBuilder result = new StringBuilder();
        result.append("/");
        while (!path.isEmpty()) {
            result.append(path.removeLast());
            if (!path.isEmpty()) {
                result.append("/");
            }
        }

        return result.toString();
    }

}
