package edu.netcracker.lectures.examples.serialization;

import java.io.*;
import java.util.Date;

public class SerializeSample {
    public static void main(String[] args) {
        final Student studentSample = Student.builder()
                .birthDate(new Date())
                .firstName("Ivan")
                .lastName("Ivanov")
                .transientField("some value")
                .build();

        try (OutputStream fileOut =
                     new FileOutputStream("student.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut);
        ) {
            out.writeObject(studentSample);
        } catch (FileNotFoundException e) {
            //do something
        } catch (IOException i) {
            //do something
        }
    }
}
