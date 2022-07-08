package screens;

import utils.SizeUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardScreen extends JDialog {
    private JPanel panelMain;
    private JButton benefits;
    private JButton showRateDataButton1;
    private JButton showBusinessRulesDataButton;
    private JButton showPlanData;
    private JLabel headerText;
    SizeUtils sizeUtil=new SizeUtils();
    public DashboardScreen() {


        setTitle("Dashboard");

        Dimension defaultSize=new Dimension((int) (sizeUtil.getWidth()/2), (int) (sizeUtil.getHeight()/2));

        setContentPane(panelMain);
        this.setSize(defaultSize);
        setLocationRelativeTo(null);
        this.setResizable(false);
       setVisible(false);

       addListeners();




    }

    public void setLocalization(){





     if(LoginScreen.currentLanguage.get("lang").equals("tr")){
         benefits.setText(LoginScreen.currentLanguage.get("Show benefits cost sharing data"));
         showRateDataButton1.setText(LoginScreen.currentLanguage.get("Show rate data"));
         showBusinessRulesDataButton.setText(LoginScreen.currentLanguage.get("Show business rules data"));
         showPlanData.setText(LoginScreen.currentLanguage.get("Show plan attributes data"));
         headerText.setText(LoginScreen.currentLanguage.get("Welcome Admin"));
     }



    }

    private void addListeners(){
        benefits.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                        MainNavigator.navigateToShowTable("benefits_cost_sharing");
            }
        });

        showBusinessRulesDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                MainNavigator.navigateToShowTable("business_rules");

            }
        });

        showPlanData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                MainNavigator.navigateToShowTable("plan_attributes");
            }
        });

        showRateDataButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                MainNavigator.navigateToShowTable("rate");

            }
        });

    }


}