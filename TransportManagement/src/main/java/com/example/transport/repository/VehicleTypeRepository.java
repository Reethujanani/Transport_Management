package com.example.transport.repository;

import com.example.transport.entity.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface VehicleTypeRepository extends JpaRepository<VehicleType, Integer> {
}
