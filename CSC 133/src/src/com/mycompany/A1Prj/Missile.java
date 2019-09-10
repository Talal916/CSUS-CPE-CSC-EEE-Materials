package com.mycompany.A1Prj;

public class Missile extends MoveableGameObject{
	
	private int fuelLevel;						//Init with 10 and counts down
	
	public Missile() {
		fuelLevel = 10;
	}
	public int getfuelLevel()
	{
		return fuelLevel;
	}
	
	public void setfuelLevel(int fuelLevel)
	{
		this.fuelLevel = fuelLevel;
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
		String myDesc = " Color: "+ this.getColor()+ ", Location(X,Y): " + this.getXLocation() + ", " + this.getYLocation() + ", Speed: " + this.getSpeed() + ", Direction: " + this.getDirection() + ", Missile Level: " + this.getfuelLevel();
		return parentDesc + myDesc;				
	}
}
