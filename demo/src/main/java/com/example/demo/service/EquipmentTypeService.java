package com.example.demo.service;


import com.example.demo.entity.Equipment;
import com.example.demo.entity.EquipmentType;
import com.example.demo.repository.EquipmentRepo;
import com.example.demo.repository.EquipmentTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentTypeService {
    @Autowired
    EquipmentTypeRepo equipmentTypeRepo;

    public void save(EquipmentType equipmentType){
        equipmentTypeRepo.save(equipmentType);
    }

    public void delete(EquipmentType equipmentType){
        equipmentTypeRepo.delete(equipmentType);
    }

    public EquipmentType findOne(Integer id){
        return equipmentTypeRepo.findById(id).get();
    }


    public List<EquipmentType> findAll(){
        return equipmentTypeRepo.findAll();
    }
}
