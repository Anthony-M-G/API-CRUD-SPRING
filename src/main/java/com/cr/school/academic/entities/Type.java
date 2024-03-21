package com.cr.school.academic.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "types")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Type implements Serializable {
    @Serial
    private static final long serialVersionUID=1L;
    @Id
    @Column(name = "value_id")
    private Long value;
    @Column(name = "meaning")
    private String meaning;
    @Column(name = "type")
    private String type;

    @Override
    public String toString() {
        return
                "value: "+value + " "
               + "meaning: "+ meaning + " " + "type: "+type ;
    }
}
