package com.example.transport.repository;

import com.example.transport.entity.Load;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoadRepository extends JpaRepository<Load, Integer> {
}
