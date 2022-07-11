package database;


import org.jfree.data.general.DefaultPieDataset;

import org.jfree.data.jdbc.JDBCXYDataset;



import java.sql.*;


public class PostgreSQLJDBC {

    private static DefaultPieDataset dataset=new DefaultPieDataset();


    //Number of customers by country


    public  static  JDBCXYDataset DrawLineChartByAge(){

        String url="jdbc:postgresql://localhost:5432/davidsonbank";
        String username="postgres";
        String password="*123admin*";
        Connection c = null;




        try {
            c = DriverManager.getConnection(url, username, password);

            c.setAutoCommit(false);




            String sql="SELECT rateexpirationdate,count(issuerid)  FROM rate group by rateexpirationdate  ; ";

            JDBCXYDataset jdbcxyDataset =new JDBCXYDataset(c);

            jdbcxyDataset.executeQuery(sql);




            ;



            c.close();



            return jdbcxyDataset;
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

    }




    public static JDBCXYDataset DrawTimeSeriesBySellDate(){

        String url="jdbc:postgresql://localhost:5432/davidsonbank";
        String username="postgres";
        String password="*123admin*";
        Connection c = null;




        try {
            c = DriverManager.getConnection(url, username, password);

            c.setAutoCommit(false);






             String sql="SELECT  cast(importdate as date)  , count(isnewplan)   FROM plan_attributes where isnewplan ='New' group by importdate  order by  importdate  ;";

            JDBCXYDataset jdbcxyDataset =new JDBCXYDataset(c);

            jdbcxyDataset.executeQuery(sql);




            ;



            c.close();



            return jdbcxyDataset;
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }



    }

    public  static  JDBCXYDataset DrawLineChartByExpirationDate(){



        String url="jdbc:postgresql://localhost:5432/davidsonbank";
        String username="postgres";
        String password="*123admin*";
        Connection c = null;




        try {
            c = DriverManager.getConnection(url, username, password);

            c.setAutoCommit(false);




           String sql="SELECT rateexpirationdate,count(issuerid)  FROM rate group by rateexpirationdate  order by  rateexpirationdate; ";

          // String sql="SELECT  cast(importdate as date)  , count(isnewplan)   FROM plan_attributes where isnewplan ='New' group by importdate  order by  importdate  ;";

            JDBCXYDataset jdbcxyDataset =new JDBCXYDataset(c);

            jdbcxyDataset.executeQuery(sql);




           ;



            c.close();



            return jdbcxyDataset;
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

    }

    public static  DefaultPieDataset numberOfCustomersByMarketCoverage(){

        dataset=new DefaultPieDataset();

        String url="jdbc:postgresql://localhost:5432/davidsonbank";
        String username="postgres";
        String password="*123admin*";
        Connection c = null;
        Statement stmt = null;


        try {
            c = DriverManager.getConnection(url, username, password);

            c.setAutoCommit(false);

            stmt = c.createStatement();
            //get admin user from userauth table there is only one user
            ResultSet rs = stmt.executeQuery("SELECT  marketcoverage ,count(issuerid) as issuerid FROM plan_attributes  group by marketcoverage ;");



            while (rs.next()) {
                dataset.setValue(rs.getString("marketcoverage"), Double.parseDouble(rs.getString("issuerid")));


            }

            return dataset;
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }


    }
    public static DefaultPieDataset numberOfCustomersByStatePie(){

        dataset=new DefaultPieDataset();
        String url="jdbc:postgresql://localhost:5432/davidsonbank";
        String username="postgres";
        String password="*123admin*";
        Connection c = null;
        Statement stmt = null;


        try {
            c = DriverManager.getConnection(url, username, password);

            c.setAutoCommit(false);

            stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT  statecode,count(issuerid) as customercount FROM business_rules group by statecode  ;");



            while (rs.next()) {
                dataset.setValue(rs.getString("statecode"), Double.parseDouble(rs.getString("customercount")));


            }

            return dataset;
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }







    }


    //return true if data is up-to date
    public static ResultSet selectAllFromTable(String tableName){
        Connection c = null;
        Statement stmt = null;
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




    public boolean loginOperation(String userName, String passwordMD5) {
        //is user admin flag
        boolean isAdmin = false;
        Connection c = null;
        Statement stmt = null;
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
                if (userName.equals(usernameAuth) && passwordAuth.equals(passwordMD5)) {
                    isAdmin = true;
                } else {
                    isAdmin = false;
                }

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



//for testing purpose
/*public  void establishConnection()
        {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/davidsonbank",
                            "postgres", "*123admin*");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
    */
