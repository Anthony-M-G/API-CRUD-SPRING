package com.cr.school.academic.services;

import com.cr.school.academic.dto.StudentDTO;
import org.springframework.http.ResponseEntity;

public interface StudentServices {
    ResponseEntity<Object> getAllStudents(Integer page, Integer size, String name, String orientation, String orderBy);

    ResponseEntity<String> createStudent(StudentDTO studentDTO);

    ResponseEntity<String> updateStudent(StudentDTO studentDTO, Long id);

    ResponseEntity<String> deleteStudentById(Long id);

    ResponseEntity<Object> findStudentById(Long id);


}
