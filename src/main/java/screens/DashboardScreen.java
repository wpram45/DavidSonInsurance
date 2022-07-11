package screens;

import utils.SizeUtils;

import javax.swing.*;
import java.awt.*;


public class DashboardScreen extends JDialog {
    private JPanel panelMain;
    protected   JButton benefits;
    protected JButton showRateDataButton1;
    protected JButton showBusinessRulesDataButton;
    protected JButton showPlanData;
    protected JLabel headerText;

    Locale locale =new Locale();
    SizeUtils sizeUtil=new SizeUtils();
    public DashboardScreen() {


        setTitle("Dashboard");

        Dimension defaultSize=new Dimension((int) (sizeUtil.getWidth()/2), (int) (sizeUtil.getHeight()/2));

        setContentPane(panelMain);
        this.setSize(defaultSize);
        setLocationRelativeTo(null);
        this.setResizable(false);
        setVisible(false);

       Listeners.addListenersDashboard(this);

        Locale.dashboardScreen=this;



        locale.setLocalizationDashboard();


    }



}