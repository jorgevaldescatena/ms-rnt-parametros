package com.mtt.rnt.servicesImpl;

import com.mtt.rnt.dto.ZonaDTO;
import com.mtt.rnt.dto.ZonaLocalidadDTO;
import com.mtt.rnt.entities.ZonaLocalidad;
import com.mtt.rnt.repository.ZonaLocalidadRepository;
import com.mtt.rnt.services.ZonaLocalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZonaLocalidadServiceImpl implements ZonaLocalidadService {

    @Autowired
    ZonaLocalidadRepository zonaLocalidadRepository;

    @Override
    public List<ZonaLocalidadDTO> getAllZonaLocalidad() {
        List<ZonaLocalidad> zonaLocalidades = zonaLocalidadRepository.findAll();
        return zonaLocalidades.stream().map(this::convertToDTO).collect(Collectors.toList());
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
