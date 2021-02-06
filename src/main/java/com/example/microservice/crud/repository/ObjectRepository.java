package com.example.microservice.crud.repository;

import com.example.microservice.crud.domain.GenericObjectDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectRepository extends JpaRepository<GenericObjectDomain, Long> {
}