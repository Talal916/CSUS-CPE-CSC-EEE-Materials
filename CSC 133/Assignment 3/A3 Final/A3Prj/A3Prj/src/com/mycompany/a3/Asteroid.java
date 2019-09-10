package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil; 
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;


public class Asteroid extends MoveableGameObject implements ICollider, IDrawable, ISelectable
{

	private boolean collisionFlag = false;
	private boolean selected = false;
	
	public Asteroid()
	{
		setColor(0,0,255); //asteroids are blue
		setSize(rand.nextInt(10)+40);
	}

	
	@Override
	public void draw(Graphics g, Point pCmpRelPrnt)
	{
		if (isSelected())
		{
			g.setColor(ColorUtil.GREEN);
		}
		else
		{ 
			g.setColor(this.getColor());
		}
		
		g.setColor(ColorUtil.WHITE);
		int xLoc = (int)this.getLocation().getX() + pCmpRelPrnt.getX() - (getSize()/2);
		int yLoc = (int)this.getLocation().getY() + pCmpRelPrnt.getY() - (getSize()/2);
		g.drawArc(xLoc, yLoc, this.getSize(), this.getSize(), 0, 360);
		g.fillArc(xLoc, yLoc, this.getSize(), this.getSize(), 0, 360);
	}




	public String toString()
	{
		String parentDesc = super.toString();
		String myDesc = "size = " + getSize();
		String retval = "Asteroid: " + parentDesc + myDesc;
		
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
		if(!(other instanceof SpaceStation))
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
		// TODO Auto-generated method stub
		return collisionFlag;
	}

}
