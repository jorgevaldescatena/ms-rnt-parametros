package com.mtt.rnt.repository.RntDB;

import com.mtt.rnt.entities.RntDB.Recorrido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RecorridoRepository extends JpaRepository<Recorrido, Long>, JpaSpecificationExecutor<Recorrido> {
}
