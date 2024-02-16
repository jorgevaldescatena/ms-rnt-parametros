package com.mtt.rnt.repository;

import com.mtt.rnt.entities.Comuna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComunaRepository extends JpaRepository<Comuna, String>, JpaSpecificationExecutor<Comuna> {

    @Query("SELECT C FROM Comuna C INNER JOIN FETCH C.provincia P INNER JOIN FETCH P.region")
    List<Comuna> findAllWithProvinciaAndRegion();

}
