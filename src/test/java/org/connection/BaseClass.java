package org.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseClass {
    public static Connection con;

    public Connection setUp() throws SQLException {
        try {
            String url = "jdbc:mysql://localhost:3306/dbTest";
            String userName = "exam";
            String password = "welcome";
            con = DriverManager.getConnection(url, userName, password);
        }
        catch (SQLException e){
            System.out.println(e.getErrorCode());
            System.out.println(e.getSQLState());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return con;
    }
}
