package vn.edu.eiu.fecse456studentid.model;

import jakarta.persistence.*;

import java.time.Year;

@Entity
@Table(name = "tbl_user")
public class User {

    @Id
    @Column(name = "User ID")
    private int userId;

    @Column(name = "User Name",columnDefinition = "VARCHAR(50)")
    private String userName;

    @Column(name = "Password",columnDefinition = "VARCHAR(255)")
    private String password;

    @Column(name = "Role")
    private int role;

}
