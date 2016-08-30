package Study.Stream;

// http://prologistic.com.ua/polnoe-rukovodstvo-po-java-8-stream.html

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ExampleStream {

    public static void main(String[] args) {

        List<String> mList = Arrays.asList("aa1", "cc2", "cc1", "aa2", "bb1");

        mList
                .stream()
                .filter(s -> s.startsWith("a"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
        //Результат выполнения:
        // AA1
        // AA2

        Arrays.asList("сс1", "сс2", "сс3")
                .stream()
                .findFirst()
                .ifPresent(System.out::println);
        //Результат выполнения: сс1

        Stream.of("сс1", "сс2", "сс3")
                .findFirst()
                .ifPresent(System.out::println);
        //Результатом будет сс1

        IntStream.range(8, 12)
                .forEach(System.out::println);
        //Результат выполнения:
        // 8
        // 9
        // 10
        // 11

        /*
        Примитивные потоки используют специализированные лямбда-выражения,
        например IntFunction Function или IntPredicate вместо Predicate .
        И примитивные потоки поддерживают дополнительные терминальные операции sum() и average():
         */

        Arrays.stream(new int[]{1, 2, 3})
                .map(n -> 2 * n + 1)
                .average()
                .ifPresent(System.out::println);
        //Результатом выполнения будет 5.0

        /*
        Иногда это полезно преобразовать поток объекта к примитивному потоку или наоборот.
        Для этой цели потоки объектов поддерживают специальные операций картирования
        mapToInt(), mapToLong() и mapToDouble()
         */

        Stream.of("c1", "c2", "c3")
                .map(s -> s.substring(1))
                .mapToInt(Integer::parseInt)
                .max()
                .ifPresent(System.out::println);
        //Результатом выполнения будет 3

        /*
        Примитивные потоки могут быть преобразованы в объектные потоки с помощью метода mapToObj()
         */

        IntStream.range(1, 4)
                .mapToObj(i -> "с" + i)
                .forEach(System.out::println);
        // Результат выполнения операции:
        // с1
        // с2
        // с3

        Stream.of(1.0, 2.0, 3.0)
                .mapToInt(Double::intValue)
                .mapToObj(i -> "с" + i)
                .forEach(System.out::println);
        // Результат выполнения операции:
        // с1
        // с2
        // с3

        /*
        промежуточные операции будут выполнены только тогда, когда присутствуют терминальные операции
         */
        Stream.of("dd2", "aa2", "bb1", "bb3", "cc4")
                .filter(s -> {
                    System.out.println("Фильтр: " + s);
                    return true;
                })
                .forEach(s -> System.out.println("Печать с использованием forEach: " + s));

        Stream.of("dd2", "aa2", "bb1", "bb3", "cc4")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("anyMatch: " + s);
                    return s.startsWith("A");
                });
        // Результат выполнения представлен ниже
        // map:      dd2
        // anyMatch: DD2
        // map:      aa2
        // anyMatch: AA2

        Stream.of("dd2", "aa2", "bb1", "bb3", "cc4")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("A");
                })
                .forEach(s -> System.out.println("forEach: " + s));
        // Результат выполнения
        // map:     dd2
        // filter:  DD2
        // map:     aa2
        // filter:  AA2
        // forEach: AA2
        // map:     bb1
        // filter:  BB1
        // map:     bb3
        // filter:  BB3
        // map:     cc
        // filter:  CC

        Stream.of("dd2", "aa2", "bb1", "bb3", "cc4")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));

        // filter:  dd2
        // filter:  aa2
        // map:     aa2
        // forEach: AA2
        // filter:  bb1
        // filter:  bb3
        // filter:  cc

        Stream.of("dd2", "aa2", "bb1", "bb3", "cc4")
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));

        //Сортировка является особым видом промежуточных операций. Это так называемые операции состояния.

        /*
        Потоки в Java 8 не могут быть использованы повторно.
        Как только вы называете какую-нибудь терминальную операция, поток закрывается
         */

        // Повторное использование Потоков (Streams)

        Stream<String> stream =
                Stream.of("dd2", "aa2", "bb1", "bb3", "cc")
                        .filter(s -> s.startsWith("a"));

        stream.anyMatch(s -> true);    // операция выполнится успешно
        stream.noneMatch(s -> true);   // Вылетит Exception

        Supplier<Stream<String>> streamSupplier =
                () -> Stream.of("dd2", "aa2", "bb1", "bb3", "cc")
                        .filter(s -> s.startsWith("a"));

        streamSupplier.get().anyMatch(s -> true);   // операция пройдет успешно
        streamSupplier.get().noneMatch(s -> true);  // здесь также все будет ok

        List<Person> persons =
                Arrays.asList(
                        new Person("Andrew", 20),
                        new Person("Igor", 23),
                        new Person("Ira", 23),
                        new Person("Vitia", 12));

        /*
        Collect является чрезвычайно полезной операцией,
        чтобы превратить элементы потока в List, Set или Map.
        Collect принимает Collector, который состоит из четырех различных операций:
        поставщик, аккумулятор, объединитель и финишер.
         */

        List<Person> filtered =
                persons
                        .stream()
                        .filter(p -> p.getName().startsWith("I"))
                        .collect(Collectors.toList());

        System.out.println(filtered);    // [Igor, Ira]

        Map<Integer, List<Person>> personsByAge = persons
                .stream()
                .collect(Collectors.groupingBy(p -> p.getAge()));

        personsByAge
                .forEach((age, p) -> System.out.format("age %s: %s\n", age, p));

        // age 20: [Andrew]
        // age 23: [Igor, Ira]
        // age 12: [Vitia]

        Double averageAge = persons
                .stream()
                .collect(Collectors.averagingInt(p -> p.getAge()));

        System.out.println(averageAge); // 19.5

        IntSummaryStatistics ageSummary =
                persons
                        .stream()
                        .collect(Collectors.summarizingInt(p -> p.getAge()));

        System.out.println(ageSummary);
        // Результат выполнения:
        // IntSummaryStatistics{count=4, sum=78, min=12, average=19.500000, max=23}

        String phrase = persons
                .stream()
                .filter(p -> p.getAge() >= 18)
                .map(p -> p.getName())
                .collect(Collectors.joining(" и ", "В Германии ", " совершеннолетние."));

        System.out.println(phrase);
        // В Германии Andrew и Igor и Ira совершеннолетние.

        Map<Integer, String> map = persons
                .stream()
                .collect(Collectors.toMap(
                        p -> p.getAge(),
                        p -> p.getName(),
                        (name1, name2) -> name1 + ";" + name2));

        System.out.println(map);
        // {20=Andrew, 23=Igor;Ira, 12=Vitya}

        /*
        Теперь, когда мы знаем, некоторые мощные встроенные коллекторы,
        давайте попробуем построить свой собственный специальный коллектор.
        Мы хотим превратить всех людей в потоке в одну строку,
        состоящую из всех имен в верхнем регистре, разделенных знаком "|".
        Для достижения этого мы создаем новый коллектор через Collector.of().
        Мы должны пройти четыре этапа использования collectors: supplier, accumulator, combiner и finisher.
         */

        Collector<Person, StringJoiner, String> personNameCollector =
                Collector.of(
                        () -> new StringJoiner(" | "),          // supplier
                        (j, p) -> j.add(p.getName().toUpperCase()),  // accumulator
                        (j1, j2) -> j1.merge(j2),               // combiner
                        StringJoiner::toString);                // finisher

        String names = persons
                .stream()
                .collect(personNameCollector);

        System.out.println(names);  // ANDREW | IGOR | IRA | VITIA

        /*
        FlatMap преобразует каждый элемент потока в поток других объектов.
        Таким образом, каждый объект будет преобразован в ноль, один или несколько других объектов,
        поддерживаемых потоком. Содержание этих потоков будет затем помещают в возвращаемом
        потоке flatMap операции.
         */

        List<Foo> foos = new ArrayList<>();

        // create foos
        IntStream
                .range(1, 4)
                .forEach(i -> foos.add(new Foo("Foo" + i)));

        // create bars
        foos.forEach(f ->
                IntStream
                        .range(1, 4)
                        .forEach(i -> f.bars.add(new Bar("Bar" + i + " <- " + f.name))));



        foos.stream()
                .flatMap(f -> f.bars.stream())
                .forEach(b -> System.out.println(b.name));

        // Bar1 <- Foo1
        // Bar2 <- Foo1
        // Bar3 <- Foo1
        // Bar1 <- Foo2
        // Bar2 <- Foo2
        // Bar3 <- Foo2
        // Bar1 <- Foo3
        // Bar2 <- Foo3
        // Bar3 <- Foo3


        IntStream.range(1, 4)
                .mapToObj(i -> new Foo("Foo" + i))
                .peek(f -> IntStream.range(1, 4)
                        .mapToObj(i -> new Bar("Bar" + i + " <- " + f.name))
                        .forEach(f.bars::add))
                .flatMap(f -> f.bars.stream())
                .forEach(b -> System.out.println(b.name));

    }

}
