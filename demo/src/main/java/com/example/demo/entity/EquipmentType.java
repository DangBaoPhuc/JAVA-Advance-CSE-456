package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Table
public class EquipmentType {

    @Id
    @Column(name ="Equipment Type Id" )
    private int equipmentTypeId;

    @Column(name = "Type Name",columnDefinition = "VARCHAR(100)",nullable = false,unique = true)
    private String typeName;

    @OneToMany(mappedBy = "equipmentType", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Equipment> equipments = new ArrayList<>();



    @Column(name = "Description",columnDefinition = "VARCHAR(255)",nullable = true)
    private String description;

    public EquipmentType() {
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getEquipmentTypeId() {
        return equipmentTypeId;
    }

    public void setEquipmentTypeId(int equipmentTypeId) {
        this.equipmentTypeId = equipmentTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }

    public EquipmentType(int equipmentTypeId, String typeName, String description) {
        this.equipmentTypeId = equipmentTypeId;
        this.typeName = typeName;
        this.description = description;
    }

    public void addEquipment(Equipment equipment) {
        this.equipments.add(equipment);
        equipment.setEquipmentType(this);
    }

    public void removeEquipment(Equipment equipment) {
        equipments.remove(equipment);
        equipment.setEquipmentType(null);
    }


}
