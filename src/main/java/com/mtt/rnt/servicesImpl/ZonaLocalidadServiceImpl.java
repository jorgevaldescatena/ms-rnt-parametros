package com.mtt.rnt.servicesImpl;

import com.mtt.rnt.entities.ZonaLocalidad;
import com.mtt.rnt.repository.ZonaLocalidadRepository;
import com.mtt.rnt.services.ZonaLocalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZonaLocalidadServiceImpl implements ZonaLocalidadService {

    @Autowired
    ZonaLocalidadRepository zonaLocalidadRepository;

    @Override
    public List<ZonaLocalidad> getAllZonaLocalidad() {
        return zonaLocalidadRepository.findAll();
    }

}
