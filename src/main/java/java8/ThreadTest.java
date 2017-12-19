package java8;

import java.util.Arrays;
import java.util.List;

public class ThreadTest {
    public static void main(String[] args) {

        Thread t = new Thread(new Runnable() {
            public void run() {
                System.out.println("Hello world");
            }
        });

        t.run();

        Thread t2 = new Thread(() -> {
            System.out.println("Thread01!");
            System.out.println("Thread02!");
            System.out.println("Thread03!");
        });
        t2.run();

    }
}
