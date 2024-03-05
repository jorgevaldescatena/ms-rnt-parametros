package com.mtt.rnt.controllers;

import com.mtt.rnt.dto.BaseDTO;
import com.mtt.rnt.dto.ZonaLocalidadDTO;
import com.mtt.rnt.services.ZonaLocalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/zona-localidad", produces = MediaType.APPLICATION_JSON_VALUE)
public class ZonaLocalidadController {

    @Autowired
    ZonaLocalidadService zonaLocalidadService;

    @GetMapping("/get-all-zona-localidad")
    public ResponseEntity<Page<BaseDTO>> getAllZonaLocalidad(Pageable pageable) {
        Page<ZonaLocalidadDTO> zonaLocalidadPage = zonaLocalidadService.getAllZonaLocalidad(pageable);
        Page<BaseDTO> baseDTOPage = zonaLocalidadPage.map(zonaLocalidadDTO -> (BaseDTO) zonaLocalidadDTO);
        return ResponseEntity.ok(baseDTOPage);
    }

}
