package com.mtt.rnt.repository;

import com.mtt.rnt.entities.TipoZona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TipoZonaRepository extends JpaRepository<TipoZona, Long>, JpaSpecificationExecutor<TipoZona> {
}
