package java8;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface LambdaTestProcessor {
    String process(String str) throws IOException;
}
