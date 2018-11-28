package edu.netcracker.lectures.examples.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamSample {

    public static void main(String[] args) {
        final String fileName = "out_sample.txt";
        final String bytes = "Hello World!";
        byte[] buffer = bytes.getBytes();

        try (OutputStream outputStream =
                     new FileOutputStream(fileName)) {
            outputStream.write(buffer);

            System.out.println("Wrote " + buffer.length +
                    " bytes");
        } catch (IOException ex) {
            //do something
        }
    }
}
