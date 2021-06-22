package pl.jaknauczycsieprogramowania;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class CountingSummingAveraging {
    public static void run() {
        List<Person> people = new ArrayList<>();

        people.add(new Person("Kamil", 33, 1.75));
        people.add(new Person("Mariusz", 21, 1.8));
        people.add(new Person("Dominik", 37, 1.63));

        Long collect = people.stream()
                .collect(counting());
        System.out.println(collect);

        Double collect1 = people.stream()
                .collect(averagingInt(Person::getAge));
        System.out.println(collect1);

        Optional<Integer> collect2 = people.stream()
                .map(Person::getAge)
                .collect(minBy(Comparator.naturalOrder()));
        System.out.println(collect2.get());
    }
}
