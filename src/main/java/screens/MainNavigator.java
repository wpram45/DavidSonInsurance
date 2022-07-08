package screens;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainNavigator extends JFrame implements ActionListener
{

    static  final ShowTable showTable=new ShowTable();
    static final    LoginScreen login=new LoginScreen(null);

    static  final    DashboardScreen dashboardScreen=new DashboardScreen();
    CardLayout card;

    Container c;



    MainNavigator()
    {
        c = getContentPane();
        //create a CardLayout object with 30 hor spaces and 20 ver spaces
        card = new CardLayout(30,20);
        c.setLayout(card);

        c.add("login",login);


        c.add("dashboard",dashboardScreen);



    }

    public static   void navigateToDashboard(){

        //hide login screen
        //show dashboard screen
        login.setVisible(false);
        dashboardScreen.setVisible(true);
        dashboardScreen.setLocalization();


    }

    public static   void navigateToShowTable(String tableName){


        //show showtable screen
        showTable.setTableName(tableName);

        showTable.setVisible(true);




    }

    public   void   actionPerformed(ActionEvent e) {
        card.next(c);
    }

    public static void main(String[] args) {
        MainNavigator frame = new MainNavigator();
      frame.setSize(300,300);
      frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}