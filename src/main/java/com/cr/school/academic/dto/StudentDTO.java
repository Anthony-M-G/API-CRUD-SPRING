package com.cr.school.academic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private String name;
    private String lastname;
    private Long dni;
    private Long studentStatus;
    private Short studentCareer;
}
