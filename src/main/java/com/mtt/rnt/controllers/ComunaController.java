package com.mtt.rnt.controllers;

import com.mtt.rnt.dto.ComunaDTO;
import com.mtt.rnt.entities.utilsDB.Comuna;
import com.mtt.rnt.services.ComunaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/comuna", produces = MediaType.APPLICATION_JSON_VALUE)
public class ComunaController {

    @Autowired
    ComunaService comunaService;

    @Operation(summary = "Obtiene todas las comunas", description = "Retorna todas las comunas con sus respectivas provincias y regiones.")
    @GetMapping("/get-all-comunas")
    public ResponseEntity<List<ComunaDTO>> getAllComunas() {
        List<ComunaDTO> comunas = comunaService.getAllComunas();
        return ResponseEntity.ok(comunas);
    }

}
