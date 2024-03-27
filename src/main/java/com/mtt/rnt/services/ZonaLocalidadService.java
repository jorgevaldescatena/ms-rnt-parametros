package com.mtt.rnt.services;

import com.mtt.rnt.dto.ZonaLocalidadDTO;
import com.mtt.rnt.entities.ZonaLocalidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ZonaLocalidadService {

    /**
     * Obtiene una lista pagina de ZonaLocalidad
     *
     * @param pageable
     * @return
     */
    Page<ZonaLocalidadDTO> getAllZonaLocalidad(Pageable pageable);

}
