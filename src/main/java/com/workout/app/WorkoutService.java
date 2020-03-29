package com.workout.app;

import java.sql.SQLException;
import java.util.*; 

public class WorkoutService {
    
    ArrayList<User> users = new ArrayList<User>();
    ArrayList<Workout> workouts = new ArrayList<Workout>(); 
        
    Database db = new Database();

    public void registerNewUser(User user) throws SQLException{
        users.add(user);
        db.writeToUsersTable(user.id, user.firstName, user.lastName, user.email, user.phone, user.username, user.password);
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
    
    public void addWorkout(Workout workout) {
        workouts.add(workout);
    }
    
    public ArrayList<Workout> getWorkouts() {
        return workouts;
    }
    
    public void deleteWorkout(String workoutId) {
        
        for(int counter = 0; counter < workouts.size(); counter++) {
            if(workouts.get(counter).id.equals(workoutId)) {
                workouts.remove(counter);
            }
        }
    }
    
    public void editWorkout(Workout workout, String WorkoutId) {
        
    }
}
