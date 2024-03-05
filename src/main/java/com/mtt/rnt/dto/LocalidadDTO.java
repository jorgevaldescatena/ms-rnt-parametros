package com.mtt.rnt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocalidadDTO extends BaseDTO{

    private Integer codigo;
    private String nombre;
    private ComunaDTO comuna;

}
