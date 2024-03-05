package com.mtt.rnt.servicesImpl;

import com.mtt.rnt.dto.ZonaRegionDTO;
import com.mtt.rnt.entities.ZonaRegion;
import com.mtt.rnt.repository.ZonaRegionRepository;
import com.mtt.rnt.services.ZonaRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZonaRegionServiceImpl implements ZonaRegionService {

    @Autowired
    ZonaRegionRepository zonaRegionRepository;

    @Override
    public List<ZonaRegionDTO> getAllZonaRegion() {
        List<ZonaRegion> zonaRegions = zonaRegionRepository.findAll();
        return zonaRegions.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private ZonaRegionDTO convertToDTO(ZonaRegion zonaRegion) {
        ZonaRegionDTO dto = new ZonaRegionDTO();
        dto.setId(zonaRegion.getId());
        dto.setIdZona(zonaRegion.getZona().getId());
        dto.setIdRegion(zonaRegion.getIdRegion());
        return dto;
    }

}
