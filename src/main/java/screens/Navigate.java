package screens;

import static screens.MainNavigator.*;

public class Navigate {

    Locale locale =new Locale();

    static ShowTable showTable=new ShowTable();


    public   void navigateToDashboard(){

        //hide login screen
        //show dashboard screen
        login.setVisible(false);
        dashboardScreen.setVisible(true);
        locale.setLocalizationDashboard();


    }
    public static   void navigateToShowTable(String tableName){

        //show showtable screen
        SetTableName.setTableName(tableName);

        showTable.setVisible(true);

    }

}
