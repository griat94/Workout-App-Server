package com.workout.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
    
    static Connection connection = null;
    static String databaseName = "myWorkout";
    static String url = "jdbc:mysql://localhost:3306/" + databaseName + "?serverTimezone=UTC";
    
    static String username = "root";
    static String password = "Gunreet-1994";
    
    public static void startDBConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection(url, username, password);
    }
}
