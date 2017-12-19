package javaexample;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

public class AppleExamV2 {

//    public class AppleComparator implements Comparator<Apple> {
//        public int compare(Apple a1, Apple a2) {
//            return a1.getWeight().compareTo(a2.getWeight());
//        }
//    }

    public static void main(String[] args) {

        List<Apple> inventory = new ArrayList<>();
        for(int i=0; i < 200; i++)
        {
            inventory.add(new Apple(200 - i));
        }

    }

}


