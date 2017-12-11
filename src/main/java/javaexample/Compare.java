package javaexample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


//참조 : http://tomining.tistory.com/52
public class Compare {
    private static final List<Person> people = Arrays.asList(
            new Person("John", 20),
            new Person("Sara", 21),
            new Person("Jane", 21),
            new Person("Greg", 35)
    );

    private static final Comparator<Person> ascending = (person1, person2) -> person1.ageDifference(person2);
    private static final Comparator<Person> descending = ascending.reversed();


    public static void main(String[] args) {
//        List<Person> ascendingAge = people.stream()
//                //.sorted((person1, person2) -> person1.ageDifference(person2))//asc
//                .sorted((person1, person2) -> person2.ageDifference(person1))//desc
//                .collect(Collectors.toList());
//        printPeople("Sorted in ascending order by age : ", ascendingAge);

        printPeople("Sorted in ascending order by age : ",
                people.stream()
                        .sorted(ascending)
                        .collect(Collectors.toList()));
        printPeople("Sorted in descending order by age : ",
                people.stream()
                        .sorted(descending)
                        .collect(Collectors.toList()));

        people.stream()
                .min(Person::ageDifference)
                .ifPresent(youngest -> System.out.println(youngest));//younggest

        people.stream()
                .max(Person::ageDifference)
                .ifPresent(eldest -> System.out.println(eldest));//eldest

        System.out.println("----------------------");
        people.stream()
                .sorted((person1, person2) ->
                        person1.getName().compareTo(person2.getName()))
                .forEach(System.out::println);


        final Function<Person, String> byName = person -> person.getName();
        final Function<Person, Integer> byAge = person -> person.getAge();

        printPeople("이름순으로 정렬", people.stream()
                .sorted(Comparator.comparing(byName))
                .collect(Collectors.toList()));
        printPeople("나이순으로 정렬", people.stream()
                .sorted(Comparator.comparing(byAge))
                .collect(Collectors.toList()));

        System.out.println("----------------------");

//        List<Person> olderThan20 = new ArrayList<Person>();
//        people.stream()
//                .filter(person -> person.getAge() > 20)
//                .forEach(person -> olderThan20.add(person));

//        List<Person> olderThan20 =
//                people.stream()
//                        .filter(person -> person.getAge() > 20)
//                        .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
//
//        System.out.println("People older than 20 : " + olderThan20);

        List<Person> olderThan20 =
                people.stream()
                        .filter(person -> person.getAge() > 20)
                        .collect(Collectors.toList());

        System.out.println("People older than 20 : " + olderThan20);


    }

    private static void printPeople(String message, List<Person> people) {
        System.out.println(message);
        people.forEach(System.out::println);
    }



}
