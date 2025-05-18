package designPattern.ObjectPoolDesignPattern;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private Connection mysqlConnection;

    public DBConnection() {
        try {
            mysqlConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbname", "username", "password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return mysqlConnection;
    }
}

