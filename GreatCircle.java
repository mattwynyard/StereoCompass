package stereonet;

import java.awt.*;

public class GreatCircle{
  
  private int azimuth;
  private int dip;
  private Color colour;
  
  public GreatCircle(){
  
  } // default constructor
  
  public GreatCircle(int dip, int dipDirn, Color colour){
    
    this.dip = dip;
    this.azimuth = dipDirn + 90;
    this.colour = colour;
  }
  
  public void draw(Graphics g){
    
    g.setColor(colour);
    double greatRadius = Stereonet.getRadius() / (Math.cos(Math.toRadians(dip))); // radius of great circle
    double correction = (Stereonet.getRadius() / Math.cos(Math.toRadians(dip))) 
      - (Stereonet.getRadius() * Math.tan(Math.toRadians(dip))); // correction for great circle inflexion from center
    
    int x = (int)Math.round(greatRadius *  Math.cos(Math.toRadians(azimuth)) + Stereonet.getX() - greatRadius
                              - (correction * Math.cos(Math.toRadians(azimuth)))); //convert from polar to cartesian
    int y = (int)Math.round(greatRadius *  Math.sin(Math.toRadians(azimuth)) + Stereonet.getY() - greatRadius 
                              - (correction * Math.sin(Math.toRadians(azimuth)))); //convert from polar to cartesian
    
    g.drawArc(x, y, 2 * (int)Math.round(greatRadius), 2 * (int)Math.round(greatRadius), 
              90 + dip - azimuth, 180 - ( 2 * dip));
 
    int poleRadius = 3;
    double poleX = Stereonet.getRadius() * Math.sin(Math.toRadians(90 - azimuth)) * 
      Math.tan(Math.toRadians(45 - ((90 - dip) / 2)))+ Stereonet.getX() - poleRadius;
    double poleY = Stereonet.getRadius() * Math.cos(Math.toRadians(90 - azimuth)) * 
      Math.tan(Math.toRadians(45 - ((90 - dip) / 2)))+ Stereonet.getY() - poleRadius;
    
    g.fillOval((int)Math.round(poleX), (int)Math.round(poleY), 2 * poleRadius, 2 * poleRadius);
    
  }
  
} // end GreatCircle class
