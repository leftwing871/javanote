package javaexample;

public class IteraeString {
    public static void main(String[] args) {
        final String str = "w00t";

        str.chars().forEach(System.out::println);

        System.out.println("----------------------");

        str.chars()
                .mapToObj(ch111 -> Character.valueOf((char)ch111))
                .forEach(System.out::println);
        System.out.println("----------------------");
        str.chars()
                .filter(Character::isDigit)
                .mapToObj(ch -> Character.valueOf((char)ch))
                .forEach(System.out::println);
        System.out.println("----------------------");

    }

}
