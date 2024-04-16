package com.mtt.rnt.repository.utilsDB;

import com.mtt.rnt.entities.utilsDB.Localidad;
import com.mtt.rnt.entities.utilsDB.TipoVehiculo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoVehiculoSGRPTRepository extends JpaRepository<TipoVehiculo, Integer>, JpaSpecificationExecutor<TipoVehiculo> {

    @Query(value="SELECT ID from NULLID.TIPOVEHICULO ts where ts.DESCRIPCION = :tipoDesc ", nativeQuery = true)
    List<Object> getIdTipoServicioHomologado(@Param("tipoDesc") String tipoDesc);

}
