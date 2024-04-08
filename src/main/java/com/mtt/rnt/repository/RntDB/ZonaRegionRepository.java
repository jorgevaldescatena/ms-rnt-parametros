package com.mtt.rnt.repository.RntDB;

import com.mtt.rnt.entities.RntDB.ZonaRegion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZonaRegionRepository extends JpaRepository<ZonaRegion, Long>, JpaSpecificationExecutor<ZonaRegion> {
    @Query("SELECT DISTINCT zr.idRegion FROM ZonaRegion zr WHERE zr.zona.id IN :zonaIds")
    List<String> findDistinctRegionIdsByZonaIds(@Param("zonaIds") List<Long> zonaIds);

}
