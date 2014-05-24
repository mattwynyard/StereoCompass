package stereonet;

import java.awt.*;
import javax.swing.*;

public class StereonetApp{
  
  public static void main(String [] args){
    
    JFrame frame = new JFrame("Stereonet version 1.0");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new StereonetGUI());
    frame.setJMenuBar(new Menu());
    frame.pack();
    frame.setVisible(true);
  
  } //end of main method

} //end of application class
