package com.mtt.rnt.dto;

import com.mtt.rnt.entities.RntDB.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZonaDTO extends BaseDTO{

        private Long id;
        private String nombre;
        private String descriptor;
        private String idRegion;
        private Long idOld;
        private Boolean activa;
        private TipoZona tipoZona;
        private TipoSubsidio tipoSubsidio;
        //private List<String> servicios;
        private List<String> regiones;
        private List<String> comunas;
        private List<String> localidades;
}
