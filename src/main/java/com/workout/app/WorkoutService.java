package com.workout.app;

import java.util.*; 

public class WorkoutService {    
    ArrayList<User> users = new ArrayList<User>();
    
    public void registerNewUser(User user){
        users.add(user);
    }
    
    public ArrayList<User> getUsers() {
        return users;
    }
    
    public boolean attemptLogin(LoginUser loginUser) {
        boolean credentialsMatch = false;
        
        for(int counter = 0; counter < users.size(); counter++) {
            if (users.get(counter).username.toLowerCase().equals(loginUser.username.toLowerCase())) {
                if (users.get(counter).password.equals(loginUser.password)) {
                    credentialsMatch = true;
                }
            }
        }
        
        return credentialsMatch;
    }    
}
