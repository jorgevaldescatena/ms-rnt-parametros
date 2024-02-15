package com.mtt.rnt.repository;

import com.mtt.rnt.entities.ZonaLocalidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ZonaLocalidadRepository extends JpaRepository<ZonaLocalidad, Long>, JpaSpecificationExecutor<ZonaLocalidad> {
}
