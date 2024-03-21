package com.cr.school.academic.repositories;

import com.cr.school.academic.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {



    Optional<Student> findByDni(@Param("dni") Long dni);

    Page<Student> findByName(String name,Pageable pageable);


}
