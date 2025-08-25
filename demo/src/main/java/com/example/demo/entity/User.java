package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User Id")
    private int userId;

    @Column(name = "UserName",columnDefinition = "VARCHAR(50)",nullable = false,unique = true)
    private String username;

    @Column(name = "Password",columnDefinition = "VARCHAR(255)",nullable = false)
    private String password;

    @Column(name = "Role",nullable = false)
    private int role;

    public User(){}
    public User(String userName, String password, int role) {
        this.username = userName;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}

