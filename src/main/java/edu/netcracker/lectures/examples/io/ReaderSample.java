package edu.netcracker.lectures.examples.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderSample {
    public static void main(String[] args) {

        final String fileName = "reader.txt";

        try {
            final FileReader fileReader =
                    new FileReader(fileName);
            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException ex) {
            //do something when file not found
        } catch (IOException ex) {
            //do something
        }
    }
}
