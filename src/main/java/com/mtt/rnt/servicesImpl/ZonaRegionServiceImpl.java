package com.mtt.rnt.servicesImpl;

import com.mtt.rnt.dto.ZonaDTO;
import com.mtt.rnt.dto.ZonaRegionDTO;
import com.mtt.rnt.entities.RntDB.Zona;
import com.mtt.rnt.entities.RntDB.ZonaRegion;
import com.mtt.rnt.repository.RntDB.ZonaRegionRepository;
import com.mtt.rnt.services.ZonaRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZonaRegionServiceImpl implements ZonaRegionService {

    @Autowired
    ZonaRegionRepository zonaRegionRepository;

    @Override
    public Page<ZonaRegionDTO> getAllZonaRegion(Pageable pageable) {
        Page<ZonaRegion> zonaRegionPage = zonaRegionRepository.findAll(pageable);
        return zonaRegionPage.map(this::convertToDTO);
    }

    private ZonaRegionDTO convertToDTO(ZonaRegion zonaRegion) {
        ZonaRegionDTO dto = new ZonaRegionDTO();
        dto.setId(zonaRegion.getId());
        dto.setZona(zonaConvertToDTO(zonaRegion.getZona()));
        dto.setIdRegion(zonaRegion.getIdRegion());
        return dto;
    }

    private ZonaDTO zonaConvertToDTO(Zona zona) {
        ZonaDTO dto = new ZonaDTO();
        dto.setId(zona.getId());
        dto.setNombre(zona.getNombre());
        dto.setDescriptor(zona.getDescriptor());
        dto.setTipoZona(zona.getTipoZona());
        dto.setTipoSubsidio(zona.getTipoSubsidio());

        if (zona.getZonaRegiones() != null && !zona.getZonaRegiones().isEmpty()) {
            List<String> regionIds = zona.getZonaRegiones().stream()
                    .map(zonaRegion -> zonaRegion.getIdRegion())
                    .collect(Collectors.toList());
            dto.setRegiones(regionIds);
        }

        if (zona.getZonaComunas() != null && !zona.getZonaComunas().isEmpty()) {
            List<String> comunaIds = zona.getZonaComunas().stream()
                    .map(zonaComuna -> zonaComuna.getIdColumna())
                    .collect(Collectors.toList());
            dto.setComunas(comunaIds);
        }

        if (zona.getZonaLocalidades() != null && !zona.getZonaLocalidades().isEmpty()) {
            List<String> localidadIds = zona.getZonaLocalidades().stream()
                    .map(zonaLocalidad -> zonaLocalidad.getIdLocalidad().toString())
                    .collect(Collectors.toList());
            dto.setLocalidades(localidadIds);
        }

        return dto;
    }

}
