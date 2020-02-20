
package com.workout.app;

import java.util.ArrayList;


public class WorkoutService {
    ArrayList<User> users = new ArrayList<User>();
    
    public void registerNewUser(User user){
        users.add(user);
    }
    
    public ArrayList<User> getUsers() {
        return users;
    }
}