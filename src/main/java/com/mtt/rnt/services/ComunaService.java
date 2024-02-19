package com.mtt.rnt.services;

import com.mtt.rnt.entities.Comuna;
import com.mtt.rnt.entities.Localidad;

import java.util.List;

public interface ComunaService {

    /** Recupera todas las instancias de Comuna, incluyendo sus relaciones con Provincia y Región.
     *
     * @return List<Comuna> - Lista de todas las comunas.
     */
    List<Comuna> getAllComunas();

    /** Recupera todas las instancias de Localidad, incluyendo sus relaciones con Comuna, Provincia y Región.
     *
     * @return List<Localidad> - Lista de todas las localidades.
     */
    List<Localidad> getAllLocalidades();

}
