package database;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.jdbc.JDBCXYDataset;
import java.sql.*;


public class DrawDataSets implements DataSetDrawable {

    private static DefaultPieDataset dataset=new DefaultPieDataset();


    //Number of customers by country



    public static JDBCXYDataset DrawTimeSeriesBySellDate(){

        String url="jdbc:postgresql://localhost:5432/davidsonbank";
        String username="postgres";
        String password="*123admin*";
        Connection c ;




        try {
            c = DriverManager.getConnection(url, username, password);

            c.setAutoCommit(false);






             String sql="SELECT  cast(importdate as date)  , count(isnewplan)   FROM plan_attributes where isnewplan ='New' group by importdate  order by  importdate  ;";

            JDBCXYDataset jdbcxyDataset =new JDBCXYDataset(c);

            jdbcxyDataset.executeQuery(sql);








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
        Connection c ;




        try {
            c = DriverManager.getConnection(url, username, password);

            c.setAutoCommit(false);




           String sql="SELECT rateexpirationdate,count(issuerid)  FROM rate group by rateexpirationdate  order by  rateexpirationdate; ";

          // String sql="SELECT  cast(importdate as date)  , count(isnewplan)   FROM plan_attributes where isnewplan ='New' group by importdate  order by  importdate  ;";

            JDBCXYDataset jdbcxyDataset =new JDBCXYDataset(c);

            jdbcxyDataset.executeQuery(sql);








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
        Connection c ;
        Statement stmt;


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
        Connection c ;
        Statement stmt;


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





}


