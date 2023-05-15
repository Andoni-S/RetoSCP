package clases;

import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;

import javax.swing.*;

public class RotatedLabel extends JLabel {
	
	private double angle;
	private double[] size = new double[2];
	
      public double getAngle() {
    	  return angle;
	}
	public void setAngle(double angle) {
		this.angle = angle;
	}

	public double[] getSizeCustom() {
		return size;
	}
	public void setSizeCustom(double[] size) {
		this.size = size;
	}
	public RotatedLabel(String text) {
         super(text);
         Font font = new Font("Verdana", Font.ITALIC, 10);
         FontMetrics metrics = new FontMetrics(font){};
         Rectangle2D bounds = metrics.getStringBounds(text, null);
         setBounds(0, 0, (int) bounds.getWidth(), (int) bounds.getHeight());
      }
      @Override
      public void paintComponent(Graphics g) {
         Graphics2D gx = (Graphics2D) g;
         gx.rotate(angle, getWidth()/2, getHeight()/2);
         
         if(size[0] != 0 && size[1] != 0)
        	 gx.scale(size[0], size[1]);
         super.paintComponent(g);
      }
	
}
   /*public static void main(String[] args) {
      new RotateJLabelTest();
   }*/
