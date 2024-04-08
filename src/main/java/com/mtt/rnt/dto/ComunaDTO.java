package com.mtt.rnt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComunaDTO extends BaseDTO{

    private String codigo;
    private String nombre;
    private ProvinciaDTO provincia;

}
