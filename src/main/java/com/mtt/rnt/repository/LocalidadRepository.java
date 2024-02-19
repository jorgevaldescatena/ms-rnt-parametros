package com.mtt.rnt.repository;

import com.mtt.rnt.entities.Localidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalidadRepository extends JpaRepository<Localidad, Integer>, JpaSpecificationExecutor<Localidad> {

    @Query("SELECT L FROM Localidad L INNER JOIN FETCH L.comuna C INNER JOIN FETCH C.provincia P INNER JOIN FETCH P.region")
    List<Localidad> findAllWithComunaProvinciaAndRegion();

}
