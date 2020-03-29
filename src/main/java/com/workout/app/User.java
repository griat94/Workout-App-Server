package com.workout.app;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User {

    @Id String id;
    String firstName;
    String lastName;
    String email;
    Long phone;
    String username;
    String password;
    
    User() {}
    
    User(String id, String firstName, String lastName, String email, Long phone, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.id = id;
    }
}
