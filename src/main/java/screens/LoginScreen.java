package screens;
import utils.Localization;
import utils.SizeUtils;
import javax.swing.*;
import java.awt.*;

import java.util.HashMap;



public class LoginScreen extends JDialog {


    protected static Localization localization=new Localization();

    Listeners listeners=new Listeners();

     public  static HashMap<String,String> currentLanguage=localization.getEnglish();
    protected JPanel panelMain;
    protected JTextField usernameField;
    protected JPasswordField passwordField;
    protected JButton loginButton;
    protected JComboBox language;
    protected JLabel username;
    protected JLabel password;
    protected JLabel header;
    SizeUtils sizeUtil=new SizeUtils();



    public  LoginScreen(JFrame parent){
        super(parent);
        setTitle("Login Screen");
        setContentPane(panelMain);
        //800 width //450 height
        Dimension defaultSize=new Dimension((int) (sizeUtil.getWidth()/2), (int) (sizeUtil.getHeight()/2));
        this.setSize(defaultSize);
        this.setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
       setModal(true);
        listeners.addListenersLogin(this);

    }






}
