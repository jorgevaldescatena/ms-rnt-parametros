package com.mtt.rnt.services;

import com.mtt.rnt.dto.ZonaComunaDTO;
import com.mtt.rnt.entities.ZonaComuna;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ZonaComunaService {

    /**
     * Obtiene todas las zonas comuna paginadas
     *
     * @param pageable
     * @return Page<ZonaComunaDTO>
     */
    Page<ZonaComunaDTO> getAllZonaComuna(Pageable pageable);

}
