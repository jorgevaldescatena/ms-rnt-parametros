package com.mtt.rnt.services;

import com.mtt.rnt.dto.ZonaDTO;
import com.mtt.rnt.entities.Zona;

import java.util.List;

public interface ZonaService {

    /**
     * Devuelve los ids de las regiones correspondientes a las zonas pasadas como parámetro
     *
     * @param zonasDTO Lista de zonas a consultar
     * @return List<String> Lista de ids de regiones asociadas a las zonas
     */
    List<String> getRegionesIdsFromZonas(List<ZonaDTO> zonasDTO);

    /**
     * Devuelve los ids de las comunas correspondientes a las zonas pasadas como parámetro
     *
     * @param zonas Lista de zonas a consultar
     * @return List<String> Lista de ids de comunas asociadas a las zonas
     */
    List<String> getComunasIdsfromZonas(List<ZonaDTO> zonaDTOS);

}
