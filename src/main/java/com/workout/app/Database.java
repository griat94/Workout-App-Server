package com.workout.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Database {
    
    static Connection connection = null;
    static String databaseName = "myWorkout";
    static String url = "jdbc:mysql://localhost:3306/" + databaseName + "?serverTimezone=UTC";
    
    static String username = "root";
    static String password = "Gunreet-1994";
    
    public static void startDBConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection(url, username, password);
    }
    
    public void writeToUsersTable(String id, String firstName, String lastName, String email, Long phone, String username, String password) throws SQLException {
        String sql = "INSERT INTO `myWorkout`.`Users` VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement insertStatement = connection.prepareStatement(sql);
        insertStatement.setString(1, id);
        insertStatement.setString(2, firstName);
        insertStatement.setString(3, lastName);
        insertStatement.setString(4, email);
        insertStatement.setLong(5, phone);
        insertStatement.setString(6, username);
        insertStatement.setString(7, password);
        
        insertStatement.executeUpdate();
    }
    
    public void writeToWorkoutsTable(String id, String workoutType, String exerciseName, int weight, int sets, int repsPerSet, String userId) throws SQLException {
        String sql = "INSERT INTO `myWorkout`.`Workouts` VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement insertStatement = connection.prepareStatement(sql);
        insertStatement.setString(1, id);
        insertStatement.setString(2, workoutType);
        insertStatement.setString(3, exerciseName);
        insertStatement.setInt(4, weight);
        insertStatement.setInt(5, sets);
        insertStatement.setInt(6, repsPerSet);
        insertStatement.setString(7, userId);
        
        insertStatement.executeUpdate();
    }
    
    public void searchUserTableByUsername(String username, String[] output) throws SQLException {
        String sql = "SELECT * FROM `myWorkout`.`Users` WHERE `username`='" + username + "'";
        
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
            
        while (result.next()){
            String firstName = result.getString("firstName");
            String id = result.getString("id");
            
            output[0] = id;
            output[1] = firstName; 
        }            
    } 
    
    public ArrayList<Workout> getWorkoutsByUserId(String userId) throws SQLException {
        ArrayList<Workout> workouts = new ArrayList<>();
        
        String sql = "SELECT * FROM `myWorkout`.`Workouts` WHERE `userId`='" + userId + "'";
        
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        
        while (result.next()) {
            workouts.add(new Workout(result.getString("workoutType"), result.getString("exerciseName"), result.getInt("sets"), result.getInt("repsPerSet"), result.getString("id"), result.getInt("weight"), result.getString("userId")));
        }
        
        return workouts;
    }
    
    public void editWorkoutByWorkoutId(Workout workout, String workoutId) throws SQLException {
        String sql = "UPDATE `myWorkout`.`Workouts` SET `workoutType`=?, `exerciseName`=?, `weight`=?, `sets`=?, `repsPerSet`=? WHERE `id`='" + workoutId + "'";
        
        PreparedStatement updateStatement = connection.prepareStatement(sql);
        updateStatement.setString(1, workout.workoutType);
        updateStatement.setString(2, workout.exerciseName);
        updateStatement.setInt(3, workout.weight);
        updateStatement.setInt(4, workout.sets);
        updateStatement.setInt(5, workout.repsPerSet);
        
        updateStatement.executeUpdate();
    }
    
    public void deleteWorkoutByWorkoutId(String workoutId) throws SQLException {
        String sql = "DELETE FROM `myWorkout`.`Workouts` WHERE `id`='" + workoutId + "'";
        
        PreparedStatement deleteStatement = connection.prepareStatement(sql);
        
        deleteStatement.executeUpdate();
    }
  

}
    
