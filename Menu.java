package stereonet;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Menu extends JMenuBar {
  
  private String[ ] fileItems = new String[ ] { "New", "Open", "Save", "Exit" };
  private JMenu fileMenu = new JMenu("File");
  private Scanner scan, line;
  private String filePath;
  private Integer[][] dataArray;
  private DataArray data;
  
  public Menu() {
    
    for (int i=0; i < fileItems.length; i++) {
      JMenuItem item = new JMenuItem(fileItems[i]);
      item.addActionListener(new MyMenuListener());
      fileMenu.add(item); 
    }
    
    add(fileMenu);
    
  } // end contructor
  
  
  //***********SUPPORT METHODS **********************************//
  
  /**set datfield filePath to absolute file path selected from file chooser */
  private void setFilePath() {
    
    JFileChooser fc = new JFileChooser();
    fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
    int returnVal = fc.showOpenDialog(null);
    
    if(returnVal == JFileChooser.APPROVE_OPTION) {
      filePath = fc.getSelectedFile().getAbsolutePath();
    }
    
  }
  
  /** returns filePath datafield*/
  private String getFilePath() {
    
    return filePath;
    
  }
  
  public Integer[][] getData(String filePath) {
    
    try {
      scan = new Scanner(new File(filePath));
    } catch (IOException ioex) {
      System.out.println("File Not Found");  
    }
    
    int m = 0;
    int n = 0;
    while(scan.hasNextLine()) {
      m++;
      line = new Scanner(scan.nextLine());
//      while(line.hasNextInt()) {
//       n++;
//      }
    }
    
    System.out.println("Array m = " + m + " n = " +  n);
    Integer[][] dataArray = new Integer[m][n];
    scan.close();
    
    try {
      scan = new Scanner(new File(filePath));
    } catch (IOException ioex) {
      System.out.println("File Not Found" + ioex); 
    }
    
    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        dataArray[i][j] = new Integer(scan.nextInt());
      }
    }
    
    return dataArray;
    
  } //end getData method
  
  public void printData(Integer[][] data){
    
    for (int row = 0; row < data.length; row++) { // for each row 
      for (int col = 0; col < data[row].length; col++) { // for each column in row 
        System.out.print( data[row] [col ] + " " ); // print element 
      } 
      System.out.println(); // move to new line 
    }
    
  }
  
  
  private class MyMenuListener implements ActionListener{
    
    public void actionPerformed(ActionEvent event){
      
      String command = event.getActionCommand();
      
      if (command.equals("Exit")){
        int i = JOptionPane.showConfirmDialog(null, "Do you really want to quit?", "Exit", JOptionPane.YES_NO_OPTION);
        if(i == 0) {
          System.exit(0);
        }
        
      } else if (command.equals("Open")){
        
        setFilePath();
        System.out.println(filePath);
        dataArray = getData(filePath);
        System.out.println("OK");
        printData(dataArray);
        data = new DataArray(dataArray);

      }
      
      
       
      
    } //end actionPerformed
    
  } //end MyListener private class
  
} //end menu class
