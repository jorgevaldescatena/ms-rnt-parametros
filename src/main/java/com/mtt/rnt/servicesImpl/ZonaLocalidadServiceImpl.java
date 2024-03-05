package com.mtt.rnt.servicesImpl;

import com.mtt.rnt.dto.ZonaDTO;
import com.mtt.rnt.dto.ZonaLocalidadDTO;
import com.mtt.rnt.entities.ZonaLocalidad;
import com.mtt.rnt.repository.ZonaLocalidadRepository;
import com.mtt.rnt.services.ZonaLocalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZonaLocalidadServiceImpl implements ZonaLocalidadService {

    @Autowired
    ZonaLocalidadRepository zonaLocalidadRepository;

    @Override
    public Page<ZonaLocalidadDTO> getAllZonaLocalidad(Pageable pageable) {
        Page<ZonaLocalidad> zonaLocalidadPage = zonaLocalidadRepository.findAll(pageable);
        return zonaLocalidadPage.map(this::convertToDTO);
    }

    private ZonaLocalidadDTO convertToDTO(ZonaLocalidad zonaLocalidad) {
        ZonaLocalidadDTO dto = new ZonaLocalidadDTO();
        dto.setId(zonaLocalidad.getId());

        ZonaDTO zonaDTO = new ZonaDTO();
        zonaDTO.setId(zonaLocalidad.getZona().getId());

        dto.setZona(zonaDTO);

        dto.setIdLocalidad(zonaLocalidad.getIdLocalidad());
        return dto;
    }

}
