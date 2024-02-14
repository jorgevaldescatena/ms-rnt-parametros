package com.mtt.rnt.repository;

import com.mtt.rnt.entities.VehiculoServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VehiculoServicioRepository extends JpaRepository<VehiculoServicio, Long>, JpaSpecificationExecutor<VehiculoServicio> {
}
