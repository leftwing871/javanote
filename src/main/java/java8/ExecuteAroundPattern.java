package java8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteAroundPattern {
    public static void main(String[] args) throws IOException {

        String result = processFile((BufferedReader br) -> br.readLine() + br.readLine());
        String oneLine = processFile((BufferedReader br) -> br.readLine());
        System.out.println(oneLine);

        String twoLine = processFile((BufferedReader br) -> {
            String tmp = "";
            tmp += br.readLine() + "|||";
            tmp += br.readLine() + "|+|+|";
            return tmp;
        });

        System.out.println(twoLine);
        processFile();

    }


    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("src/data.txt"))) {
            return p.process(br);
        }
    }

    public static String processFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("src/data.txt"))) {
            return br.readLine();
        }
    }

}
