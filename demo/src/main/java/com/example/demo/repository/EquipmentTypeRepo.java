package com.example.demo.repository;

import com.example.demo.entity.EquipmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentTypeRepo  extends JpaRepository<EquipmentType, Integer> {
}
