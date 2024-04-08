package com.mtt.rnt.repository.RntDB;

import com.mtt.rnt.entities.RntDB.Tarifa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TarifaRepository extends JpaRepository<Tarifa, Long>, JpaSpecificationExecutor<Tarifa> {
}
