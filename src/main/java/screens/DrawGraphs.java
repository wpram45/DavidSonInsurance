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
    public JPanel panelMain;
    public JButton drawLineChartUsersButton;
    public JButton drawPieChartNumberButton1;
    SizeUtils sizeUtil = new SizeUtils();

    Listeners listeners=new Listeners();

    public DrawGraphs() {
        setTitle("Draw Useful Graphs");


        Dimension defaultSize = new Dimension((int) (sizeUtil.getWidth() / 1.5), (int) (sizeUtil.getHeight() - 100));

        setContentPane(panelMain);
        this.setSize(defaultSize);
        setLocationRelativeTo(null);
        this.setResizable(true);


        //make visible false after
        setVisible(false);


        Locale.drawGraphs = this;


        listeners.addListenersDrawGraphs(this);


    }
}




