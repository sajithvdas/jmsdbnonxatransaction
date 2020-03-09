package com.ibsplc.nonxatransaction.jmsdatabasenonxatxpoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibsplc.nonxatransaction.jmsdatabasenonxatxpoc.model.Edifact;

@Repository
public interface EdifactRepository extends JpaRepository<Edifact, Long> {

}
