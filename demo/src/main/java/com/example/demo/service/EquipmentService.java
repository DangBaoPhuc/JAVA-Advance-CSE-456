package com.example.demo.service;


import com.example.demo.entity.Equipment;
import com.example.demo.repository.EquipmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {

    @Autowired
    EquipmentRepo equipmentRepo;

    public void save(Equipment equipment){
        equipmentRepo.save(equipment);
    }

    public void delete(Equipment equipment){
        equipmentRepo.delete(equipment);
    }

    public Equipment findOne(String id){
        return equipmentRepo.findById(id).get();
    }

    public List<Equipment> findAll(){
        return equipmentRepo.findAll();
    }

}
