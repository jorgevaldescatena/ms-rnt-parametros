package com.mtt.rnt.dto;

import com.mtt.rnt.entities.RntDB.Zona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZonaRegionDTO extends BaseDTO{
    private Long id;
    private ZonaDTO zona;
    private String idRegion;
}
