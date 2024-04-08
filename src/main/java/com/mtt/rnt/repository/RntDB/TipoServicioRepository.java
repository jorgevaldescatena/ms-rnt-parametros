package com.mtt.rnt.repository.RntDB;

import com.mtt.rnt.entities.RntDB.TipoServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TipoServicioRepository extends JpaRepository<TipoServicio, Long>, JpaSpecificationExecutor<TipoServicio> {
}
