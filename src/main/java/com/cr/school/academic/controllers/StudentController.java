package com.cr.school.academic.controllers;

import com.cr.school.academic.entities.Student;
import com.cr.school.academic.services.StudentServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
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
    public String save(@RequestBody Student student){
        studentServices.save(student);
        return "/test/all";
    }
    @GetMapping("/get/")
    public ResponseEntity<String> getByDni(@RequestParam Long dni){
        return studentServices.findByDni(dni);
    }

    @PutMapping("/edit")
    public Student updateStudent(@RequestBody Student student, @RequestParam short id) {
        student.getStudentStatus();
        return studentServices.updateStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(name = "id") Long id){
        return studentServices.deleteById(id);
    }

}
