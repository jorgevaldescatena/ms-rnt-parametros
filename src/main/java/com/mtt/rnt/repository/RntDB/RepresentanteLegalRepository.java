package com.mtt.rnt.repository.RntDB;

import com.mtt.rnt.entities.RntDB.RepresentanteLegal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RepresentanteLegalRepository extends JpaRepository<RepresentanteLegal, Long>, JpaSpecificationExecutor<RepresentanteLegal> {
}
