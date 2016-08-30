package Study.Day2;

/*
Содержит примеры:
Подсчет элементов коллекции;
Сортировка коллекции методами sort()и reduce();
Фильтрация коллекции;
 */

import Study.Stream.Person;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamHomeWork {

    public static void main(String[] args) {

        List<Person> personsOne =
                Arrays.asList(
                        new Person("Andrew", 20),
                        new Person("Igor", 23),
                        new Person("Ira", 23),
                        new Person("Vitia", 12));

        List<Person> personsTwo =
                Arrays.asList(
                        new Person("Bogdan", 25),
                        new Person("Maksym", 29),
                        new Person("Yaroslav", 18));

        List<Person> combineList = combineTwoCollections(personsOne, personsTwo);

        System.out.println(countOfElement(combineList));
        System.out.println(findFirstByCriteriy(combineList));

    }

    /*
    Подсчитать число элементов в коллекции
     */
    public static long countOfElement(Collection myCollection) {
        return myCollection.stream().count();
    }

    /*
    Oтфильтровать лист по какому-то критерию (одно из полей объекта в листе)
    и получить первый элемент если он есть, если его нет, кинуть ошибку.
     */
    public static Person findFirstByCriteriy(List<Person> persons) {

        Person person = persons
                .stream()
                .filter(p -> p.getAge() >= 20)
                .sorted((s1, s2) -> {
                    return s1.compareTo(s2);
                })
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

        /*Person person = persons
                .stream()
                .filter(p -> p.getAge() >= 20)
                .reduce((p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2)
                .orElseThrow(IllegalArgumentException::new);*/

        return person;

    }

    /*
    Слить два листа в один
     */
    public static List<Person> combineTwoCollections(List<Person> collection1, List<Person> collection2) {
        List<Person> newList = Stream
                .concat(collection1.stream(), collection2.stream())
                .collect(Collectors.toList());
        return newList;
    }
}
