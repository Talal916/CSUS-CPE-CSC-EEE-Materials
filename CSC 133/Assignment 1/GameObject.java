package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil; 
import com.codename1.ui.geom.Point2D;
import java.util.Random;

public class GameObject {

	public Random rand = new Random();
	private Point2D location;
	private int rgb;
	
	public GameObject()
	{
		double x = Math.round((1025.0* rand.nextDouble() * 10.0)) / 10.0;
		double y = Math.round((769.0* rand.nextDouble() * 10.0)) / 10.0;
		
		
		//accounting for edge case of something going off screen
		if( x > 1024)
			x = 1024;
		if(y > 768)
			y = 768;
		 
		location = new Point2D(x,y);
		
	}
	
	public double getLocationX()
	{
		
		return location.getX();
	}
	
	public double getLocationY()
	{
		
		return location.getY();
	}
	
	public Point2D getLocation()
	{
		return location;
	}
	
	public void setLocation(double x, double y)
	{
		location.setX((Math.round(x)*10.0)/10.0);
		location.setY((Math.round(y)*10.0)/10.0);
		
	}
	
	public void setLocation(Point2D newLoc)
	{
		location.setX((Math.round(newLoc.getX())*10.0)/10.0);
		location.setY((Math.round(newLoc.getY())*10.0)/10.0);
		
	}
	
	public int getColor()
	{
		
		return rgb;
	}
	
	public void setColor(int R, int G, int B)
	{
		
	}
	
	public String toString()
	{
		String retval = 
				" Location = " + location.getX() + "," + location.getY() 
				+ " Color = [" + ColorUtil.red(rgb) + "," +
				ColorUtil.green(rgb) +"," +
				ColorUtil.blue(rgb) + "]";
		return retval;
		
	}
	
}
