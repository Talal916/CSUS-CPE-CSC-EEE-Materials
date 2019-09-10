package com.mycompany.A1Prj;

import com.codename1.charts.util.ColorUtil;

public class Asteroid extends MoveableGameObject {

	private int size;						//size 6-30. and has speed and direction
	
	public Asteroid() {
		this.setColor(ColorUtil.GRAY);
		this.setSize(getRandom(30) + 6);
	}
	
	public int getSize()
	{
		return size;
	}
	
	public void setSize(int size)
	{
		this.size = size;
	}
	
	public void move()
	{
	/*	int angle = 90 - this.getDirection();
		double deltaX = Math.cos(angle)*this.getSpeed();
		double deltaY = Math.sin(angle)*this.getSpeed();		
		float newLocationX = (float) (this.getXLocation() + deltaX);
		float newLocationY = (float) (this.getYLocation() + deltaY);
		
		this.setXLocation(newLocationX);
		this.setYLocation(newLocationY);
	*/
		super.move();
	}
	
	public String toString()
	{
		String parentDesc = super.toString();
		String myDesc = " Color: "+ this.getColor()+ ", Location(X,Y): " + this.getXLocation() + ", " + this.getYLocation() + ", Speed: " + this.getSpeed() + ", Direction: " + this.getDirection() + ", Size: " + this.getSize();
		return parentDesc + myDesc;				
	}
	
}
