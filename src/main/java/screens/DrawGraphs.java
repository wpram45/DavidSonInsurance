package screens;

import database.PostgreSQLJDBC;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import utils.SizeUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class DrawGraphs extends JDialog {
    public JButton drawPieChartNumberButton;
    public JButton drawTimeSeriesChartButton;
    private JPanel panelMain;
    public JButton drawLineChartUsersButton;
    public JButton drawPieChartNumberButton1;
    SizeUtils sizeUtil = new SizeUtils();

    public  DrawGraphs(){
        setTitle("Draw Useful Graphs");


        Dimension defaultSize = new Dimension((int) (sizeUtil.getWidth() / 1.5), (int) (sizeUtil.getHeight() - 100));

        setContentPane(panelMain);
        this.setSize(defaultSize);
        setLocationRelativeTo(null);
        this.setResizable(true);


        //make visible false after
        setVisible(false);


        addListeners();






    }


    public  void setLocalization(){
        if(LoginScreen.currentLanguage.get("lang").equals("tr")){

            drawLineChartUsersButton.setText(LoginScreen.currentLanguage.get("UsersbyExpirationDate"));
            drawPieChartNumberButton.setText(LoginScreen.currentLanguage.get("NumberOfCustomersByState"));
            drawTimeSeriesChartButton.setText(LoginScreen.currentLanguage.get("NewPlansSelledByDate"));
            drawPieChartNumberButton1.setText(LoginScreen.currentLanguage.get("NumberofCustomersByMarketCoverage"));


        }
    }
    private void addListeners(){


        drawTimeSeriesChartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                JFreeChart lineChart = ChartFactory.createTimeSeriesChart(
                        "New Plans Selled By Date", "Date", "New Plans Selled", PostgreSQLJDBC.DrawTimeSeriesBySellDate(), true, true, false);



                try {

                    ChartUtils.saveChartAsPNG(new File("TimeSeriesChartPlansSelledByDate.png"), lineChart, 650, 500);
                    JOptionPane.showMessageDialog(panelMain,"Draw Time Series Chart New Plans Selled By Date saved as  TimeSeriesChartPlansSelledByDate.png");

                } catch (IOException e) {
                    JOptionPane.showMessageDialog(panelMain,"Draw Time Series Chart New Plans Selled By Date saved as  TimeSeriesChartPlansSelledByDate.png");
                    throw new RuntimeException(e);
                }

            }
        });
        drawLineChartUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {


                JFreeChart lineChart = ChartFactory.createTimeSeriesChart(
                        "Insurance Expiration Date & Customer Count Time Series", "Expiration Date", "Customer Count", PostgreSQLJDBC.DrawLineChartByExpirationDate(), true, true, false);



                try {

                    ChartUtils.saveChartAsPNG(new File("LineChartExpirationDate.png"), lineChart, 650, 500);
                    JOptionPane.showMessageDialog(panelMain,"Draw Line Chart Customers By Expiration Date saved as  LineChartExpirationDate.png");

                } catch (IOException e) {
                    JOptionPane.showMessageDialog(panelMain,"Error while saving Draw Line Chart Customers By Expiration Date saved as  LineChartExpirationDate.png ");
                    throw new RuntimeException(e);
                }
            }
        });

        drawPieChartNumberButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                JFreeChart pieChart = ChartFactory.createPieChart("Number Of Customers By Market Coverage ", PostgreSQLJDBC.numberOfCustomersByMarketCoverage(),true,true,false);



                try {

                    ChartUtils.saveChartAsPNG(new File("piechartByMarketCoverage.png"), pieChart, 650, 500);
                    JOptionPane.showMessageDialog(panelMain,"Number Of Customers Market Coverage saved as  piechartByMarketCoverage.png");

                } catch (IOException e) {
                    JOptionPane.showMessageDialog(panelMain,"Error while saving Number Of Customers Market Coverage saved as  piechartByMarketCoverage.png ");
                    throw new RuntimeException(e);
                }


            }
        });

        drawPieChartNumberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                JFreeChart pieChart = ChartFactory.createPieChart("Number Of Customers By State", PostgreSQLJDBC.numberOfCustomersByStatePie(),true,true,false);




                try {

                    ChartUtils.saveChartAsPNG(new File("piechartByState.png"), pieChart, 650, 500);
                    JOptionPane.showMessageDialog(panelMain,"Number Of Customers By State saved as  piechartByState.png");

                } catch (IOException e) {
                    JOptionPane.showMessageDialog(panelMain,"Error while saving Number Of Customers By State saved as  piechartByState.png ");
                    throw new RuntimeException(e);

                }


            }
        });
    }
}
