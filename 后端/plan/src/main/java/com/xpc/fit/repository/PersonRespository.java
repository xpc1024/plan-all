package com.xpc.fit.repository;

import com.xpc.fit.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRespository extends JpaRepository<Person,Integer>{
}
