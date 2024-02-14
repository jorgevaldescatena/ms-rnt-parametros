package com.mtt.rnt.repository;

import com.mtt.rnt.entities.Zona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZonaRepository extends JpaRepository<Zona, Long>, JpaSpecificationExecutor<Zona> {

    @Query("SELECT DISTINCT zr.idRegion FROM ZonaRegion zr WHERE zr.zona.id IN :ids")
    List<String> findDistinctRegionIdsByZonaIds(@Param("ids") List<Long> zonasIds);

}
