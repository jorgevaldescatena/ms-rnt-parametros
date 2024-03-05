package com.mtt.rnt.services;

import com.mtt.rnt.dto.ZonaComunaDTO;
import com.mtt.rnt.entities.ZonaComuna;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ZonaComunaService {

    Page<ZonaComunaDTO> getAllZonaComuna(Pageable pageable);

}
