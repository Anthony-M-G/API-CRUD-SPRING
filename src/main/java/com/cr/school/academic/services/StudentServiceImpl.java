package com.cr.school.academic.services;

import com.cr.school.academic.entities.Student;
import com.cr.school.academic.repositories.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StudentServiceImpl implements StudentServices{
    private final StudentRepository studentRepository;


    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;

    }


    @Override
    public ResponseEntity<Object> getAll(Integer page, Integer size, String name) {
        Pageable pageable= PageRequest.of(page, size);
        if(name.isEmpty()) return new ResponseEntity<>(studentRepository.findAll(pageable),HttpStatus.OK); // Si el campo name viene vacío todo bien
        else if (studentRepository.findByName(name,pageable).isEmpty())  return new ResponseEntity<>( // Si el nombre que busco no está --> BAD_REQUEST
                studentRepository.findAll(pageable),
                HttpStatus.BAD_REQUEST);
        else return new ResponseEntity<>( studentRepository.findByName(name, pageable),HttpStatus.OK); // Si el nombre que busco sí está --> HttpStatus.OK
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public ResponseEntity<String> findByDni(Long dni) {
        if(studentRepository.findByDni(dni).isEmpty()) return new ResponseEntity<>("El estudiante con el dni: "+dni+" no existe",HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(studentRepository.findByDni(dni).get().toString(),HttpStatus.OK);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }
    @Override
    public ResponseEntity<String> deleteById(Long id) {
        if(studentRepository.findById(id).isEmpty()) return new ResponseEntity<>("El estudiante con el id:"+id+" no existe", HttpStatus.BAD_REQUEST);
        studentRepository.deleteById(id);
        return new ResponseEntity<>("Estudiante eliminado con éxito",HttpStatus.OK);
    }


}
