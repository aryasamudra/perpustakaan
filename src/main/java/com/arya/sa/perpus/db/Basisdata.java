package com.arya.sa.perpus.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Basisdata {
    private static final String URL = "jdbc:mysql://localhost:3306/perpus";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting...");
            con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connected!!");
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        
        return con;
    }
}
