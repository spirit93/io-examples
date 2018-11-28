package edu.netcracker.lectures.examples.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamSample {
    public static void main(String[] args) {

        final String fileName = "reader.txt";
        byte[] buffer = new byte[1024];

        try (InputStream inputStream =
                     new FileInputStream(fileName)) {
            int total = 0;
            int nRead;
            while ((nRead = inputStream.read(buffer)) != -1) {
                System.out.println(new String(buffer));
                total += nRead;
            }
            System.out.println("Read " + total + " bytes");
        } catch (FileNotFoundException ex) {
            //do something
        } catch (IOException ex) {
            //do something
        }
    }
}
