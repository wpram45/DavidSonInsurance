package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginOperation {

    public boolean loginOperation(String userName, String passwordMD5) {
        //is user admin flag
        boolean isAdmin = false;
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
            ResultSet rs = stmt.executeQuery("SELECT * FROM userauth where username='admin';");
            while (rs.next()) {

                String usernameAuth = rs.getString("username");
                //get md5 hashed value of password from database - userauth table
                String passwordAuth = rs.getString("password");



                //       System.out.println("username in userAuth = " + usernameAuth);
                //     System.out.println("password in userAuth = " + passwordAuth);

                //if credentials are true set isAdmin to true -- otherwise set isAdmin to false
                isAdmin = userName.equals(usernameAuth) && passwordAuth.equals(passwordMD5);

            }
            rs.close();
            stmt.close();
            c.close();


        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            //System.exit(0);
        }
        // System.out.println("login Operation done successfully");

        return isAdmin;
    }
}
