package com.mtt.rnt.servicesImpl;

import com.mtt.rnt.entities.ZonaRegion;
import com.mtt.rnt.repository.ZonaRegionRepository;
import com.mtt.rnt.services.ZonaRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZonaRegionServiceImpl implements ZonaRegionService {

    @Autowired
    ZonaRegionRepository zonaRegionRepository;

    @Override
    public List<ZonaRegion> getAllZonaRegion() {
        return zonaRegionRepository.findAll();
    }

}
