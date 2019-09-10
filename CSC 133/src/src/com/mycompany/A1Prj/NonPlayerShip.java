package com.mycompany.A1Prj;

import com.codename1.charts.util.ColorUtil;

public class NonPlayerShip extends Ship {

	private int size;
	
	public NonPlayerShip() {
		if ((getRandom(10) % 2) == 0) {
			this.setSize(10);
		}else {
			this.setSize(20);
		}
		this.setColor(ColorUtil.MAGENTA);
		this.setMissileCount(10);
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
	/*
		int angle = 90 - this.getDirection();
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
		String myDesc = " Color: "+ this.getColor()+ ", Location(X,Y): " + this.getXLocation() + ", " + this.getYLocation() + ", Speed: " + this.getSpeed() + ", Direction: " + this.getDirection() + ", Missile: " + this.getMissileCount();
		return parentDesc + myDesc;				
	}
}
