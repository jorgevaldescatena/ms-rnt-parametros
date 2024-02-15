package com.mtt.rnt.servicesImpl;

import com.mtt.rnt.dto.ZonaDTO;
import com.mtt.rnt.entities.Zona;
import com.mtt.rnt.repository.ZonaComunaRepository;
import com.mtt.rnt.repository.ZonaRegionRepository;
import com.mtt.rnt.repository.ZonaRepository;
import com.mtt.rnt.services.ZonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZonaServiceImpl implements ZonaService {

    @Autowired
    ZonaRepository zonaRepository;

    @Autowired
    ZonaComunaRepository zonaComunaRepository;

    @Autowired
    ZonaRegionRepository zonaRegionRepository;

    @Override
    public List<String> getRegionesIdsFromZonas(List<ZonaDTO> zonasDTO) {
        if (zonasDTO == null || zonasDTO.isEmpty()) {
            throw new IllegalArgumentException("La lista de zonas no puede estar vacía.");
        }

        List<Long> zonasIds = zonasDTO.stream()
                .map(ZonaDTO::getId)
                .collect(Collectors.toList());

        return zonaRegionRepository.findDistinctRegionIdsByZonaIds(zonasIds);
    }

    @Override
    public List<String> getComunasIdsfromZonas(List<ZonaDTO> zonasDTO) {
        List<Long> zonasIds = zonasDTO.stream()
                .map(ZonaDTO::getId)
                .collect(Collectors.toList());

        if (zonasIds.isEmpty()) {
            throw new IllegalArgumentException("La lista de zonas no puede estar vacía.");
        }

        return zonaComunaRepository.findDistinctIdComunaByZonaIds(zonasIds);
    }

}
