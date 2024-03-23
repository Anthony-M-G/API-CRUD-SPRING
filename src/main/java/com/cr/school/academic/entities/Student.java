package com.cr.school.academic.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
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
    private String lastName;
    @Column(name = "dni")
    private Long dni;
    @ManyToOne// quiere decir que muchos estudiantes pueden tener un estado
    @JoinColumn(name = "student_status") // Hace join con entre él, id y el value_id de types
    private Type studentStatus;
    @Column(name = "student_career")
    private Short studentCareer;

    public Student(String name, String lastname, Long dni, Type studentStatus, Short studentCareer) {
        this.name = name;
        this.lastName = lastname;
        this.dni = dni;
        this.studentStatus = studentStatus;
        this.studentCareer = studentCareer;
    }

    /*public static Type typeOf(Long number) {  //Este es otro método para instanciar el tipo type en el campo necesario para guardar una instancia de student
        if (number == 1)
            return new Type(number, "Cursando", "student_status");

        else if (number == 2)
            return new Type(number, " Titulado", "student_status");

        else {
            return new Type(number, "Baja", "student_status");
        }
    }*/

    @Override
    public String toString() {
        return"{\n" +
                "  \"id\": \"" + id + "\",\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"lastname\": \"" + lastName + "\",\n" +
                "  \"dni\": " + dni + ",\n" +
                "  \"studentStatus\": \"" + studentStatus + "\",\n" +
                "  \"studentCareer\": \"" + studentCareer + "\"\n" +
                "}";
    }
}
