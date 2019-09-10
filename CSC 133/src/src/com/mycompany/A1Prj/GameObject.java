package com.mycompany.A1Prj;

import java.util.Random;

public class GameObject {
	private double locationX;
	private double locationY;						// X and Y- range 0.0 to 1024.0 and 0.0 to 768.0, respectively
	private int color;				
	
	public GameObject() {
		this.setXLocation(getRandom(1024));
		this.setYLocation(getRandom(768));
	}
	public double getXLocation()
	{
		return locationX;
	}
	
	public double getYLocation()
	{
		return locationY;
	}
	public int getColor()
	{
		return color;
	}
	
	public void setXLocation(double locationX)
	{
		this.locationX = locationX;
	}
	
	public void setYLocation(double locationY)
	{
		this.locationY = locationY;
	}
	public void setColor(int color)
	{
		this.color = color;
	}
	
	public int getRandom(int range) {
		Random randNum = new Random();
		return randNum.nextInt(range);
	}
	
		

}
