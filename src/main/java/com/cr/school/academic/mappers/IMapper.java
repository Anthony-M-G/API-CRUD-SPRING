package com.cr.school.academic.mappers;

import com.cr.school.academic.dto.StudentDTO;
import com.cr.school.academic.entities.Student;
import org.springframework.data.domain.Page;

public interface IMapper <D,E> {

    D entityToDto(E entity);
    E dtoToEntity(D dto);
    
    Page<D> entityToDto(Page<E> pageofEntities);



}
