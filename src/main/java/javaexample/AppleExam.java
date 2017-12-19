package javaexample;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

public class AppleExam {

    public static List<Apple> mapTest(List<Integer> list, Function<Integer, Apple> f) {
        List<Apple> result = new ArrayList<>();
        for(Integer e : list) {
            result.add(f.apply(e));
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> weights = Arrays.asList(7, 3, 4, 10);
        List<Apple> apples = mapTest(weights, Apple::new);

        List<Apple> inventory = new ArrayList<>();
        for(int i=0; i < 200; i++)
        {
            inventory.add(new Apple(200 - i));
        }
//        System.out.println("------------------");
//
//        List<Apple> heavyApples = inventory.stream().filter((Apple a) -> a.getWeight() > 150)
//                .collect(toList());
//        for(Apple a : heavyApples) {
//            System.out.println(a);
//        }

        System.out.println("------------------");
        List<Apple> heavyApples2 = inventory.parallelStream().filter((Apple a) -> a.getWeight() > 150)
                .collect(toList());
        for(Apple a : heavyApples2) {
            System.out.println(a);
        }
        System.out.println("------------------");

        heavyApples2.sort(Comparator.comparing(Apple::getWeight));
        for(Apple a : heavyApples2) {
            System.out.println(a);
        }
    }

}


