package com.mtt.rnt.repository;

import com.mtt.rnt.entities.Reglamentacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ReglamentacionRepository extends JpaRepository<Reglamentacion, Long>, JpaSpecificationExecutor<Reglamentacion> {
}
