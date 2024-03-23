package com.cr.school.academic.repositories;

import com.cr.school.academic.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type,Long> {
    Type findByValue(Long value);
}
