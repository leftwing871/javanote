package javaexample;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda {
    public static void main(String[] args) {
        method1();
        List<String> list = Arrays.asList("Java", "Scala", "Groovy");
        //list.sort((String s1, String s2) -> s1.length() - s2.length());
        //람다식의 인수형이 자명한 경우는 다음과 같이 형을 생략할 수도 있다.
        list.sort((s1, s2) -> s1.length() - s2.length());
        //display(list);
        //인수가 1개인 경우는 인수 목록()을 생략할 수도 있다.
        list.forEach(s -> System.out.println(s + " | "));

        outer("AAAAAAA");

        //39: 자체적인 함수형 인터페이스를 정의하기
        TriFunction function = (a, b, c) -> a+b+c;

        System.out.println(function.apply(1,10,20));

        System.out.println("------------------");
        File[] hiddenFiles = new File(".").listFiles(File::isHidden);
        Arrays.asList(hiddenFiles).forEach(System.out::println);

        System.out.println("------------------");





//        DatabaseManager.execute((conn) -> {
//            //...데이터베이스 처리...
//        });
    }

//    public DatabaseManager {
//        public static void execute(Consumer<Connection> consumer) throws SQLException {
//            //연결을 함
//            try(Connection conn = getConnection()) {
//                //인수로 받은 함수형 인터페이스
//                consumer.accept(conn);
//
//                conn.commit();
//            } catch (Exception ex) {
//                //예외가 발생하면 롤백
//                conn.rollback();
//                throw ex;
//            }
//        }
//    }

    @FunctionalInterface
    public interface TriFunction {
        public int apply(int a, int b, int c);
    }

    static void outer(final String msg) {
        System.out.print("===================");
        Runnable r = () -> {
            //람다식 내에서 outer 메소드의 인수를 참조 가능
            System.out.println(msg);
        };

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //Java 8 에서는 outre 메소드의 인수를 final이 없어도 사용 가능
                System.out.println("Message: " + msg);
            }
        };
    }

    static void method1()
    {
        List<String> list = Arrays.asList("java", "scala", "groovy");

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }

        });

        display(list);
    }

    static void display(List<String> list) {
        for(String one : list) {
            System.out.println(one);
        }
    }
}
/*
함수의 처리를 1행으로 기술하는 경우
(인수의 리스트 -> 식

함수의 처리를 여러 줄로 기술하는 경우
(인수의 리스트) -> {
    함수 처리
    return 값1;
}
*/