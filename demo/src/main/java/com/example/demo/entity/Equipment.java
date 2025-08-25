package com.example.demo.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Table
public class Equipment {
    @Id
    private String equipmentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipmentTypeId")
    private EquipmentType equipmentType;

    @Column(name = "Equipment Name",columnDefinition = "VARCHAR(150)",nullable = false,unique = true)
    private String equipmentName;

    @Min(1000)
    @Column(name = "Purschase Price",columnDefinition = "DECIMAL(10,2)",nullable = false)
    private double purchasePrice;

    @Min(0)
    @Max(500)
    @Column(name = "Quantity",nullable = false)
    private int quantityAvailable;

    @CreatedDate
    @Column(name = "Purchase Date",nullable = false)
    private LocalDate purchaseDate;

    public Equipment(){}
    public Equipment(String equipmentId, String equipmentName, double purchasePrice, int quantityAvailable,LocalDate localDate) {
        this.equipmentId = equipmentId;
        this.equipmentName = equipmentName;
        this.purchasePrice = purchasePrice;
        this.quantityAvailable = quantityAvailable;
        this.purchaseDate = localDate;

    }
public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
}

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    @Min(1000)
    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(@Min(1000) double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    @Min(0)
    @Max(500)
    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(@Min(0) @Max(500) int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
