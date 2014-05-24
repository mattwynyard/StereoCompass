package stereonet;

public class Pole {
  
  private GreatCircle plane;
  private int trend, plunge;
  
  public Pole (GreatCircle plane) {
    
    this.plane = plane;
    
  }
  
//  public void draw(Graphics g) {
//    
//    int poleRadius = 3;
//    
//    double poleX = template.getRadius() * Math.sin(Math.toRadians(90 - plane.getAzimuth())) * 
//      Math.tan(Math.toRadians(45 - ((90 - plane.getDip()) / 2))) + template.getX() - poleRadius;
//    double poleY = template.getRadius() * Math.cos(Math.toRadians(90 - plane.getAzimuth())) * 
//      Math.tan(Math.toRadians(45 - ((90 - dip) / 2)))+ template.getY() - poleRadius;
//    System.out.println("poleX = " + poleX);
//    System.out.println("poleY = " + poleY);
//    
//    g.fillOval((int)Math.round(poleX), (int)Math.round(poleY), 2 * poleRadius, 2 * poleRadius);
//    
//  }
  
}
