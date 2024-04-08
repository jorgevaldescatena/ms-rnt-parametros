package com.mtt.rnt.repository.RntDB;

import com.mtt.rnt.entities.RntDB.ResponsableServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsableServicioRepository extends JpaRepository<ResponsableServicio, Long>, JpaSpecificationExecutor<ResponsableServicio> {
}
