package com.mtt.rnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RepresentanteLegal extends JpaRepository<RepresentanteLegal, Long>, JpaSpecificationExecutor<RepresentanteLegal> {
}
