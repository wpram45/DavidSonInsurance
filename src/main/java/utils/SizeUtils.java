package utils;

import lombok.Getter;
import lombok.ToString;

import javax.swing.*;
import java.awt.*;


@Getter
@ToString
public class SizeUtils {

   private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  private  double width = screenSize.getWidth();
   private  double height = screenSize.getHeight();



}
