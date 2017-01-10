package com.example.Models;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by Nick on 1/5/17.
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @NotBlank(message = "Please enter a username.")
    @Size(min = 5, message = "Please enter a username that has at least 5 characters.")
    private String username;

    @Column(nullable = false)
    @NotBlank(message = "Please enter an email address.")
    @Size(min = 3, message = "An email address must be more than 5 characters long.")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "Please enter your password.")
    @Size(min = 5, message = "A password must have at least 5 characters.")
    private String password;


    public User(int id, String userName, String email, String password){
        this.id = id;
        this.username = userName;
        this.email = email;
        this.password = password;
    }

    public User(){}

    public User(User user) {
        id = user.id;
        email = user.email;
        username = user.username;
        password = user.password;
    }

    public long getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail(){return email;}
    public void setEmail(String email){this.email = email;}

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }






}