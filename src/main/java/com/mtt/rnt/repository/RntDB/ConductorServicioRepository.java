package com.mtt.rnt.repository.RntDB;

import com.mtt.rnt.entities.RntDB.ConductorServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ConductorServicioRepository extends JpaRepository<ConductorServicio, Long>, JpaSpecificationExecutor<ConductorServicio> {
}
