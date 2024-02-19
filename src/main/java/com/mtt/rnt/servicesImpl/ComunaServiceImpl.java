package com.mtt.rnt.servicesImpl;

import com.mtt.rnt.entities.Comuna;
import com.mtt.rnt.entities.Localidad;
import com.mtt.rnt.repository.ComunaRepository;
import com.mtt.rnt.repository.LocalidadRepository;
import com.mtt.rnt.services.ComunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComunaServiceImpl implements ComunaService {

    @Autowired
    ComunaRepository comunaRepository;

    @Autowired
    LocalidadRepository localidadRepository;

    @Override
    public List<Comuna> getAllComunas() {
        return comunaRepository.findAllWithProvinciaAndRegion();
    }

    @Override
    public List<Localidad> getAllLocalidades() {
        return localidadRepository.findAllWithComunaProvinciaAndRegion();
    }

}
