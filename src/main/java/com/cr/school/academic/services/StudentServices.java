package com.cr.school.academic.services;

import com.cr.school.academic.entities.Student;
import org.springframework.http.ResponseEntity;

public interface StudentServices {
    ResponseEntity<Object> getAll(Integer page, Integer size, String name);

    void save(Student student);
    ResponseEntity<String> findByDni(Long dni);

    Student updateStudent(Student student);

    ResponseEntity<String> deleteById(Long id);


}
