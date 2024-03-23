package com.cr.school.academic.services;

import com.cr.school.academic.dto.StudentDTO;
import com.cr.school.academic.entities.Student;
import org.springframework.http.ResponseEntity;

public interface StudentServices {
    ResponseEntity<Object> getAll(Integer page, Integer size, String name);

    ResponseEntity<String> save(StudentDTO studentDTO);
    ResponseEntity<String> findByDni(Long dni);

    ResponseEntity<String> updateStudent(StudentDTO studentDTO, Long id);

    ResponseEntity<String> deleteById(Long id);

    ResponseEntity<Object> findById(Long id);


}
