package com.mtt.rnt.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtt.rnt.exception.GeneralDataAccessException;
import com.mtt.rnt.repository.utilsDB.TipoVehiculoSGRPTRepository;
import com.mtt.rnt.services.TipoVehiculoSGRPTService;

@Service
public class TipoVehiculoSGRPTServiceImpl implements TipoVehiculoSGRPTService{

    @Autowired
    private TipoVehiculoSGRPTRepository tipoVehiculoSGRPTRepository;

    @Override
    public Integer getIdTipoServicioHomologado(String tipoDesc) throws GeneralDataAccessException {
        try{
            List resultset = tipoVehiculoSGRPTRepository.getIdTipoServicioHomologado(tipoDesc);
            for (Object datoPlano : resultset) {
                Integer dato = (Integer) datoPlano;
                return dato;
            }
        }catch(Exception e){
            throw new GeneralDataAccessException(GeneralDataAccessException.SAVE_ERROR, e);
        }
        return null;

    }

    
    
}
