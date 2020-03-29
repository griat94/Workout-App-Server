package com.workout.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
        insertStatement.setString(5, phone.toString());
        insertStatement.setString(6, username);
        insertStatement.setString(7, password);
        
        insertStatement.executeUpdate();
    }
}
    
