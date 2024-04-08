package com.mtt.rnt.controllers;

import com.mtt.rnt.dto.LocalidadDTO;
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
@RequestMapping(path = "/api/localidad", produces = MediaType.APPLICATION_JSON_VALUE)
public class LocalidadController {

    @Autowired
    ComunaService comunaService;

    @Operation(summary = "Obtiene todas las localidades", description = "Retorna todas las localidades con sus respectivas comunas, provincias y regiones.")
    @GetMapping("/get-all-localidades")
    public ResponseEntity<List<LocalidadDTO>> getAllLocalidades() {
        List<LocalidadDTO> localidades = comunaService.getAllLocalidades();
        return ResponseEntity.ok(localidades);
    }

}
