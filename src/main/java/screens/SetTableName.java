package screens;



import static screens.AddRowsTable.*;
import static screens.Columns.*;

public class SetTableName {


    public static void setTableName(String tableName) {

        modelim.setColumnCount(0);
        modelim.setRowCount(0);


        switch (tableName) {

            case "benefits_cost_sharing":

                modelim.setColumnIdentifiers(columns_benefits_cost_sharing);
                addRowsToTableBenefits_cost_sharing(tableName);
                break;

            case "business_rules":
                modelim.setColumnIdentifiers(columns_business_rules);

                addRowsTableBusinessRules(tableName);
                break;
            case "plan_attributes":
                modelim.setColumnIdentifiers(columns_plan_attributes);

                addRowsTablePlanAttributes(tableName);
                break;
            case "rate":
                modelim.setColumnIdentifiers(columns_rate);

                addRowsTableRate(tableName);
                break;



        }


    }



}


