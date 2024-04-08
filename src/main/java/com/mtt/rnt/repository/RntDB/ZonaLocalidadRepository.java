package com.mtt.rnt.repository.RntDB;

import com.mtt.rnt.entities.RntDB.ZonaLocalidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZonaLocalidadRepository extends JpaRepository<ZonaLocalidad, Long>, JpaSpecificationExecutor<ZonaLocalidad> {

    @Query("SELECT DISTINCT zl.idLocalidad FROM ZonaLocalidad zl WHERE zl.zona.id IN :zonaIds")
    List<Integer> findDistinctIdLocalidadByZonaIds(@Param("zonaIds") List<Long> zonaIds);

}
