package com.workout.app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*; 

public class WorkoutService {
    
    ArrayList<User> users = new ArrayList<>();
    ArrayList<Workout> workouts = new ArrayList<>(); 
        
    Database db = new Database();
    static Connection connection = null;

    public void registerNewUser(User user) throws SQLException{
        users.add(user);
        db.writeToUsersTable(user.id, user.firstName, user.lastName, user.email, user.phone, user.username, user.password);
    }
    
    public ArrayList<User> getUsers() {
        return users;
    }
    
    public String[] attemptLogin(LoginUser loginUser) throws SQLException {
        boolean credentialsMatch = false;
        String[] output = new String[2];
        
        for(int counter = 0; counter < users.size(); counter++) {
            if (users.get(counter).username.toLowerCase().equals(loginUser.username.toLowerCase())) {
                if (users.get(counter).password.equals(loginUser.password)) {
                    credentialsMatch = true;
                }
            }
        }
        
        if(credentialsMatch) {
            db.searchUserTableByUsername(loginUser.username, output);
        } else {
            output[0] = "false";
        }
       
        
        return output;
    }  
    
    public void addWorkout(Workout workout) throws SQLException {
        workouts.add(workout);
        db.writeToWorkoutsTable(workout.id, workout.workoutType, workout.exerciseName, workout.weight, workout.sets, workout.repsPerSet, workout.userId);
    }
    
    public ArrayList<Workout> getWorkouts(String userId) throws SQLException {
        return db.getWorkoutsByUserId(userId);
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
