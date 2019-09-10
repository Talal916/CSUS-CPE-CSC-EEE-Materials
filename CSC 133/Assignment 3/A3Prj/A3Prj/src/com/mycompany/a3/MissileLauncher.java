package com.mycompany.a3;
import com.codename1.ui.Graphics; 
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;


public class MissileLauncher extends MoveableGameObject implements ISteerable, IDrawable
{
	private int launcherDir;
	
	public int getLauncherDir()
	{
		
		return launcherDir;
	}

	
	
	
	public MissileLauncher(int initDir, Point2D initLoc)
	{
		setColor(255,255,255);
		setDirection(initDir);
		setLocation(initLoc);
		
	}
	@Override
	public void turn(int amount){
		launcherDir = launcherDir + amount;
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
	public void draw(Graphics g, Point pCmpRelPrnt) {
		g.setColor(this.getColor());
		int xLocation = (int)this.getLocation().getX()+pCmpRelPrnt.getX();
		int yLocation = (int)this.getLocation().getY()+pCmpRelPrnt.getY();
		
		double angle  = Math.toRadians(90-this.getLauncherDir());
		double deltaX = Math.cos(angle);
		double deltaY = Math.sin(angle);
		
		g.drawLine(xLocation, yLocation, (int)(xLocation + (50 * deltaX)), (int)(yLocation + (50 * deltaY)));

	}

	
}
