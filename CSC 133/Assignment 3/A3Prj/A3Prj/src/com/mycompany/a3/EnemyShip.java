package com.mycompany.a3;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.charts.util.ColorUtil; 


public class EnemyShip extends MoveableGameObject implements ICollider, IDrawable, ISelectable{

	private int size;
	private int missileCount;
	private MissileLauncher launcher;
	private boolean collisionFlag = false;
	private boolean selected = false;

	public EnemyShip()
	{
		size = (rand.nextInt(2)+1)*10;
		missileCount  = 2;
		setColor(255,255,0); //enemy ships are yellow
		launcher = new MissileLauncher(this.getDirection(),this.getLocation());
		setSize((rand.nextInt(2)+1)*10);

	}
	
	public int getSize()
	{
		return size;
		
	}
	
	public void launcherMove()
	{
		launcher.setLocation(this.getLocation());
	}
	public void setMissileCount(int amount)
	{
		missileCount = amount;
	}
	
	
	public int getMissileCount()
	{
		return missileCount;
	}
	
	public Missile fire()
	{
		missileCount--;
		Missile bogey = new Missile(getDirection(),getLocation(),false);
		System.out.println("A missile has been fired from an Enemy Ship!");

		return bogey;
	}
	
	@Override
	public boolean collidesWith(ICollider other)
	{
		boolean result = false;
		double thisCenterX = this.getLocation().getX();
		double thisCenterY = this.getLocation().getY();
		
		double otherCenterX = ((GameObject)other).getLocation().getX();
		double otherCenterY = ((GameObject)other).getLocation().getY();
		
		double dx = thisCenterX - otherCenterX;
		double dy = thisCenterY - otherCenterY;
		
		double distBetweenCentersSqr = (dx * dx + dy * dy);
		
		// find square of sum of radii
		int thisRadius= this.getSize() / 2;
		int otherRadius= ((GameObject)other).getSize() / 2;
		
		int radiiSqr= (thisRadius * thisRadius + 2 * thisRadius * otherRadius + otherRadius * otherRadius);
		
		if (distBetweenCentersSqr <= radiiSqr) { result = true ; }
		
		return result;
	}
	
	public String toString()
	{
		String parentDesc = super.toString();
		String myDesc = " size = "+size + " || Missiles Left: "+missileCount;
		String retval = "Non-Player Ship: "+ parentDesc+myDesc;
		
		return retval;
	}

	@Override
	public void setSelected(boolean y) {
		selected = y;
	}

	@Override
	public boolean isSelected() {
		// TODO Auto-generated method stub
		return selected;
	}

	@Override
	public boolean contains(Point pPtrRelPrnt, Point pCmpRelPrint) {
		int px = pPtrRelPrnt.getX();
		int py = pPtrRelPrnt.getY();
		
		int xLoc = (int)this.getLocation().getX() + pCmpRelPrint.getX();
		int yLoc = (int)this.getLocation().getY() + pCmpRelPrint.getY();
		
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
			g.setColor(ColorUtil.YELLOW);
		}
		int xLoc = (int)this.getLocation().getX() + pCmpRelPrnt.getX();
		int yLoc = (int)this.getLocation().getY() + pCmpRelPrnt.getY();
		int[] xArr = { xLoc, (xLoc - getSize()), (xLoc + getSize()), xLoc };
		int[] yArr = { (yLoc + getSize()), (yLoc - getSize()), (yLoc - getSize()), (yLoc + getSize()) };
		
		int nPoints = 4;
		
		g.drawPolygon(xArr, yArr, nPoints);
		g.fillPolygon(xArr, yArr, nPoints);		
	}

	@Override
	public void handleCollision(ICollider other)
	{
		if (other instanceof Asteroid || other instanceof PlayerShip || (other instanceof Missile && !((Missile)other).getisFriendly()));
		{
			this.setCollisionFlag();
			other.setCollisionFlag();
		}
	}	

	@Override
	public void setCollisionFlag() {
		collisionFlag = true;
	}

	@Override
	public boolean getCollisionFlag() {
		return collisionFlag;
	}

	public int getLauncherDir() {
		return launcher.getLauncherDir();
	}
	
	public void SetLauncherDir(int dir)
	{
		launcher.setLauncherDirection(dir);
	}
}
