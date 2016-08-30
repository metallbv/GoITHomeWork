package Study.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by v.babiak on 25.08.2016.
 */
public class SmallExample {

    public static void main(String[] args) {

        Stream.of("dd2", "aa2", "bb1", "bb3", "cc4")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("anyMatch: " + s);
                    return s.startsWith("F");
                });

        List<Person> persons =
                Arrays.asList(
                        new Person("Andrew", 20),
                        new Person("Igor", 23),
                        new Person("Ira", 23),
                        new Person("Vitia", 12));



    }

}
