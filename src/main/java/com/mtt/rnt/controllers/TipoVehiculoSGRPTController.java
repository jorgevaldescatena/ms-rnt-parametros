package com.mtt.rnt.controllers;

import com.mtt.rnt.dto.BaseDTO;
import com.mtt.rnt.dto.ZonaDTO;
import com.mtt.rnt.services.TipoVehiculoSGRPTService;
import com.mtt.rnt.services.ZonaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/tipovehiculo", produces = MediaType.APPLICATION_JSON_VALUE)
public class TipoVehiculoSGRPTController {

    @Autowired
    TipoVehiculoSGRPTService tipoVehiculoSGRPTService;

    @Operation(summary = "Retorna el id del tipo de servicio homologado al consultar por un tipo de descripcion", description = "Retorna el id del tipo de servicio homologado al consultar por un tipoDesc")
    @PostMapping("/get-id-tipo-servicio-homologado")
    public ResponseEntity<Integer> getIdTipoServicioHomologado(@RequestParam String tipoDesc) {
        try{
            Integer idTipoServicioHomologado = tipoVehiculoSGRPTService.getIdTipoServicioHomologado(tipoDesc);
            return ResponseEntity.ok(idTipoServicioHomologado);
        }catch(Exception e){
            return null;
        }
    }

}
