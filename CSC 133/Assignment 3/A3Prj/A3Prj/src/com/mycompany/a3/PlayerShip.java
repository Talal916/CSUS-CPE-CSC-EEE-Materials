package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class PlayerShip extends MoveableGameObject implements ISteerable, ICollider, IDrawable{

	private int missileCount;
	private MissileLauncher launcher;
	private boolean collisionFlag;
	
	public PlayerShip()
	{
		launcher = new MissileLauncher(this.getDirection(),this.getLocation());
		missileCount = 10;
		setLocation(512.0,384.0);
		setSpeed(0);
		setDirection(0);
		setColor(255,255,255); //player ship is white
	}
	
	public MissileLauncher getMissileLauncher()
	{
		return launcher;
	}
	
	public int getMissileCount()
	{
		
		return missileCount;		
		
	}
	
	public int getLauncherDirection()
	{
		return launcher.getDirection();
	}
	
	public Missile fireMissile()
	{
		if(missileCount == 0)
			return null;
		missileCount--;
		Missile bogey = new Missile(getDirection(),getLocation(),true);
		System.out.println("A missile has been fired from the Player Ship!");
		
		return bogey;
	}
	
	public void reloadMissiles()
	{
		missileCount = 10;
	}

	public void resetPos(double x, double y)
	{
		setLocation(x,y);
	}
	
	public void changeSpeed(char c)
	{
		switch(c)
		{
		case 'i':
			//increase speed up to 15
			if(getSpeed() < 15)
				setSpeed(1);
			break;
		case 'd':
			//decrease speed down to min of 0
			if(getSpeed() > 0)
				setSpeed(-1);
			break;
		default:
			break;
		}
	}
	

	
/*	public void turnPS(char c) //not in use anymore
	{
		switch(c)
		{
		case 'l':
			//turn ccw
			setDirection(getDirection()-1);
		//	launcher.turn(); could turn launcher with ps
			//if desired 
			//simply create overloaded turn method that takes 
			//degree of direction change of PS as param
			
			break;
		case 'r':
			//turn cw
			setDirection(getDirection()+1);
			break;
		}
	}
	*/
	

	public String toString()
	{
		String parentDesc = super.toString();
		String myDesc = " missiles = " + missileCount;
		String retval = "Player Ship: "+parentDesc+myDesc+launcher.toString();
		
		return retval;
	}

	@Override
	public void turn(int amount) {
		if(amount < 0 && getDirection() + amount < 0)
			setDirection(getDirection() + amount + 360);
		else
		{
			if(getDirection() + amount >= 360)
			{
				setDirection(getDirection() + amount - 360);
				
			}
			else
				setDirection(getDirection()+amount);
		}
	}
	
	public void changeLauncherDir(int amount)
	{
		launcher.turn(amount);
	}

	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		// TODO Auto-generated method stub
		g.setColor(this.getColor());
		g.setColor(ColorUtil.GREEN);
		int xLoc = (int)this.getLocation().getX() + pCmpRelPrnt.getX();
		int yLoc = (int)this.getLocation().getY() + pCmpRelPrnt.getY();
		
		int[] xPoints = { xLoc, (xLoc - 20), (xLoc + 20), xLoc };
		
		int[] yPoints = { (yLoc + 30), (yLoc - 30), (yLoc - 30), (yLoc + 30) };
		
		int nPoints = 4;
		
		g.drawPolygon(xPoints, yPoints, nPoints);
		g.fillPolygon(xPoints, yPoints, nPoints);
	}

	@Override
	public boolean collidesWith(ICollider other) {
		boolean result = false;
		
		double thisCenterX = this.getLocation().getX();
		double thisCenterY = this.getLocation().getY();
		
		double otherCenterX = ((GameObject)other).getLocation().getX();
		double otherCenterY = ((GameObject)other).getLocation().getY();
		
		double dx = thisCenterX - otherCenterX;
		double dy = thisCenterY - otherCenterY;
		
		double distBetweenCentersSqr = (dx * dx + dy * dy);
		
		int thisRadius= this.getSize() / 2;
		int otherRadius= ((GameObject)other).getSize() / 2;
		
		int radiiSqr= (thisRadius * thisRadius + 2 * thisRadius * otherRadius + otherRadius * otherRadius);
		
		if (distBetweenCentersSqr <= radiiSqr) { result = true ; }
		
		return result;
	}

	@Override
	public void handleCollision(ICollider other) {
		// TODO Auto-generated method stub
		if ((other instanceof Asteroid || other instanceof EnemyShip) || (other instanceof Missile && !((Missile)other).getisFriendly()))
		{
			setCollisionFlag();
			other.setCollisionFlag();
		}
	}

	@Override
	public void setCollisionFlag() {
		collisionFlag = true;
		
	}

	@Override
	public boolean getCollisionFlag() {
		// TODO Auto-generated method stub
		return collisionFlag;
	}

	public void launcherMove()
	{
		launcher.setLocation(this.getLocation());
	}

	




}
