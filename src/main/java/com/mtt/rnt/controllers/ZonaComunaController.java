package com.mtt.rnt.controllers;

import com.mtt.rnt.dto.BaseDTO;
import com.mtt.rnt.dto.ZonaComunaDTO;
import com.mtt.rnt.services.ZonaComunaService;
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
@RequestMapping(path = "/api/zona-comuna", produces = MediaType.APPLICATION_JSON_VALUE)
public class ZonaComunaController {

    @Autowired
    ZonaComunaService zonaComunaService;


    @Operation(summary = "Obtiene todas las zonas comunas", description = "Retorna una página de zonas comunas, soportando paginación.")
    @GetMapping("/get-all-zona-comuna")
    public ResponseEntity<Page<BaseDTO>> getAllZonaComuna(Pageable pageable) {
        Page<ZonaComunaDTO> zonaComunaPage = zonaComunaService.getAllZonaComuna(pageable);
        Page<BaseDTO> baseDTOPage = zonaComunaPage.map(zonaComunaDTO -> (BaseDTO) zonaComunaDTO);
        return ResponseEntity.ok(baseDTOPage);
    }

}
