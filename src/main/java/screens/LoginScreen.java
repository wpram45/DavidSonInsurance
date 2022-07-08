package screens;
import database.PostgreSQLJDBC;
import org.apache.commons.codec.digest.DigestUtils;
import utils.Localization;
import utils.SizeUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
;


public class LoginScreen extends JDialog {


    private static Localization localization=new Localization();


     public  static HashMap<String,String> currentLanguage=localization.getEnglish();
    private JPanel panelMain;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JComboBox language;
    private JLabel username;
    private JLabel password;
    private JLabel header;
    SizeUtils sizeUtil=new SizeUtils();



    public  LoginScreen(JFrame parent){
        super(parent);
        setTitle("Login Screen");
        setContentPane(panelMain);


//800 width //450 height for n55sf-s1194v
        Dimension defaultSize=new Dimension((int) (sizeUtil.getWidth()/2), (int) (sizeUtil.getHeight()/2));


        this.setSize(defaultSize);

        this.setResizable(false);


        setLocationRelativeTo(null);




        setVisible(true);
       setModal(true);
addActionListeners();



    }
    private void setLanguage(){
        username.setText(currentLanguage.get("username")+":");
        password.setText(currentLanguage.get("password")+":");
        header.setText("Davidson bank "+currentLanguage.get("login screen"));

    }

    public  void addActionListeners(){
        language.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String selectedLanguage=String.valueOf(language.getSelectedItem()).toLowerCase();

                if(selectedLanguage.equals("turkish")){
                    currentLanguage=localization.getTurkish();


                }
                else{
                    currentLanguage=localization.getEnglish();
                }

                setLanguage();

            }
        });



        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {


                PostgreSQLJDBC dbOperation=new PostgreSQLJDBC();

               // dbOperation.establishConnection();

                String userName=usernameField.getText();
                String password= String.valueOf(passwordField.getPassword());
                String passwordMD5= DigestUtils.md5Hex(password);





                //if login success
                if(dbOperation.loginOperation(userName,passwordMD5)==true){

                    //System.out.println("login success");

                    MainNavigator.navigateToDashboard();


                }
                // if credentials are wrong  show error message
                else{
                    JOptionPane.showMessageDialog(panelMain,"Login process failed please check your username and password!");
                }


            }
        });

    }



}
