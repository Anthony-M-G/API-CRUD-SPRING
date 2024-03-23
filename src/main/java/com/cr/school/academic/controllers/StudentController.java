package com.cr.school.academic.controllers;

import com.cr.school.academic.dto.StudentDTO;
import com.cr.school.academic.services.StudentServices;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping(value = "/test")
@Slf4j
public class StudentController {

    private final StudentServices studentServices;
    public StudentController(StudentServices studentServices) {
        this.studentServices = studentServices;
    }

    @GetMapping("/get")
    public ResponseEntity<Object> getAll(@RequestParam(defaultValue = "0") Integer page, // Método para listar todos y para listar según un nombre
                                @RequestParam(defaultValue = "10") Integer size,
                                @RequestParam(required = false,defaultValue = "") String name){
        
        return studentServices.getAll(page, size,name);
    }
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody @Valid StudentDTO studentDTO){
        return studentServices.save(studentDTO);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateStudent(@RequestBody @Valid StudentDTO studentDTO, @PathVariable(name = "id") @Min(1) Long id) {
        return studentServices.updateStudent(studentDTO,id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(name = "id") @Min(1) Long id){
        return studentServices.deleteById(id);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Object> findById(@PathVariable(name = "id") @Min(1) Long id){
        return studentServices.findById(id);
    }

}
