package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectAllFromTable {
    public static ResultSet selectAllFromTable(String tableName){
        Connection c;
        Statement stmt;
        try {
            Class.forName("org.postgresql.Driver");
            String url="jdbc:postgresql://localhost:5432/davidsonbank";
            String username="postgres";
            String password="*123admin*";
            c = DriverManager.getConnection(url, username, password);
            c.setAutoCommit(false);
            // System.out.println("Database opened successfully");

            stmt = c.createStatement();
            //get admin user from userauth table there is only one user
            ResultSet rs = stmt.executeQuery("SELECT * FROM "+tableName+";");



            return  rs;


        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());

            return null;
        }
        // System.out.println("Select Operation done successfully");

    }
}
