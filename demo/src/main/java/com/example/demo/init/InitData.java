package com.example.demo.init;

import com.example.demo.entity.Equipment;
import com.example.demo.entity.EquipmentType;
import com.example.demo.entity.User;
import com.example.demo.service.EquipmentService;
import com.example.demo.service.EquipmentTypeService;
import com.example.demo.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Component
public class InitData implements CommandLineRunner {
    @Autowired
    public UserService userService;

    @Autowired
    EquipmentTypeService equipmentTypeService;

    @Autowired
    EquipmentService equipmentService;


    @Override
    public void run(String... args) throws Exception {

        EquipmentType equipmentType = new EquipmentType(1,"Laptop","Portable computers used for teaching/research");
        EquipmentType equipmentType1 = new EquipmentType(2,"Projector","Devices used for classroom presentations");
        EquipmentType equipmentType2 = new EquipmentType(3,"Printer","Printers for administrative/student use");
        EquipmentType equipmentType3= new EquipmentType(4,"Microscope","Lab equipment for biology/medical courses");



        Equipment equipment = new Equipment("EQ00000001","Dell Latitude 5420",1500.00,20, LocalDate.parse("2025-08-21 08:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        Equipment equipment1 = new Equipment("EQ00000002","HP ProBook 450 G8",1350.00,15, LocalDate.parse("2025-08-21 08:05:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        Equipment equipment2 = new Equipment("EQ00000003","Epson EB-X06 Projector",2200.00,5, LocalDate.parse("2025-08-21 08:10:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        Equipment equipment3 = new Equipment("EQ00000004","BenQ MW550 Projector",2500.00,3, LocalDate.parse("2025-08-21 08:15:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        Equipment equipment4 = new Equipment("EQ00000005","Canon LBP2900 Printer",1200.00,10, LocalDate.parse("2025-08-21 08:20:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        Equipment equipment5 = new Equipment("EQ00000006","Olympus CX23 Microscope",5000.00,7, LocalDate.parse("2025-08-21 08:25:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        equipmentType.addEquipment(equipment);
        equipmentType.addEquipment(equipment1);
        equipmentType1.addEquipment(equipment2);
        equipmentType1.addEquipment(equipment3);
        equipmentType2.addEquipment(equipment4);
        equipmentType3.addEquipment(equipment5);

        equipmentTypeService.save(equipmentType);
        equipmentTypeService.save(equipmentType1);
        equipmentTypeService.save(equipmentType2);
        equipmentTypeService.save(equipmentType3);

        User user = new User("admin","admin",1);
        User user1 = new User("staff01","staff01",2);
        User user2 = new User("customer","customer",3);

        userService.save(user);
        userService.save(user1);
        userService.save(user2);

    }
}
