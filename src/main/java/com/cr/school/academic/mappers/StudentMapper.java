package com.cr.school.academic.mappers;

import com.cr.school.academic.dto.StudentDTO;
import com.cr.school.academic.entities.Student;
import com.cr.school.academic.repositories.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentMapper implements IMapper<StudentDTO, Student> {

    private final TypeRepository typeRepository;
    private final ModelMapper modelMapper;

    @Override
    public StudentDTO entityToDto(Student entity) {
        StudentDTO studentDTO=modelMapper.map(entity,StudentDTO.class);
        studentDTO.setStudentStatus(entity.getStudentStatus().getMeaning());
        return studentDTO;
    }

    @Override
    public Student dtoToEntity(StudentDTO dto) {
        Student student=modelMapper.map(dto,Student.class);
        student.setStudentStatus(typeRepository.findByMeaning(dto.getStudentStatus()));
        return student;
    }

    @Override
    public Page<StudentDTO> entityToDto(Page<Student> pageofEntities) {
        return pageofEntities.map((element) -> modelMapper.map(element, StudentDTO.class));
    }



}
