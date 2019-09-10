package com.mycompany.a1;

import com.codename1.ui.geom.Point2D;

public class Missile extends MoveableGameObject {

	private int fuelLevel;
	boolean isFriendly;
	
	public Missile(int missileDirection, Point2D shotLocation, boolean friendly)
	{
		fuelLevel = 10;
		setDirection(missileDirection);
		setLocation(shotLocation);
		if(friendly)
		{
			setColor(255,102,178); //friendly missiles are pink
			isFriendly = true;
		}
		else
		{
			setColor(255,128,0); //enemy missiles are orange
			isFriendly = false;
		}
		
	}
	
	
	public boolean getisFriendly()
	{
		return isFriendly;
		
	}
	public int getFuel()
	{
		
		return fuelLevel;
	}
	
	@Override
	public void Move()
	{
		fuelLevel--;
		super.Move();
		
	}
	
	public String toString()
	{
		String parentDesc = super.toString();
		String myDesc = " fuel = " + fuelLevel;
		String retval = "";
		if(isFriendly)
			retval = " PS Missile: " + parentDesc + myDesc;
		else
			retval = " Enemy Missile: " + parentDesc + myDesc;
		
		
		return retval;
	}
}
