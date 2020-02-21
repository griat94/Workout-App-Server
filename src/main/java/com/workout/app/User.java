package com.workout.app;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User {

    private @Id UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private Long phone;
    String username;
    String password;
    
    User() {}
    
    User(UUID id, String firstName, String lastName, String email, Long phone, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.id = id;
    }
}
