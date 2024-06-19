package com.mtt.rnt.servicesImpl;

import com.mtt.rnt.dto.ZonaComunaDTO;
import com.mtt.rnt.dto.ZonaDTO;
import com.mtt.rnt.entities.RntDB.Zona;
import com.mtt.rnt.entities.RntDB.ZonaComuna;
import com.mtt.rnt.entities.RntDB.ZonaRegion;
import com.mtt.rnt.repository.RntDB.ZonaComunaRepository;
import com.mtt.rnt.services.ZonaComunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZonaComunaServiceImpl implements ZonaComunaService {

    @Autowired
    ZonaComunaRepository zonaComunaRepository;


    @Override
    @Transactional(value = "rntTransactionManager", readOnly = true)
    public Page<ZonaComunaDTO> getAllZonaComuna(Pageable pageable) {
        Page<ZonaComuna> zonaComunaPage = zonaComunaRepository.findAll(pageable);
        return zonaComunaPage.map(this::convertToDTO);
    }

    private ZonaComunaDTO convertToDTO(ZonaComuna zonaComuna) {
        ZonaComunaDTO dto = new ZonaComunaDTO();
        dto.setId(zonaComuna.getId());

        if (zonaComuna.getZona() != null) {
            dto.setZona(convertZonaToDTO(zonaComuna.getZona()));
        }

        dto.setIdColumna(zonaComuna.getIdColumna());
        return dto;
    }

    private ZonaDTO convertZonaToDTO(Zona zona) {
        ZonaDTO dto = new ZonaDTO();
        dto.setId(zona.getId());
        dto.setNombre(zona.getNombre());
        dto.setDescriptor(zona.getDescriptor());
        dto.setIdRegion(zona.getIdRegion());
        dto.setIdOld(zona.getIdOld());
        dto.setActiva(zona.getActiva());
        dto.setTipoZona(zona.getTipoZona());
        dto.setTipoSubsidio(zona.getTipoSubsidio());
        if (zona.getZonaRegiones() != null && !zona.getZonaRegiones().isEmpty()) {
            List<String> regionIds = zona.getZonaRegiones().stream()
                    .map(ZonaRegion::getIdRegion)
                    .collect(Collectors.toList());
            dto.setRegiones(regionIds);
        }

        if (zona.getZonaComunas() != null && !zona.getZonaComunas().isEmpty()) {
            List<String> comunaIds = zona.getZonaComunas().stream()
                    .map(ZonaComuna::getIdColumna)
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
