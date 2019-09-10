package com.mycompany.a3;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;
import com.codename1.charts.util.ColorUtil; 

public class Missile extends MoveableGameObject implements ICollider, IDrawable, ISelectable{

	private int fuelLeft;
	private boolean isFriendly;
	private boolean selected = false;
	private final int MISSILE_FUEL = 100;
	private final int MISSILE_SIZE = 20;
	private boolean collisionFlag = false;
	private int scoreEarn = 0;
	
	public Missile(int missileDirection, Point2D shotLocation, boolean friendly)
	{
		fuelLeft = MISSILE_FUEL;
		setDirection(missileDirection);
		setLocation(shotLocation);
		setSize(MISSILE_SIZE);
		
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
		
		return fuelLeft;
	}
	

	
	public String toString()
	{
		String parentDesc = super.toString();
		String myDesc = " fuel = " + fuelLeft;
		String retval = "";
		if(isFriendly)
			retval = " PS Missile: " + parentDesc + myDesc;
		else
			retval = " Enemy Missile: " + parentDesc + myDesc;
		
		
		return retval;
	}


	public boolean isSelected() {
		// TODO Auto-generated method stub
		return selected ;
	}


	public void resetFuel() {
		fuelLeft = MISSILE_FUEL;
	}


	@Override
	public void setSelected(boolean y) {
		selected = y;
	}


	@Override
	public boolean contains(Point pPtrRelPrnt, Point pCmpRelPrnt) {
		int px = pPtrRelPrnt.getX();
		int py = pPtrRelPrnt.getY();
		
		int xLoc = (int)this.getLocation().getX() + pCmpRelPrnt.getX();
		int yLoc = (int)this.getLocation().getY() + pCmpRelPrnt.getY();
		
		if ( ((px >= xLoc - getSize() /  2) && (px <= xLoc + getSize() / 2)) && 
				((py >= yLoc - getSize() / 2) && (py <= yLoc + getSize() / 2)))
		{
			return true;
		}
		return false;
	}


	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		if (isSelected())
		{
			g.setColor(ColorUtil.GREEN);
		}
		else
		{			
			g.setColor(this.getColor());
		}
		
		if(this.getisFriendly())
			g.setColor(ColorUtil.BLUE);
		if(!this.getisFriendly())
			g.setColor(ColorUtil.rgb(255, 0, 0));
		
		int xLoc = (int)this.getLocation().getX() + pCmpRelPrnt.getX() - (MISSILE_SIZE / 2);
		int yLoc = (int)this.getLocation().getY() + pCmpRelPrnt.getY() - (MISSILE_SIZE / 2);
		
		g.drawRect(xLoc, yLoc, MISSILE_SIZE, MISSILE_SIZE);
		g.fillRect(xLoc, yLoc, MISSILE_SIZE, MISSILE_SIZE);		
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
		
		double distToCenter = (dx * dx + dy * dy);
		
		int thisRadius= this.getSize() / 2;
		int otherRadius= ((GameObject)other).getSize() / 2;
		
		int radiiSqr= (thisRadius * thisRadius + 2 * thisRadius * otherRadius + otherRadius * otherRadius);
		
		if (distToCenter <= radiiSqr)
			result = true;
		
		return result;
	}


	@Override
	public void handleCollision(ICollider other) {
		if(this.getisFriendly())
		{
			if(other instanceof Asteroid)
			{
				this.setCollisionFlag();
				other.setCollisionFlag();
				scoreEarn = 10;
			}
			else if(other instanceof EnemyShip)
			{
				this.setCollisionFlag();
				other.setCollisionFlag();
			}
			
		}
		else if(!this.getisFriendly())
		{
			if(other instanceof PlayerShip)
			{
				this.setCollisionFlag();
				other.setCollisionFlag();
			}
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


	public int getScore() {
		// TODO Auto-generated method stub
		return scoreEarn;
	}


	public void burnFuel() {
		fuelLeft--;
	}
}
