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
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ComunaServiceImpl implements ComunaService {

    @Autowired
    ComunaRepository comunaRepository;

    @Autowired
    LocalidadRepository localidadRepository;

    private Map<Long, ComunaDTO> processedComunas = new HashMap<>();
    private Map<Long, LocalidadDTO> processedLocalidades = new HashMap<>();

    @Override
    public List<ComunaDTO> getAllComunas() {
        List<Comuna> comunas = comunaRepository.findAllWithProvinciaAndRegion();
        return comunas.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true, transactionManager = "utilsTransactionManager")
    public List<LocalidadDTO> getAllLocalidades() {
        List<Localidad> localidades = localidadRepository.findAllWithComunaProvinciaAndRegion();
        return localidades.stream()
                .map(this::convertLocalidadToDTO)
                .collect(Collectors.toList());
    }

    private ComunaDTO convertToDTO(Comuna comuna) {
        Long comunaId = Long.parseLong(comuna.getId());
        if (processedComunas.containsKey(comunaId)) {
            return processedComunas.get(comunaId);
        }

        ComunaDTO dto = new ComunaDTO();
        dto.setCodigo(comuna.getId());
        dto.setNombre(comuna.getNombre());
        if (comuna.getProvincia() != null) {
            dto.setProvincia(convertProvinciaToDTO(comuna.getProvincia()));
        }

        processedComunas.put(comunaId, dto);

        if (comuna.getLocalidades() != null && !comuna.getLocalidades().isEmpty()) {
            List<LocalidadDTO> localidadDTOs = new ArrayList<>();
            for (Localidad localidad : comuna.getLocalidades()) {
                LocalidadDTO localidadDTO = convertLocalidadToDTO(localidad);
                if (localidadDTO != null) {
                    localidadDTOs.add(localidadDTO);
                }
            }
            dto.setLocalidades(localidadDTOs);
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
        if (localidad != null) {
            if (processedLocalidades.containsKey(localidad.getCodigo())) {
                return processedLocalidades.get(localidad.getCodigo());
            }

            LocalidadDTO localidadDTO = new LocalidadDTO();
            localidadDTO.setCodigo(localidad.getCodigo());
            localidadDTO.setNombre(localidad.getNombre());

            processedLocalidades.put(localidad.getCodigo(), localidadDTO);

            if (localidad.getComuna() != null) {
                localidadDTO.setComuna(convertToDTO(localidad.getComuna()));
            }

            return localidadDTO;
        }
        return null;
    }

}
