package com.mtt.rnt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZonaComunaDTO extends BaseDTO{
    private Long id;
    private ZonaDTO zona;
    private String idColumna;
}
