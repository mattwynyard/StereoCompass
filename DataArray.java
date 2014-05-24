package stereonet;

public class DataArray extends StereonetGUI{
  
  private static Integer[][] dataArray;
  private static String[] columnNames = { "Dip", "Dip Direction"};
  
  public DataArray() {}
  
  public DataArray(Integer[][] dataArray) {
    
    this.dataArray = dataArray;



  } // end 
  

  
  public static Object[][] getDataArray() {
    
    return dataArray;
    
  }
  
    public static String[] getColumnNames() {
    
    return columnNames;
    
  }
  
} //end DataArray class
