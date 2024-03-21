package com.cr.school.academic.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter

@RequiredArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "students")

public class Student implements Serializable {

    @Serial
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "dni")
    private Long dni;
    @ManyToOne// quiere decir que muchos estudiantes pueden tener un estado
    @JoinColumn(name = "student_status") // Hace join con entre él, id y el value_id de types
    private Type studentStatus;
    @Column(name = "student_career")
    private Short studentCareer;

    @Override
    public String toString() {
        return"{\n" +
                "  \"id\": \"" + id + "\",\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"lastname\": \"" + lastname + "\",\n" +
                "  \"dni\": " + dni + ",\n" +
                "  \"studentStatus\": \"" + studentStatus + "\",\n" +
                "  \"studentCareer\": \"" + studentCareer + "\"\n" +
                "}";
    }
}
