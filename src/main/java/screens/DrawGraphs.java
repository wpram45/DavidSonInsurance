package screens;

import utils.SizeUtils;

import javax.swing.*;
import java.awt.*;

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




