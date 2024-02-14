package com.mtt.rnt.repository;

import com.mtt.rnt.entities.ZonaComuna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ZonaComunaRepository extends JpaRepository<ZonaComuna, Long>, JpaSpecificationExecutor<ZonaComuna> {
}
