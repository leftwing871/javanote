package com.leftwing871;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class useStream {

    public static void main(String[] args) {
        Stream<Student> studentStream = Stream.of(
                new Student("이자바", 3, 300),
                new Student("김자바", 1, 200),
                new Student("안자바", 2, 100),
                new Student("박자바", 2, 150),
                new Student("소자바", 1, 200),
                new Student("나자바", 3, 290),
                new Student("김자바", 3, 180)
        );

        List<Student> lstStudent = new ArrayList();

        //studentStream.sorted(Comparator.comparing(Student::getBan).thenComparing(Comparator.naturalOrder())).forEach(lstStudent::add);

        for(Student s : lstStudent) {
            System.out.println(s);
        }

        studentStream.sorted(Comparator.comparing(Student::getBan).reversed()
                //.thenComparing(Student::getTotalScore)
                .thenComparing(Comparator.comparing(Student::getTotalScore).reversed())).forEach(lstStudent::add);
    }
}
