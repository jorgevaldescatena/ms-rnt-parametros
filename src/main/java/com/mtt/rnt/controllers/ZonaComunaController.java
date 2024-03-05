package com.mtt.rnt.controllers;

import com.mtt.rnt.dto.BaseDTO;
import com.mtt.rnt.services.ZonaComunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/zona-comuna", produces = MediaType.APPLICATION_JSON_VALUE)
public class ZonaComunaController {

    @Autowired
    ZonaComunaService zonaComunaService;

    @GetMapping("/get-all-zona-comuna")
    public ResponseEntity<List<BaseDTO>> getAllZonaComuna() {
        List<BaseDTO> zonaComunaDTOs = zonaComunaService.getAllZonaComuna().stream()
                .map(zonaComunaDTO -> (BaseDTO) zonaComunaDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(zonaComunaDTOs);
    }

}
