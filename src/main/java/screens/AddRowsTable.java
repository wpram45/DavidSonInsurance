package screens;

import database.PostgreSQLJDBC;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;

import static screens.Columns.*;


public class AddRowsTable {

   static Object[] rows = new Object[24];

    static  JTable table1;

  static    DefaultTableModel modelim=new DefaultTableModel();

    protected static void addRowsTablePlanAttributes(String tableName) {

        //152 column
        ResultSet rs = PostgreSQLJDBC.selectAllFromTable(tableName);

        rows = new Object[columns_plan_attributes.length];



        try {
            while (rs.next()) {



                for(int i=0;i<columns_plan_attributes.length;i++){
                    rows[i] = rs.getString(columns_plan_attributes[i]);
                }



                modelim.addRow(rows);


            }


            table1.setModel(modelim);


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }




    protected static void addRowsTableRate(String tableName) {

        ResultSet rs = PostgreSQLJDBC.selectAllFromTable(tableName);

        rows = new Object[columns_rate.length];



        try {
            while (rs.next()) {

                for(int i=0;i< columns_rate.length;i++){
                    rows[i] = rs.getString(columns_rate[i]);
                }



                modelim.addRow(rows);


            }


            table1.setModel(modelim);


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }






    protected static void addRowsTableBusinessRules(String tableName) {

        ResultSet rs = PostgreSQLJDBC.selectAllFromTable(tableName);

        rows = new Object[columns_business_rules.length];

        //  System.out.println(columns_business_rules.length);

        try {
            while (rs.next()) {

                for(int i=0;i<columns_business_rules.length;i++){
                    rows[i] = rs.getString(columns_business_rules[i]);
                }



                modelim.addRow(rows);


            }


            table1.setModel(modelim);


        } catch (SQLException e) {
            System.out.println("hata");
            e.printStackTrace();
        }


    }



    protected static void addRowsToTableBenefits_cost_sharing(String tableName) {

        ResultSet rs = PostgreSQLJDBC.selectAllFromTable(tableName);
        rows = new Object[columns_benefits_cost_sharing.length];

        try {


            while (rs.next()) {


                for(int i=0;i< columns_benefits_cost_sharing.length;i++){
                    rows[i] = rs.getString(columns_benefits_cost_sharing[i]);
                }



                modelim.addRow(rows);


            }


            table1.setModel(modelim);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }




}
