package com.cr.school.academic.services;

import com.cr.school.academic.dto.StudentDTO;
import com.cr.school.academic.entities.Student;
import com.cr.school.academic.repositories.StudentRepository;
import com.cr.school.academic.repositories.TypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class StudentServiceImpl implements StudentServices{
    private final StudentRepository studentRepository;
    private final TypeRepository typeRepository;


    public StudentServiceImpl(StudentRepository studentRepository,TypeRepository typeRepository) {
        this.studentRepository = studentRepository;
        this.typeRepository=typeRepository;

    }


    @Override
    public ResponseEntity<Object> getAll(Integer page, Integer size, String name) {
        Pageable pageable = PageRequest.of(page, size);
        if (name.isEmpty())
            return new ResponseEntity<>(studentRepository.findAll(pageable)
                    .stream()
                    .map(student -> new StudentDTO(student.getName()
                            , student.getLastName()
                            , student.getDni()
                            , student.getStudentStatus().getMeaning()
                            , student.getStudentCareer())), HttpStatus.OK); // Si el campo name viene vacío todo bien
        else if (studentRepository.findByName(name, pageable).isEmpty()){
            log.info("No se encontraron coincidencias con el nombre: "+name);
            return new ResponseEntity<>(studentRepository.findAll(pageable), HttpStatus.BAD_REQUEST);} // Si el nombre que busco no está --> BAD_REQUEST
        else
            return new ResponseEntity<>(studentRepository.findByName(name, pageable), HttpStatus.OK); // Si el nombre que busco sí está --> HttpStatus.OK
    }

    @Override
    public ResponseEntity<String> save(StudentDTO studentDTO) {
        if (studentRepository.existsByDni(studentDTO.getDni()))
            return new ResponseEntity<>("Estudiante ya existe", HttpStatus.BAD_REQUEST);
        else if (studentDTO.getDni() == null) {
            log.info("No se puede procesar ya que faltan parámetros de información");
            return new ResponseEntity<>("Faltan parámetros del estudiante", HttpStatus.BAD_REQUEST);
        }
        else {
            Student student = new Student(studentDTO.getName(),
                    studentDTO.getLastname(),
                    studentDTO.getDni(),
                    typeRepository.findByMeaning(studentDTO.getStudentStatus()),
                    studentDTO.getStudentCareer());
            studentRepository.save(student);
            return new ResponseEntity<>("Estudiante insertado correctamente", HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<String> updateStudent(StudentDTO studentDTO, Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student=optionalStudent.get();
            student.setName(studentDTO.getName());
            student.setLastName(studentDTO.getLastname());
            student.setDni(studentDTO.getDni());
            student.setStudentStatus(typeRepository.findByMeaning(studentDTO.getStudentStatus()));
            student.setStudentCareer(studentDTO.getStudentCareer());
            studentRepository.save(student);
            return new ResponseEntity<>("Estudiante actualizado correctamente", HttpStatus.OK);
        } else {
            log.info("No se puede actualizar, estudiante ingresado no existe");
            return new ResponseEntity<>("Estudiante no existe", HttpStatus.BAD_REQUEST);
        }
    }
    @Override
    public ResponseEntity<String> deleteById(Long id) {
        if(studentRepository.findById(id).isEmpty()){
            log.info("El estudiante con el id: "+id+" no existe");
            return new ResponseEntity<>("El estudiante con el id:"+id+" no existe", HttpStatus.BAD_REQUEST);}
        studentRepository.deleteById(id);
        return new ResponseEntity<>("Estudiante eliminado con éxito",HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> findById(Long id) {
        Optional<Student> student=studentRepository.findById(id);

        if (student.isPresent()) {
            var studentAux = student.get();
            return new ResponseEntity<>(new StudentDTO(studentAux.getName()
                    , studentAux.getLastName()
                    , studentAux.getDni()
                    , studentAux.getStudentStatus().getMeaning()
                    , studentAux.getStudentCareer())
                    , HttpStatus.OK);
        } else {
            log.info("El estudiante con el id: " + id + " no se encuentra en base de datos");
            return new ResponseEntity<>("El estudiante con el id: " + id + " no existe", HttpStatus.BAD_REQUEST);
        }
    }



}
