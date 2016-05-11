package Practice.Lesson4;

/*
Ланцюжок

Дано ланки трьох кольорів: білого і 1 м завдовжки, жовтого - 2 м і червоного - 3 м.
Скількома способами можна зібрати, з них, ланцюжок довжиною  N.
Кількість наявних ланок кожного кольору вважати бескінечною.
 */

import java.util.HashMap;

public class ColorChain {

    private HashMap<Integer, Integer> values = new HashMap<>();
    {
        values.put(0, 0);
        values.put(1, 1);
        values.put(2, 2);
        values.put(3, 4);
        values.put(-1, 0);
        values.put(-2, 0);
        values.put(-3, 0);
    }

    public static void main(String[] args) {

        ColorChain colorChain = new ColorChain();
        System.out.println(colorChain.count(35));

    }

    public int count(int N) {

        if (values.containsKey(N)) {
            return values.get(N);
        } else {
            int result = 0;
            result = count(N - 1) + count(N - 2) + count(N - 3);
            values.put(N, result);
            return result;
        }
    }

}
