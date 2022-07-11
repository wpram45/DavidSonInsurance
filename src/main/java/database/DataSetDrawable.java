package database;

import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.jdbc.JDBCXYDataset;

public interface DataSetDrawable {

   static DefaultPieDataset dataset=new DefaultPieDataset();

   static JDBCXYDataset DrawTimeSeriesBySellDate() {
        return null;
    }


    static  JDBCXYDataset DrawLineChartByExpirationDate(){
       return null;
    }

    static DefaultPieDataset numberOfCustomersByMarketCoverage(){
       return null;
    }

    static DefaultPieDataset numberOfCustomersByStatePie(){
       return null;
    }

}

