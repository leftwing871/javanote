package javaexample;
import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class AppleExam {
    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        for(int i=0; i < 1000; i++)
        {
            inventory.add(new Apple(i));
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
    }

}


