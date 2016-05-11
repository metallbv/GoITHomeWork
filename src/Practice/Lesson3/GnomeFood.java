package Practice.Lesson3;

/*
Їжа для гномів

В країні гномів прийнято, що більша порція їжі дістається вищому гному.
Дано два мисиви int[] довжиною N, з висотами гномів в першому і кілограмами їжі в другому.
Для кожного i-го гнома треба знайти j-ту порцію їжі і записати в результат j-індекси.
Приклад:
[5, 7, 6, 9, 4] - гноми
[8, 5, 6, 2, 3] - порції
Найвищому гному з висотою 9 дістається найбільша порція 8 з індексом 0.
Другий за висотою гном (7), отримує другу завбільшки порцію (6) з індексом 2, і т.д.
Найнищий (4) отримує найменшу порцію 2 (індекс 3)
Резульнат
[4, 2, 1, 0, 3]
 */

import java.util.Iterator;
import java.util.TreeMap;

public class GnomeFood {

    public static void main(String[] args) {

        int[] gnomes = {5, 7, 6, 9, 4};
        int[] portions = {8, 5, 6, 2, 3};
        GnomeFood gnomeFood = new GnomeFood();
        gnomeFood.find(gnomes, portions);
    }

    public int[] find(int[] gnames, int[] portions) {

        int[] result = new int[gnames.length];
        TreeMap<Integer, Integer> gnamesMap = new TreeMap<>();
        TreeMap<Integer, Integer> portionsMap = new TreeMap<>();

        for (int i = 0; i < gnames.length; i++) {
            gnamesMap.put(gnames[i], i);
            portionsMap.put(portions[i], i);
        }

        Iterator iterGnomes = gnamesMap.values().iterator();
        Iterator iterPortions = portionsMap.values().iterator();

        while (iterGnomes.hasNext()) {
            int i = (Integer) iterGnomes.next();
            int j = (Integer) iterPortions.next();
            result[i] = j;
        }

        for (int i: result) {
            System.out.println(i);
        }

        return result;
    }
}
