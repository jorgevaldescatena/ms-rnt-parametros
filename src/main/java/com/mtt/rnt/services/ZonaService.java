package com.mtt.rnt.services;

import com.mtt.rnt.dto.ZonaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ZonaService {

    /**
     * Devuelve todas las zonas paginadas
     *
     * @param pageable
     * @return Page<ZonaDTO> Lista de zonas paginadas
     */
    Page<ZonaDTO> getAllZonas(Pageable pageable);

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
     * @param zonaDTOS Lista de zonas a consultar
     * @return List<String> Lista de ids de comunas asociadas a las zonas
     */
    List<String> getComunasIdsfromZonas(List<ZonaDTO> zonaDTOS);

    /**
     * Devuelve los ids de las localidades correspondientes a las zonas pasadas como parámetro
     *
     * @param zonasDTO Lista de zonas a consultar
     * @return List<Integer> Lista de ids de localidades asociadas a las zonas
     */
    List<Integer> getLocalidadesIdsFromZonas(List<ZonaDTO> zonasDTO);

}
