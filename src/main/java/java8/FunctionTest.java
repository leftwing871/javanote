package java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class FunctionTest {
    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T s : list) {
            result.add(f.apply(s));
        }
        return result;
    }

    public static void main(String[] args)
    {
        /*
        List<Integer> l = map(
                Arrays.asList("lambdas", "in", "action"),
                (String s) -> s.length()
                );

        for(Integer one : l) {
            System.out.println(one);
        }
        */

        /*
        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> transformationPipeline =
                addHeader.andThen(Letter::checkSpelling)
                .andThen(Letter::addFooter);

        System.out.println(addHeader.apply("a1212labda"));
        System.out.println(transformationPipeline.apply("a1212labda"));

        List<Dish> lowCaloricDishes = new ArrayList<>();
        List<Dish> menu = new ArrayList<>();
        for(Dish d: menu) {
            if(d.getCalories() < 400) {
                lowCaloricDishes.add(d);
            }
        }

        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish d1, Dish d2) {
                return Integer. compare(d1.getCalories(), d2.getCalories());
            }
        });

        List<String> lowCaloricDishesName = new ArrayList<>();
        for(Dish d: lowCaloricDishes) {
            lowCaloricDishesName.add(d.getName());
        }
        */

        List<Dish> menu = new ArrayList<>();
        menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );

        if(menu.stream().anyMatch(Dish::isVegetarian))
        {
            System.out.println("The menu is (somewhat) vegetarian friendly !!");

        }

        List<String> lowCaloricDishesName =
                menu.stream()
                .filter(d -> d.getCalories() < 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());

        List<String> lowCaloricDishesName2 =
                menu.parallelStream()
                        .filter(d -> d.getCalories() < 400)
                        .sorted(comparing(Dish::getCalories))
                        .map(Dish::getName)
                        .collect(toList());

        Map<Dish.Type, List<Dish>> dishedByType =
                menu.stream().collect(groupingBy(Dish::getType));

        List<String> threeHighCaloricDishNames =
                menu.stream()
                .filter(d -> d.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(toList());

        System.out.println(threeHighCaloricDishNames);

        System.out.println("````````````````````````````");

        List<String> names =
                menu.stream()
                .filter(d -> {
                    System.out.println("filtering : " + d.getName());
                    return d.getCalories() > 300;
                })
                .map(d -> {
                    System.out.println("mapping" + d.getName());
                    return d.getName();
                })
                .skip(2)
                .limit(3)
                .collect(toList());

        System.out.println(names);
        System.out.println("````````````````````````````");

        List<Dish> vegetarianDished =
                menu.stream()
                .filter(Dish::isVegetarian)
                .collect(toList());

        List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .map(i -> i * i)
                .forEach(System.out::println);

        System.out.println("```````````kk`````````````````");

        List<Integer> dishNameLengths = menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(toList());

        List<String> words = Arrays.asList("java8", "lambdas", "In", "Action", "Table1");


        List<String> a1212 = words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());
        System.out.println("````````````````````````````");
        System.out.println(a1212);


        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs =
                numbers1.stream()
                .flatMap(i -> numbers2.stream()
                .map(j -> new int[]{i, j}))
                .collect(toList());

        System.out.println("````````````pairs````````````````");
        for(int[] xx : pairs) {
            System.out.println("==");
            for(int x : xx) {
                System.out.print(x + ",");
            }
        }

        List<int[]> pairs2 =
                numbers1.stream()
                        .flatMap(i -> numbers2.stream()
                                .filter(j -> (i + j) % 3 == 0)
                                .map(j -> new int[]{i, j}))
                        .collect(toList());

        System.out.println("````````````pairs2````````````````");
        for(int[] xx : pairs2) {
            System.out.println("==");
            for(int x : xx) {
                System.out.print(x + ",");
            }
        }
/*
        List<int> xxx = Arrays.asList(1,2,3,4,5,6,7,8,9);
        int product = xxx.stream().reduce(0, (a, b) -> a + b);

        System.out.println("````````````" + product + "````````````````");
*/
        int xx = Arrays.asList(1,2,3).stream()
                .reduce((a,b)-> a+b)
                .get();

        System.out.println("````````````" + xx + "````````````````");

        Optional<Integer> yy = Arrays.asList(1,2,3).stream()
                .reduce((a,b)-> a+b);

        System.out.println("````````````" + yy + "````````````````");

        List<Integer> zzz = Arrays.asList(6,8);

        Optional<Integer> max = zzz.stream()
                .filter(j -> (j) % 3 == 0)
                .reduce(Integer::max);

        int maxValue = 0;
        if(max.isPresent())
        {
            maxValue = max.get();
        }

        System.out.println("'''" + maxValue + "'''");





    }
}
