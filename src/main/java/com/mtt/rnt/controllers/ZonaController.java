package com.mtt.rnt.controllers;

import com.mtt.rnt.dto.BaseDTO;
import com.mtt.rnt.dto.ZonaDTO;
import com.mtt.rnt.entities.Zona;
import com.mtt.rnt.services.ZonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/zona", produces = MediaType.APPLICATION_JSON_VALUE)
public class ZonaController {

    @Autowired
    ZonaService zonaService;

    @PostMapping("/regiones-ids")
    public ResponseEntity<List<String>> getRegionesIdsFromZonas(@RequestBody List<ZonaDTO> zonas) {
        List<String> regionesIds = zonaService.getRegionesIdsFromZonas(zonas);
        return ResponseEntity.ok(regionesIds);
    }

    @GetMapping("/get-all-zonas")
    public ResponseEntity<Page<BaseDTO>> getAllZonas(@PageableDefault(size = 10) Pageable pageable) {
        Page<BaseDTO> allZonasDto = zonaService.getAllZonas(pageable).map(zona -> (BaseDTO) zona);
        return ResponseEntity.ok(allZonasDto);
    }

    @PostMapping("/comunas-ids")
    public ResponseEntity<List<String>> getComunasIdsFromZonas(@RequestBody List<ZonaDTO> zonasDTO) {
        List<String> comunasIds = zonaService.getComunasIdsfromZonas(zonasDTO);
        return ResponseEntity.ok(comunasIds);
    }

    @PostMapping("/localidades-ids")
    public ResponseEntity<List<Integer>> getLocalidadesIdsFromZonas(@RequestBody List<ZonaDTO> zonasDTO) {
        List<Integer> localidadesIds = zonaService.getLocalidadesIdsFromZonas(zonasDTO);
        return ResponseEntity.ok(localidadesIds);
    }

}
