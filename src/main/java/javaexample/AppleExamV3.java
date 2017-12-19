package javaexample;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AppleExamV3 {


    public static void main(String[] args) {

        List<Apple> inventory = new ArrayList<>();
        for(int i=0; i < 200; i++)
        {
            inventory.add(new Apple(200 - i));
        }

        List<Apple> inventoryXXX= filterApples(inventory, (a) -> a.getWeight() > 111);

        for(Apple a : inventoryXXX) {
            System.out.println(a.getWeight());
        }

        List<Apple> heavyApples = inventory.parallelStream()
                .filter((Apple a) -> a.getWeight() > 150)
                .collect(Collectors.toList());

    }

    static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p ) {
        List<Apple> result = new ArrayList<>();

        for(Apple apple: inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }
/*
    public interface Predicate<T> {
        boolean test(T t);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for(T e: list) {
            if(p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

    List<Apple> redApples = filter(inventory, (Apple apple) -> "red".equals(apple.getColor()));
*/
}


