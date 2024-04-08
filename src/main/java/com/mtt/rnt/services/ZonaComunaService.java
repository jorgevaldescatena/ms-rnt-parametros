package com.mtt.rnt.services;

import com.mtt.rnt.dto.ZonaComunaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ZonaComunaService {

    /**
     * Obtiene todas las zonas comuna paginadas
     *
     * @param pageable
     * @return Page<ZonaComunaDTO>
     */
    Page<ZonaComunaDTO> getAllZonaComuna(Pageable pageable);

}
