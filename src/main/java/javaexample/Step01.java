package javaexample;


import java8.BufferedReaderProcessor;
import java8.LambdaTestProcessor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Step01 {

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple: inventory) {
            if(p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void process(Runnable r) {
        r.run();
    }

    public static void main(String[] args) throws IOException {
        List<Apple> inventory = Arrays.asList(new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        List<Apple> heavyApples = filterApples(inventory, new AppleHeavyWeightPredicate());
        List<Apple> greenApples = filterApples(inventory, new AppleGreenColorPredicate());

        List<Apple> anonymousClassTest = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "red".equals(apple.getColor());
            }
        });

        List<Apple> result = filterApples(inventory, (Apple apple) -> "red".equals(apple.getColor()));

        Thread t = new Thread(() -> System.out.println("Hello world"));
        t.run();

        Runnable r1 = () -> System.out.println("Hello World 1");

        Runnable r2 = new Runnable() {
            public void run() {
                System.out.println("hello world 2");
            }
        };

        process(r1);
        process(r2);
        process(() -> System.out.println("hello world 3"));

        //String result = processFile((BufferedReader br) -> br.readLine() + br.readLine());

        String oneLine = processFile((BufferedReader br) -> br.readLine());
        System.out.println(oneLine);
        String twoLine = processFile((BufferedReader br) -> {
            String tmp = "";
            tmp += br.readLine() + "|||";
            tmp += br.readLine() + "|+|+|";
            return tmp;
        });
        System.out.println(twoLine);

        String xxx = processLambda((String jj) -> {
            jj+= "1";
            jj+= "2";
            return jj;
        });
        System.out.println(xxx);

        List<String> listOfStrings = new ArrayList<>();
        listOfStrings.add("aaaa");
        listOfStrings.add("");
        listOfStrings.add("");
        listOfStrings.add("");
        listOfStrings.add("bbbb");
        listOfStrings.add("cccc");
        listOfStrings.add("");

        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty() && s.length() > 3;
        List<String> nonEmpty = filter(listOfStrings, nonEmptyStringPredicate);
        for(String one : nonEmpty) {
            System.out.println(one);
        }

        forEachTest(Arrays.asList(1,2,3,4,5,6,7,8,9,0), (Integer i) -> System.out.println(String.valueOf(i) + "------"));

    }

    public static <T, R> List<R> mapTest(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for(T s : list) {
            result.add(f.apply(s));
        }
        return result;
    }

    public static <T> void forEachTest(List<T> list, Consumer<T> c) {
        for(T i: list) {
            c.accept(i);
        }
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

    public static String processLambda(LambdaTestProcessor p) throws IOException {

        String preProcessResult = "a1212";

            return p.process(preProcessResult);

    }

//    public static String processFile() throws IOException {
//        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
//            return br.readLine();
//        }
//    }

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("src/data.txt"))) {
            return p.process(br);
        }
    }

}
