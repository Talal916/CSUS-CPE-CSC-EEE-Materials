package com.mycompany.a1;

public class MissileLauncher extends MoveableGameObject implements ISteerable
{
	private int launcherDir;
	
	public int getLauncherDir()
	{
		
		
		
		return launcherDir;
	}

	@Override
	public void turn(){
		launcherDir = launcherDir + 10;
	}

	public void setLauncherDirection(int x)
	{
		launcherDir = x;
	}
	
	public String toString()
	{
		String retval = " || Missile Launcher Direction =  "+launcherDir;
		return retval;
	}

	@Override
	public void Move() {
		// TODO Auto-generated method stub
		super.Move();
	}
}
