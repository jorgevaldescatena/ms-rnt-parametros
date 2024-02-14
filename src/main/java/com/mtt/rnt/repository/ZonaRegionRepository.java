package com.mtt.rnt.repository;

import com.mtt.rnt.entities.ZonaRegion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ZonaRegionRepository extends JpaRepository<ZonaRegion, Long>, JpaSpecificationExecutor<ZonaRegion> {
}
