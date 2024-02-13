package com.mtt.rnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GenericRepository<T> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {
}
