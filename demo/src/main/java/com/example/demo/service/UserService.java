package com.example.demo.service;


import com.example.demo.entity.Equipment;
import com.example.demo.entity.User;
import com.example.demo.repository.EquipmentRepo;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public void save(User user){
        userRepo.save(user);
    }

    public void delete(User user){
        userRepo.delete(user);
    }

    public User findOne(Integer id){
        return userRepo.findById(id).get();
    }

    public List<User> findAll(){
        return userRepo.findAll();
    }

    public User searchByUsername(String username){
      return userRepo.findUserByUsernameIgnoreCase(username);
    }
}
