package com.mtt.rnt.controllers;

import com.mtt.rnt.dto.BaseDTO;
import com.mtt.rnt.dto.ZonaLocalidadDTO;
import com.mtt.rnt.services.ZonaLocalidadService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/get-all")
    public ResponseEntity<List<BaseDTO>> getAllZonaLocalidad() {
        List<BaseDTO> zonaLocalidadDTOs = zonaLocalidadService.getAllZonaLocalidad().stream()
                .map(zonaLocalidadDTO -> (BaseDTO) zonaLocalidadDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(zonaLocalidadDTOs);
    }

}
