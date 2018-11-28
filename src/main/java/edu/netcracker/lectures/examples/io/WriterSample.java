package edu.netcracker.lectures.examples.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterSample {
    public static void main(String[] args) {

        final String fileName = "writer_sample.txt";

        try {
            final FileWriter fileWriter =
                    new FileWriter(fileName);

            try (BufferedWriter bufferedWriter =
                         new BufferedWriter(fileWriter)) {
                bufferedWriter.write("Hello World!");
                bufferedWriter.write(" I's my text");
                bufferedWriter.newLine();
                bufferedWriter.write("New line,");
                bufferedWriter.write(" end.");
            }
        } catch (IOException ex) {
            //do something
        }
    }
}
