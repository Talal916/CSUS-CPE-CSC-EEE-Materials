package com.mycompany.a1;

public class Asteroid extends MoveableGameObject {

	private int size;
	
	public Asteroid()
	{
		setColor(0,0,255); //asteroids are blue
		this.size = rand.nextInt(25)+6;
	}
	public int getSize()
	{
		int retval = 0;
		
		return retval;
		
	}
	

	
	public String toString()
	{
		String parentDesc = super.toString();
		String myDesc = "size = " + size;
		String retval = "Asteroid: " + parentDesc + myDesc;
		
		return retval;
		
	}
	
	@Override
	public void Move()
	{
		super.Move();
	}

}
