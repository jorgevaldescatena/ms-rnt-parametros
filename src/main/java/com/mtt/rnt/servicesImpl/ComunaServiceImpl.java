package com.mtt.rnt.servicesImpl;

import com.mtt.rnt.dto.ComunaDTO;
import com.mtt.rnt.dto.LocalidadDTO;
import com.mtt.rnt.dto.ProvinciaDTO;
import com.mtt.rnt.dto.RegionDTO;
import com.mtt.rnt.entities.utilsDB.Comuna;
import com.mtt.rnt.entities.utilsDB.Localidad;
import com.mtt.rnt.entities.utilsDB.Provincia;
import com.mtt.rnt.entities.utilsDB.Region;
import com.mtt.rnt.repository.utilsDB.ComunaRepository;
import com.mtt.rnt.repository.utilsDB.LocalidadRepository;
import com.mtt.rnt.services.ComunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComunaServiceImpl implements ComunaService {

    @Autowired
    ComunaRepository comunaRepository;

    @Autowired
    LocalidadRepository localidadRepository;

    @Override
    public List<ComunaDTO> getAllComunas() {
        List<Comuna> comunas = comunaRepository.findAllWithProvinciaAndRegion();
        return comunas.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<LocalidadDTO> getAllLocalidades() {
        List<Localidad> localidades = localidadRepository.findAllWithComunaProvinciaAndRegion();
        return localidades.stream()
                .map(this::convertLocalidadToDTO)
                .collect(Collectors.toList());
    }

    private ComunaDTO convertToDTO(Comuna comuna) {
        ComunaDTO dto = new ComunaDTO();
        dto.setCodigo(comuna.getId());
        dto.setNombre(comuna.getNombre());
        if (comuna.getProvincia() != null) {
            dto.setProvincia(convertProvinciaToDTO(comuna.getProvincia()));
        }
        return dto;
    }

    private ProvinciaDTO convertProvinciaToDTO(Provincia provincia) {
        ProvinciaDTO dto = new ProvinciaDTO();
        dto.setCodigo(provincia.getCodigo());
        dto.setNombre(provincia.getNombre());
        if (provincia.getRegion() != null) {
            dto.setRegion(convertRegionToDTO(provincia.getRegion()));
        }
        return dto;
    }

    private RegionDTO convertRegionToDTO(Region region) {
        RegionDTO dto = new RegionDTO();
        dto.setCodigo(region.getCodigo());
        dto.setNombre(region.getNombre());
        dto.setPrefijo(region.getPrefijo());
        return dto;
    }

    private LocalidadDTO convertLocalidadToDTO(Localidad localidad) {
        LocalidadDTO dto = new LocalidadDTO();
        dto.setCodigo(localidad.getCodigo());
        dto.setNombre(localidad.getNombre());
        if (localidad.getComuna() != null) {
            dto.setComuna(convertToDTO(localidad.getComuna()));
        }
        return dto;
    }

}
