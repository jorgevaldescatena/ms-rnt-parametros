package com.mtt.rnt.servicesImpl;

import com.mtt.rnt.dto.ZonaRegionDTO;
import com.mtt.rnt.entities.ZonaRegion;
import com.mtt.rnt.repository.ZonaRegionRepository;
import com.mtt.rnt.services.ZonaRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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
        dto.setIdZona(zonaRegion.getZona().getId());
        dto.setIdRegion(zonaRegion.getIdRegion());
        return dto;
    }

}
