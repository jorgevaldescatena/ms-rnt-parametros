package com.mtt.rnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsableServicio extends JpaRepository<ResponsableServicio, Long>, JpaSpecificationExecutor<ResponsableServicio> {
}
