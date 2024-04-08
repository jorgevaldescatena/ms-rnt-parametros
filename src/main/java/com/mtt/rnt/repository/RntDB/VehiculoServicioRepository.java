package com.mtt.rnt.repository.RntDB;

import com.mtt.rnt.entities.RntDB.VehiculoServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoServicioRepository extends JpaRepository<VehiculoServicio, Long>, JpaSpecificationExecutor<VehiculoServicio> {
}
