package edu.netcracker.lectures.examples.serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class DeserializeSample {

    public static void main(String [] args) {
        try (InputStream fileIn = new FileInputStream("student.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            final Student student = (Student) in.readObject();
            System.out.println(student.toString());
        } catch (IOException i) {
            //do something
        } catch (ClassNotFoundException c) {
            //do something
        }
    }
}
