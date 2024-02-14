package com.mtt.rnt.repository;

import com.mtt.rnt.entities.Tarifa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TarifaRepository extends JpaRepository<Tarifa, Long>, JpaSpecificationExecutor<Tarifa> {
}
