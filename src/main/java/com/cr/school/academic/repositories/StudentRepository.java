package com.cr.school.academic.repositories;

import com.cr.school.academic.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


    boolean existsByDni(Long dni);

    Page<Student> findByName(String name,Pageable pageable);


}
