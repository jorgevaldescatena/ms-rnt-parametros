package com.mtt.rnt.repository;

import com.mtt.rnt.entities.TipoServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TipoServicioRepository extends JpaRepository<TipoServicio, Long>, JpaSpecificationExecutor<TipoServicio> {
}
