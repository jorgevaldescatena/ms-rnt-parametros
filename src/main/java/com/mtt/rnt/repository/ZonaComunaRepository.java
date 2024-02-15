package com.mtt.rnt.repository;

import com.mtt.rnt.entities.ZonaComuna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZonaComunaRepository extends JpaRepository<ZonaComuna, Long>, JpaSpecificationExecutor<ZonaComuna> {

    @Query("SELECT DISTINCT zc.idComuna FROM ZonaComuna zc WHERE zc.zona.id IN :zonaIds")
    List<String> findDistinctIdComunaByZonaIds(@Param("zonaIds") List<Long> zonaIds);

}
