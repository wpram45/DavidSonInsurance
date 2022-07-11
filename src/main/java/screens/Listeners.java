package screens;

import database.PostgreSQLJDBC;
import org.apache.commons.codec.digest.DigestUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import utils.Localization;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


public class Listeners {

    Localization localization=new Localization();

    Navigate navigate=new Navigate();

    Locale locale=new Locale();


    protected  void addListenersLogin(LoginScreen loginScreen){
        loginScreen.language.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String selectedLanguage=String.valueOf(loginScreen.language.getSelectedItem()).toLowerCase();

                if(selectedLanguage.equals("turkish")){
                    loginScreen.currentLanguage= localization.getTurkish();


                }
                else{
                    loginScreen.currentLanguage= localization.getEnglish();
                }


                locale.setLocalizationLogin(loginScreen);

            }
        });



        loginScreen.loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {


                PostgreSQLJDBC dbOperation=new PostgreSQLJDBC();

                // dbOperation.establishConnection();

                String userName=loginScreen.usernameField.getText();
                String password= String.valueOf(loginScreen.passwordField.getPassword());
                String passwordMD5= DigestUtils.md5Hex(password);





                //if login success
                if(dbOperation.loginOperation(userName,passwordMD5)==true){

                    //System.out.println("login success");

                    navigate.navigateToDashboard();


                }
                // if credentials are wrong  show error message
                else{
                    JOptionPane.showMessageDialog(loginScreen.panelMain,"Login process failed please check your username and password!");
                }


            }
        });

    }







    protected static void addListenersDashboard(DashboardScreen dashboardScreen){
        dashboardScreen.benefits.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                Navigate.navigateToShowTable("benefits_cost_sharing");
            }
        });

        dashboardScreen.showBusinessRulesDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Navigate.navigateToShowTable("business_rules");

            }
        });

        dashboardScreen.showPlanData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                Navigate.navigateToShowTable("plan_attributes");
            }
        });

        dashboardScreen.showRateDataButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Navigate.navigateToShowTable("rate");

            }
        });

    }


    protected   void addListenersShowTable(JButton drawGraph,DrawGraphs drawGraphs){
        drawGraph.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {


                locale.setLocalizationDrawGraphs();
                drawGraphs.setVisible(true);


            }
        });
    }


    protected  void addListenersDrawGraphs(DrawGraphs drawGraphs){


        drawGraphs.drawTimeSeriesChartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                JFreeChart lineChart = ChartFactory.createTimeSeriesChart(
                        "New Plans Selled By Date", "Date", "New Plans Selled", PostgreSQLJDBC.DrawTimeSeriesBySellDate(), true, true, false);



                try {

                    ChartUtils.saveChartAsPNG(new File("TimeSeriesChartPlansSelledByDate.png"), lineChart, 650, 500);
                    JOptionPane.showMessageDialog(drawGraphs.panelMain,"Draw Time Series Chart New Plans Selled By Date saved as  TimeSeriesChartPlansSelledByDate.png");

                } catch (IOException e) {
                    JOptionPane.showMessageDialog(drawGraphs.panelMain,"Draw Time Series Chart New Plans Selled By Date saved as  TimeSeriesChartPlansSelledByDate.png");
                    throw new RuntimeException(e);
                }

            }
        });
        drawGraphs.drawLineChartUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {


                JFreeChart lineChart = ChartFactory.createTimeSeriesChart(
                        "Insurance Expiration Date & Customer Count Time Series", "Expiration Date", "Customer Count", PostgreSQLJDBC.DrawLineChartByExpirationDate(), true, true, false);



                try {

                    ChartUtils.saveChartAsPNG(new File("LineChartExpirationDate.png"), lineChart, 650, 500);
                    JOptionPane.showMessageDialog(drawGraphs.panelMain,"Draw Line Chart Customers By Expiration Date saved as  LineChartExpirationDate.png");

                } catch (IOException e) {
                    JOptionPane.showMessageDialog(drawGraphs.panelMain,"Error while saving Draw Line Chart Customers By Expiration Date saved as  LineChartExpirationDate.png ");
                    throw new RuntimeException(e);
                }
            }
        });

        drawGraphs.drawPieChartNumberButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                JFreeChart pieChart = ChartFactory.createPieChart("Number Of Customers By Market Coverage ", PostgreSQLJDBC.numberOfCustomersByMarketCoverage(),true,true,false);



                try {

                    ChartUtils.saveChartAsPNG(new File("piechartByMarketCoverage.png"), pieChart, 650, 500);
                    JOptionPane.showMessageDialog(drawGraphs.panelMain,"Number Of Customers Market Coverage saved as  piechartByMarketCoverage.png");

                } catch (IOException e) {
                    JOptionPane.showMessageDialog(drawGraphs.panelMain,"Error while saving Number Of Customers Market Coverage saved as  piechartByMarketCoverage.png ");
                    throw new RuntimeException(e);
                }


            }
        });

        drawGraphs.drawPieChartNumberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                JFreeChart pieChart = ChartFactory.createPieChart("Number Of Customers By State", PostgreSQLJDBC.numberOfCustomersByStatePie(),true,true,false);




                try {

                    ChartUtils.saveChartAsPNG(new File("piechartByState.png"), pieChart, 650, 500);
                    JOptionPane.showMessageDialog(drawGraphs.panelMain,"Number Of Customers By State saved as  piechartByState.png");

                } catch (IOException e) {
                    JOptionPane.showMessageDialog(drawGraphs.panelMain,"Error while saving Number Of Customers By State saved as  piechartByState.png ");
                    throw new RuntimeException(e);

                }


            }
        });
    }



    }




