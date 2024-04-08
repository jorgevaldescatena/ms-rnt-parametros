package com.mtt.rnt.servicesImpl;

import com.mtt.rnt.dto.ZonaDTO;
import com.mtt.rnt.entities.RntDB.Zona;
import com.mtt.rnt.repository.RntDB.ZonaComunaRepository;
import com.mtt.rnt.repository.RntDB.ZonaLocalidadRepository;
import com.mtt.rnt.repository.RntDB.ZonaRegionRepository;
import com.mtt.rnt.repository.RntDB.ZonaRepository;
import com.mtt.rnt.services.ZonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    @Override
    public Page<ZonaDTO> getAllZonas(Pageable pageable) {
        return zonaRepository.findAll(pageable)
                .map(this::convertToDto);
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
