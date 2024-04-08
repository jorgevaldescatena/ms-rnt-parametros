package com.mtt.rnt.services;

import com.mtt.rnt.dto.ComunaDTO;
import com.mtt.rnt.dto.LocalidadDTO;
import com.mtt.rnt.entities.utilsDB.Comuna;
import com.mtt.rnt.entities.utilsDB.Localidad;

import java.util.List;

public interface ComunaService {

    /** Recupera todas las instancias de Comuna, incluyendo sus relaciones con Provincia y Región.
     *
     * @return List<Comuna> - Lista de todas las comunas.
     */
    List<ComunaDTO> getAllComunas();

    /** Recupera todas las instancias de Localidad, incluyendo sus relaciones con Comuna, Provincia y Región.
     *
     * @return List<Localidad> - Lista de todas las localidades.
     */
    List<LocalidadDTO> getAllLocalidades();

}
