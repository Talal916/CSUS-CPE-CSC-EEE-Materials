package com.mycompany.A1Prj;

import com.codename1.charts.util.ColorUtil;

public class PlayerShip extends Ship implements ISteerable {
	public PlayerShip() {
		this.setXLocation(getXLocation()/2);
		this.setYLocation(getYLocation()/2);
		this.setSpeed(0);
		this.setDirection(0);
		super.setMissileCount(10);
		this.setColor(ColorUtil.BLUE);
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
		String myDesc = " Color: "+ this.getColor()+ ", Location(X,Y): " + this.getXLocation() + ", " + this.getYLocation() + ", Speed: " + this.getSpeed() + ", Direction: " + this.getDirection() + ", Missile: " + this.getMissileCount();
		return parentDesc + myDesc;				
	}

	public void changeAccel(int newSpeed) {
		newSpeed = this.getSpeed() + newSpeed;
		if (newSpeed > 10) 
			this.setSpeed(10);
		else if(newSpeed < 0) 
			this.setSpeed(0);
		else 
			this.setSpeed(newSpeed);
		this.updateML();
		
	}

	public void changeDirection(int newDirection) {
		if(this.getDirection() > 0) 
			this.setDirection(newDirection + 360); 
		else if(this.getDirection() > 360)
			this.setDirection((this.getDirection()%360) + newDirection); 
		
	}
}
