package com.mtt.rnt.servicesImpl;

import com.mtt.rnt.entities.Zona;
import com.mtt.rnt.repository.ZonaRepository;
import com.mtt.rnt.services.ZonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ZonaServiceImpl implements ZonaService {

    @Autowired
    ZonaRepository zonaRepository;

    @Override
    public List<String> getRegionesIdsFromZonas(List<Zona> zonas) {
        List<Long> zonasIds = new ArrayList<>();
        for (Zona zona : zonas) {
            zonasIds.add(zona.getId());
        }

        if (zonasIds.isEmpty()) {
            return new ArrayList<>();
        }

        return zonaRepository.findDistinctRegionIdsByZonaIds(zonasIds);
    }

}
