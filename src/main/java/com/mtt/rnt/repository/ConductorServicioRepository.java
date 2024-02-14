package com.mtt.rnt.repository;

import com.mtt.rnt.entities.ConductorServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ConductorServicioRepository extends JpaRepository<ConductorServicio, Long>, JpaSpecificationExecutor<ConductorServicio> {
}
