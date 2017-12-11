package javaexample;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class OlderThan20 {

    private static final List<Person> people = Arrays.asList(
            new Person("John", 20),
            new Person("Sara", 21),
            new Person("Jane", 21),
            new Person("Greg", 35)
    );

    public static void main(String[] args) {
        Map<Integer, List<String>> nameOfPeopleByAge =
                people.stream()
                        .collect(Collectors.groupingBy(
                                Person::getAge,
                                Collectors.mapping(Person::getName, Collectors.toList()))
                        );

        System.out.println("People grouped by age : " + nameOfPeopleByAge);

        //이름의 첫 글자를 기준으로 그룹핑하고 각 그룹별로 나이가 가장 많은 사람의 정보를 가지도록 해보자.
        Comparator<Person> byAge = Comparator.comparing(Person::getAge);

        Map<Character, Optional<Person>> oldestPersonOfEachLetter =
                people.stream()
                        .collect(Collectors.groupingBy(
                                person -> person.getName().charAt(0),
                                Collectors.reducing(BinaryOperator.maxBy(byAge)))
                        );

        System.out.println("People grouped by age : " + oldestPersonOfEachLetter);


    }

}
