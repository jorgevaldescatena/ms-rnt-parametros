package com.mtt.rnt.repository;

import com.mtt.rnt.entities.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Long>, JpaSpecificationExecutor<Contacto>{
}
