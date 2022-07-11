package screens;


public class Locale {


    static   DashboardScreen dashboardScreen;

    static  DrawGraphs drawGraphs;

    public    void setLocalizationDashboard(){

        if(LoginScreen.currentLanguage.get("lang").equals("tr")){
            dashboardScreen.benefits.setText(LoginScreen.currentLanguage.get("Show benefits cost sharing data"));
            dashboardScreen.showRateDataButton1.setText(LoginScreen.currentLanguage.get("Show rate data"));
            dashboardScreen.showBusinessRulesDataButton.setText(LoginScreen.currentLanguage.get("Show business rules data"));
            dashboardScreen.showPlanData.setText(LoginScreen.currentLanguage.get("Show plan attributes data"));
            dashboardScreen.headerText.setText(LoginScreen.currentLanguage.get("Welcome Admin"));
        }

    }

    public void setLocalizationLogin(LoginScreen loginScreen){
        loginScreen.username.setText(loginScreen.currentLanguage.get("username")+":");
        loginScreen.password.setText(loginScreen.currentLanguage.get("password")+":");
        loginScreen.header.setText("Davidson bank "+loginScreen.currentLanguage.get("login screen"));
    }


    public  void setLocalizationDrawGraphs(){

        if(LoginScreen.currentLanguage.get("lang").equals("tr")){

            drawGraphs.drawLineChartUsersButton.setText(LoginScreen.currentLanguage.get("UsersbyExpirationDate"));
           drawGraphs.drawPieChartNumberButton.setText(LoginScreen.currentLanguage.get("NumberOfCustomersByState"));
            drawGraphs.drawTimeSeriesChartButton.setText(LoginScreen.currentLanguage.get("NewPlansSelledByDate"));
            drawGraphs.drawPieChartNumberButton1.setText(LoginScreen.currentLanguage.get("NumberofCustomersByMarketCoverage"));


        }


    }

}
