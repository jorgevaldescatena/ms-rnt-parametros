package com.mtt.rnt.services;

import com.mtt.rnt.dto.ZonaRegionDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ZonaRegionService {

    /**
     * Obtiene todas las zonas regiones paginadas
     *
     * @param pageable
     * @return Page<ZonaRegionDTO>
     */
    Page<ZonaRegionDTO> getAllZonaRegion(Pageable pageable);

}
