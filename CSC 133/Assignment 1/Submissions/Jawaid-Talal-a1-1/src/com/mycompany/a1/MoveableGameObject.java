package com.mycompany.a1;

import com.codename1.ui.geom.Point2D;


public abstract class MoveableGameObject extends GameObject {

	private int objSpeed;
	private int objDirection;
	
	public MoveableGameObject()
	{
		objSpeed = rand.nextInt(16);
		objDirection = rand.nextInt(360);
		
	}
	
	public void Move() //implementing Move here so each moveable object can use this
	{
		
		Point2D oldLocation = getLocation(); //get current location and store here
		
		Point2D newLocation = new Point2D(0,0); // new location initialized
		
		int properAngle = 90-objDirection; //angle because coordinate plane is shifted
		double deltaX = 0;
		double deltaY = 0;
		
		
		
		/*
		 * direction * speed results in units of distance 
		 */
		if(objDirection == 0 || objDirection == 180) //if only vertical movement
		{
			deltaY = Math.sin(Math.toRadians(properAngle)) * objSpeed;
		}
		else if( objDirection == 90 || objDirection == 270 ) //only horizontal
			deltaX = Math.cos(Math.toRadians(properAngle)) * objSpeed;
		else // if both vertical and horizontal movement required
		{
			deltaX = Math.cos(Math.toRadians(properAngle))*objSpeed; 
			deltaY = Math.sin(Math.toRadians(properAngle)) * objSpeed;
		}
		
		/*
		 * Changing new location x and y by using oldLocation x and y
		 * and adding delta X and delta Y
		 */
		
		newLocation.setX(deltaX + oldLocation.getX()); 
		newLocation.setY(deltaY+oldLocation.getY());
		
		setLocation(newLocation); //changing location to new location
		
		
		
		
	}
	
	public void setSpeed(int x)
	{
		System.out.println("Adding objSpeed:" + objSpeed + " to x: "+ x);
		objSpeed = objSpeed + x;
	}
	
	public int getSpeed()
	{
		return objSpeed;
	}
	
	public int getDirection()
	{
		return objDirection;
		
	}
	
	public void setDirection(int x)
	{
		objDirection = x;
	}
	
	public String toString()
	{
		String parentString = super.toString();
		String str = " || Speed = " + objSpeed + " || Direction = " + objDirection;
		
		
		String retval = parentString + str;
		
		return retval;
	}
	

}
