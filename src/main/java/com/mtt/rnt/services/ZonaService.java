package com.mtt.rnt.services;

import com.mtt.rnt.entities.Zona;

import java.util.List;

public interface ZonaService {

    List<String> getRegionesIdsFromZonas(List<Zona> zonas);

}
