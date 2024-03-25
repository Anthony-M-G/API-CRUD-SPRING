package com.cr.school.academic.controllers;

import com.cr.school.academic.dto.StudentDTO;
import com.cr.school.academic.services.StudentServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@Slf4j
@Tag(name = "Manejo de estudiantes", description = "Operaciones para manejar registro de estudiantes")
public class StudentController {

    private final StudentServices studentServices;
    public StudentController(StudentServices studentServices) {
        this.studentServices = studentServices;
    }

    @GetMapping("/students")
    @Operation(summary = "Lista los registros de los estudiantes",description = "Muestra la lista de todos los estudiantes registrados a través de un paginado, también podemos indicar un nombre y mostrar los registros que coincidan con ese nombre")
    public ResponseEntity<Object> getAllStudents(
            @RequestParam(defaultValue = "0") Integer page, // Método para listar todos y para listar según un nombre
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(required = false, defaultValue = "") String name
            , @RequestParam(defaultValue = "asc") String orientation
            , @RequestParam(defaultValue = "id") String orderBy){
        return studentServices.getAllStudents(page, size,name, orientation, orderBy);
    }
    @PostMapping("/student")
    @Operation(summary = "Ingresa un nuevo estudiante en la base de datos")
    public ResponseEntity<String> saveStudent(@RequestBody @Valid StudentDTO studentDTO){
        return studentServices.createStudent(studentDTO);
    }
    @PutMapping("/student/{id}")
    @Operation(summary = "Actualiza el estudiante con el id indicado")
    public ResponseEntity<String> updateStudent(@RequestBody @Valid StudentDTO studentDTO, @PathVariable(name = "id") @Min(1) Long id) {
        return studentServices.updateStudent(studentDTO,id);
    }

    @DeleteMapping("/student/{id}")
    @Operation(summary = "Elimina el estudiante con el id correspondiente")
    public ResponseEntity<String> deleteStudent(@PathVariable(name = "id") @Min(1) Long id){
        return studentServices.deleteStudentById(id);
    }
    @GetMapping("/student/{id}")
    @Operation(summary = "Trae el registro del estudiante con el id especificado")
    public ResponseEntity<Object> findStudent(@PathVariable(name = "id") @Min(1) Long id){
        return studentServices.findStudentById(id);
    }

}
