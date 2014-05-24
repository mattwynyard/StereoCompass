package stereonet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class StereonetGUI extends JPanel{
  
  private static Stereonet template;
  private GreatCircle gCircle;
  private JButton plotButton;
  private int dip, azimuth;
  private String strDip,strDipDirn;
  private JTextField textFieldDip, textFieldDipDirn;
  private ArrayList<GreatCircle> gCircleArray;
  private JPanel westPanel = new JPanel();
  private JPanel eastPanel = new JPanel();
  private JPanel northPanel = new JPanel();
  private JPanel southPanel = new JPanel();
  private JPanel buttonPanel = new JPanel();
  protected JScrollPane scrollPane = new JScrollPane();
  private DrawingPanel drawPanel = new DrawingPanel();
  protected JTable table = new JTable ();
  
  
  public StereonetGUI(){
    
    setLayout(new BorderLayout());
      
    plotButton = new JButton("Plot");
    textFieldDip = new JTextField(2);
    textFieldDipDirn = new JTextField(3);
    plotButton.addActionListener(new MyListener()); 
    table.setShowGrid(true);
    table.setFillsViewportHeight(true);
    
   
    buttonPanel.add(textFieldDip);
    buttonPanel.add(textFieldDipDirn);
    buttonPanel.add(plotButton);
    
    
    
    scrollPane.add(table);

    buttonPanel.setBackground(Color.blue);
    westPanel.setBackground(Color.white);
    
    
    setPreferredSize(new Dimension (Toolkit.getDefaultToolkit().getScreenSize()));
    
    eastPanel.add(buttonPanel);
    westPanel.add(scrollPane);
    this.add(westPanel, BorderLayout.WEST);
    this.add(drawPanel, BorderLayout.CENTER);
    this.add(eastPanel, BorderLayout.EAST);    
 
  } // end SupportPanel constructor
  
  /** getSteronet method returns reference to Steroent template*/
  public Stereonet getStereonet(){
    
    return template;
    
  }
  
 
  //*****PRIVATE INNER CLASSES***********************//
  
  private class MyListener implements ActionListener{
    
    public void actionPerformed(ActionEvent event){
      
      strDip = textFieldDip.getText();
      strDipDirn = textFieldDipDirn.getText();
      dip = Integer.parseInt(strDip); //convert text field string to int
      azimuth = Integer.parseInt(strDipDirn); //convert text field string to int
      Color colour = Color.red;
      
      if ((dip >= 0 && dip <= 90) && (azimuth >= 0 && azimuth <= 360)) { 
        gCircle = new GreatCircle(dip, azimuth, colour);
        gCircleArray.add(gCircle);
      } else {
        System.out.println("Values are out of range");
      }

      repaint();
      
      } // end action method
    
  } // end MyListener class
    
      /*Class to draw panel uses diplay method from Shape class*/
  
  private class DrawingPanel extends JPanel {
    
    /*Drawing Panel to set background size and colour and intialise Great Circle array and Stereonet template*/
    public DrawingPanel() {
      
      template = new Stereonet(350, 350, 300, Color.gray);
      gCircleArray = new ArrayList<GreatCircle>();
      
      setPreferredSize(new Dimension(200,600));
      setBackground(Color.black);

    }//end DrawingPanel constructor
    
    public void paintComponent(Graphics g){
      
      super.paintComponent(g);
      template.draw(g);
      
      for( int i = 0; i < gCircleArray.size(); i++){
        gCircleArray.get(i).draw(g);
      }
      
       
    } // end paintComponent class
    
  } //end of GraphicsPanel class
  
  }
  
