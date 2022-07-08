package utils;

import screens.LoginScreen;

import javax.swing.*;
import java.awt.*;

public class SizeUtils {

   private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  private  double width = screenSize.getWidth();
   private  double height = screenSize.getHeight();


    //set component size relative to screenSize*multiplier
    public void setComponentSize(JComponent component, double multiplier ){

        int screenWidth=Integer.valueOf((int) this.getWidth());
        int screenHeight=Integer.valueOf((int) this.getHeight());

        int width= (int) (screenWidth*multiplier);
        int height = (int) (screenHeight*multiplier);

        Dimension dimension=new Dimension(width,height);

        component.setSize(dimension);

    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
