package com.workout.app;

import lombok.Data; 

@Data
public class LoginUser {
    
    String username;
    String password;
    
    LoginUser() {}
    
    LoginUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
