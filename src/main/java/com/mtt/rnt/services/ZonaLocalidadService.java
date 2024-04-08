package com.mtt.rnt.services;

import com.mtt.rnt.dto.ZonaLocalidadDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ZonaLocalidadService {

    /**
     * Obtiene una lista pagina de ZonaLocalidad
     *
     * @param pageable
     * @return
     */
    Page<ZonaLocalidadDTO> getAllZonaLocalidad(Pageable pageable);

}
