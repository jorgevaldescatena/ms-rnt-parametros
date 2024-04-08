package com.mtt.rnt.servicesImpl;

import com.mtt.rnt.entities.utilsDB.Comuna;
import com.mtt.rnt.entities.utilsDB.Localidad;
import com.mtt.rnt.repository.utilsDB.ComunaRepository;
import com.mtt.rnt.repository.utilsDB.LocalidadRepository;
import com.mtt.rnt.services.ComunaService;
import org.springframework.beans.factory.annotation.Autowired;
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
