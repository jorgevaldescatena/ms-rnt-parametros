package com.mtt.rnt.servicesImpl;

import com.mtt.rnt.entities.ZonaComuna;
import com.mtt.rnt.repository.ZonaComunaRepository;
import com.mtt.rnt.services.ZonaComunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZonaComunaServiceImpl implements ZonaComunaService {

    @Autowired
    ZonaComunaRepository zonaComunaRepository;


    @Override
    public List<ZonaComuna> getAllZonaComuna() {
        return zonaComunaRepository.findAll();
    }

}
