package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class PredicateTest {

    public static void main(String[] args) {
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();

        List<String> listOfStrings = Arrays.asList("aaaa", "", "bbb", "ccc", "ddd", "eee", "fff");

        List<String> nonEmpty = filter(listOfStrings, nonEmptyStringPredicate);

        for(String one : nonEmpty)
            System.out.println(one);


        IntPredicate eventNumbers = (int i) -> i % 2 == 0;
        System.out.println(eventNumbers.test(1000));

        Predicate<Integer> oddNumbers = (Integer i) -> i % 2 == 1;
        System.out.println(oddNumbers.test(1000));
    }


    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for(T s: list) {
            if(p.test(s)) {
                results.add(s);
            }
        }
        return results;
    }
}
