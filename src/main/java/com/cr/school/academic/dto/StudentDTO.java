package com.cr.school.academic.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    @NotEmpty(message = "El nombre es requerido")
    private String name;

    @NotEmpty(message = "El apellido es requerido")
    private String lastname;

    @NotNull(message = "El dni es requerido")
    private Long dni;

    @NotNull(message = "El estado del estudiante es requerido")
    private String studentStatus;
    @NotNull(message = "La carrera es requerida")
    private Short studentCareer;
}
