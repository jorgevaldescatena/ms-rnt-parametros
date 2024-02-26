package com.mtt.rnt.servicesImpl;

import com.mtt.rnt.dto.ZonaDTO;
import com.mtt.rnt.entities.Servicio;
import com.mtt.rnt.entities.Zona;
import com.mtt.rnt.repository.ZonaComunaRepository;
import com.mtt.rnt.repository.ZonaLocalidadRepository;
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

    @Autowired
    ZonaLocalidadRepository zonaLocalidadRepository;

    //TODO: Implementar paginación
    @Override
    public List<ZonaDTO> getAllZonas() {
        List<Zona> allZonas = zonaRepository.findAll();
        return allZonas.stream().map(this::convertToDto).collect(Collectors.toList());
    }

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
        if (zonasDTO == null || zonasDTO.isEmpty()) {
            throw new IllegalArgumentException("La lista de zonas no puede estar vacía.");
        }

        List<Long> zonasIds = zonasDTO.stream()
                .map(ZonaDTO::getId)
                .collect(Collectors.toList());

        return zonaComunaRepository.findDistinctIdComunaByZonaIds(zonasIds);
    }

    @Override
    public List<Integer> getLocalidadesIdsFromZonas(List<ZonaDTO> zonasDTO) {
        if (zonasDTO == null || zonasDTO.isEmpty()) {
            throw new IllegalArgumentException("La lista de zonas no puede estar vacía.");
        }

        List<Long> zonasIds = zonasDTO.stream()
                .map(ZonaDTO::getId)
                .collect(Collectors.toList());

        return zonaLocalidadRepository.findDistinctIdLocalidadByZonaIds(zonasIds);

    }

    /**
     * Convierte una entidad Zona a su correspondiente DTO
     *
     * @param zona Entidad Zona
     * @return DTO Zona
     */
    public ZonaDTO convertToDto(Zona zona) {
        ZonaDTO dto = new ZonaDTO();
        dto.setId(zona.getId());
        dto.setNombre(zona.getNombre());
        dto.setDescriptor(zona.getDescriptor());
        dto.setIdRegion(zona.getIdRegion());
        dto.setIdOld(zona.getIdOld());
        dto.setActiva(zona.getActiva());
        dto.setTipoZona(zona.getTipoZona() != null ? zona.getTipoZona().getNombre() : null);
        dto.setTipoSubsidio(zona.getTipoSubsidio() != null ? zona.getTipoSubsidio().getNombre() : null);

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
