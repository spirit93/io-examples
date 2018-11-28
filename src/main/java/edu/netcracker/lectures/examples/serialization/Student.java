package edu.netcracker.lectures.examples.serialization;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@ToString
public class Student implements Serializable {
    private String firstName;
    private String lastName;
    private Date birthDate;
    private transient String transientField;
}
