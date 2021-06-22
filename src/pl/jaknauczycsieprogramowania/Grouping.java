package pl.jaknauczycsieprogramowania;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class Grouping {
    public static void run() {
        List<Person> people = new ArrayList<>();

        people.add(new Person("Kamil", 33, 1.75));
        people.add(new Person("Mariusz", 21, 1.8));
        people.add(new Person("Dominik", 37, 1.63));

        Map<Integer, List<Person>> collect = people.stream()
                .collect(groupingBy(Person::getAge));
        System.out.println(collect);

        List<String> teams = new ArrayList<>();

        teams.add("Poland");
        teams.add("Slovakia");
        teams.add("Spain");
        teams.add("Sweden");
        teams.add("Sweden");

        Map<Integer, List<String>> collect1 = teams.stream()
                .collect(groupingBy(String::length));
        System.out.println(collect1);

        Map<Boolean, List<String>> partitioning = teams.stream()
                .collect(partitioningBy(team -> team.startsWith("S")));
        System.out.println(partitioning.get(true));

        Map<Boolean, List<Person>> collect2 = people.stream()
                .collect(partitioningBy(person -> person.getAge() > 25));
        System.out.println(collect2);
    }
}
