package com.mtt.rnt.servicesImpl;

import com.mtt.rnt.dto.ZonaComunaDTO;
import com.mtt.rnt.entities.ZonaComuna;
import com.mtt.rnt.repository.ZonaComunaRepository;
import com.mtt.rnt.services.ZonaComunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZonaComunaServiceImpl implements ZonaComunaService {

    @Autowired
    ZonaComunaRepository zonaComunaRepository;


    @Override
    public Page<ZonaComunaDTO> getAllZonaComuna(Pageable pageable) {
        Page<ZonaComuna> zonaComunaPage = zonaComunaRepository.findAll(pageable);
        return zonaComunaPage.map(this::convertToDTO);
    }

    //Metodo para convertir de entidad ZonaComuna a DTO ZonaComuna
    private ZonaComunaDTO convertToDTO(ZonaComuna zonaComuna) {
        ZonaComunaDTO dto = new ZonaComunaDTO();
        dto.setId(zonaComuna.getId());
        dto.setIdZona(zonaComuna.getZona().getId());
        dto.setIdColumna(zonaComuna.getIdColumna());
        return dto;
    }

}
