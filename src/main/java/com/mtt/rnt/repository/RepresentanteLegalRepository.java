package com.mtt.rnt.repository;

import com.mtt.rnt.entities.RepresentanteLegal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RepresentanteLegalRepository extends JpaRepository<RepresentanteLegal, Long>, JpaSpecificationExecutor<RepresentanteLegal> {
}
