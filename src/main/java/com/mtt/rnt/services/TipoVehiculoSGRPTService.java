package com.mtt.rnt.services;

import com.mtt.rnt.exception.GeneralDataAccessException;

public interface TipoVehiculoSGRPTService {
    Integer getIdTipoServicioHomologado(String tipoDesc) throws GeneralDataAccessException; 
}
