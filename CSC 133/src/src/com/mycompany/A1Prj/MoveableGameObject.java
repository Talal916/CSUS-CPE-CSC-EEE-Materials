package com.mycompany.A1Prj;

public abstract class MoveableGameObject extends GameObject implements IMoveable {

	private int speed;									//int 0-10
	private int direction;								//int 0-359
	
	public MoveableGameObject() {
		this.setSpeed(getRandom(11));
		this.setDirection(getRandom(359));
	}
	
	public int getSpeed()
	{
		return speed;
	}
	
	public int getDirection()
	{
		return direction;
	}
	
	public void setSpeed(int speed)
	{
		this.speed = speed;
	}
	
	public void setDirection(int direction)
	{
		this.direction = direction;
	}
	
	public void move()
	{
		int angle = 90 - this.getDirection();
		double deltaX = Math.cos(angle)*this.getSpeed();
		double deltaY = Math.sin(angle)*this.getSpeed();		
		float newLocationX = (float) (this.getXLocation() + deltaX);
		float newLocationY = (float) (this.getYLocation() + deltaY);
		
		this.setXLocation(newLocationX);
		this.setYLocation(newLocationY);
	}
}
