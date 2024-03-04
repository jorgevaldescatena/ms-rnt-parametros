package com.mtt.rnt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZonaLocalidadDTO extends BaseDTO{

    private Long id;
    private ZonaDTO zona;
    private Integer idLocalidad;

}
