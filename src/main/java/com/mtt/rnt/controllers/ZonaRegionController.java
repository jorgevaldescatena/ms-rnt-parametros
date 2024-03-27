package com.mtt.rnt.controllers;

import com.mtt.rnt.dto.BaseDTO;
import com.mtt.rnt.dto.ZonaRegionDTO;
import com.mtt.rnt.services.ZonaRegionService;
import io.swagger.v3.oas.annotations.Operation;
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
@RequestMapping(path = "/api/zona-region", produces = MediaType.APPLICATION_JSON_VALUE)
public class ZonaRegionController {

    @Autowired
    ZonaRegionService zonaRegionService;

    @Operation(summary = "Obtiene todas las zonas regiones", description = "Retorna una página de zonas regiones, soportando paginación.")
    @GetMapping("/get-all-zona-region")
    public ResponseEntity<Page<BaseDTO>> getAllZonaRegion(Pageable pageable) {
        Page<ZonaRegionDTO> zonaRegionPage = zonaRegionService.getAllZonaRegion(pageable);
        Page<BaseDTO> baseDTOPage = zonaRegionPage.map(zonaRegionDTO -> (BaseDTO) zonaRegionDTO);
        return ResponseEntity.ok(baseDTOPage);
    }

}
