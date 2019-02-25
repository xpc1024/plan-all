package com.xpc.fit.repository;

import com.xpc.fit.entity.Generate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenerateRepository extends JpaRepository<Generate, Integer> {
}
