package com.mtt.rnt.controllers;

import com.mtt.rnt.dto.BaseDTO;
import com.mtt.rnt.services.ZonaRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/zona-region", produces = MediaType.APPLICATION_JSON_VALUE)
public class ZonaRegionController {

    @Autowired
    ZonaRegionService zonaRegionService;

    @GetMapping("/get-all-zona-region")
    public ResponseEntity<List<BaseDTO>> getAllZonaRegion() {
        List<BaseDTO> zonaRegionDTOs = zonaRegionService.getAllZonaRegion().stream()
                .map(zonaRegionDTO -> (BaseDTO) zonaRegionDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(zonaRegionDTOs);
    }

}
