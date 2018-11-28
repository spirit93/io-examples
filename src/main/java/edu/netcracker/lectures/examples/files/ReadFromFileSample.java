package edu.netcracker.lectures.examples.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadFromFileSample {

    public static void main(String args[]) {
        final String fileName = "reader.txt";

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(System.out::println);
        } catch (IOException e) {
            //do something
        }
    }
}
