package edu.netcracker.lectures.examples.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriteInFileSample {
    public static void main(String[] args) {
        final String content = "Hello World!";

        try {
            Files.write(Paths.get("./outj7_sample.txt"), content.getBytes());
        } catch (IOException e) {
            //do something
        }
    }
}
