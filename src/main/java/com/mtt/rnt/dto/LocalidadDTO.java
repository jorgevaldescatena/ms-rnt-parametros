package com.mtt.rnt.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocalidadDTO extends BaseDTO{

    private Long codigo;
    private String nombre;
    @JsonBackReference
    private ComunaDTO comuna;

}
