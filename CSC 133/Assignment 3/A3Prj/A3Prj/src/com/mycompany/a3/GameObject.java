package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil; 
import com.codename1.ui.geom.Point2D;
import java.util.Random;

public class GameObject {

	public Random rand = new Random();
	private Point2D location;
	private int rgb;
	private int size;
	
	public GameObject()
	{

		location = new Point2D(0.0,0.0);
		
	}
	public void setRandLoc(double xMax, double yMax)
	{
		double x = Math.round(((xMax + 1.0) * rand.nextDouble() * 10.0)) / 10.0;
		double y = Math.round(((yMax + 1.0) * rand.nextDouble() * 10.0)) / 10.0;
		
		if (x > xMax) { x = xMax; }
		if (y > yMax) { y = yMax; }
		
		location = new Point2D(x, y);
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
		location.setX(x);
		location.setY(y);
		
	}
	
	public void setLocation(Point2D newLoc)
	{
		location.setX(newLoc.getX());
		location.setY(newLoc.getY());
		
	}
	
	public int getColor()
	{
		
		return rgb;
	}
	public double GetLocationX()
	{
		return location.getX();
	}

	
	public void setColor(int R, int G, int B)
	{
		rgb = ColorUtil.rgb(R,G,B);

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

	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
}
