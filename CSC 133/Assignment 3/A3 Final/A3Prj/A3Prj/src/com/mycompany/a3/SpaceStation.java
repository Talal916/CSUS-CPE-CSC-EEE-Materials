package com.mycompany.a3;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics; 
import com.codename1.ui.geom.Point;

public class SpaceStation extends FixGameObject implements ICollider,IDrawable
{

	
	private int blinkRate, blinkTimer, spaceStationID;
	private boolean stationLight;
	private final int SSWIDTH = 50;
	private final int SSHEIGHT = 30;
	private final int TimeToReload = 5;
	
	private int reloadTimer = 0;
	
	private boolean collisionFlag = false;
	private boolean reloadReady  = true;
	
	

	
	public SpaceStation()
	{
		spaceStationID = getObjId();
		setColor(0,255,255);
		
		blinkRate = rand.nextInt(4)+1;
		stationLight = true;
		blinkTimer = 0;
	}
	
	public int getBlinkRate()
	{
		return blinkRate;
		
	}
	
	private int getSSID()
	{
		return spaceStationID;
	}
	public String toString()
	{
		String parentDesc = super.toString();
		String myDesc = " blinkRate = " + blinkRate;
		String retval = "Station: " + parentDesc + myDesc;
		return retval;
	}

	public void blinkCounter()
	{
		blinkTimer++;
		if(blinkTimer == blinkRate) //if blinkRate period has elapsed
		{
			stationLight = !stationLight; //flipping station light
			blinkTimer = 0; // resetting blink counter
		}
		if(!reloadReady)
			increaseReloadTimer();
	}

	private void increaseReloadTimer() {
		reloadTimer++;
		if(reloadTimer == TimeToReload)
			reloadReady = true;
		
	}

	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		// TODO Auto-generated method stub
		g.setColor(this.getColor());
		g.setColor(ColorUtil.WHITE);
		int xLoc = (int)this.getLocation().getX() + pCmpRelPrnt.getX() - (SSWIDTH / 2);
		int yLoc = (int)this.getLocation().getY() + pCmpRelPrnt.getY() - (SSHEIGHT / 2);
		
		g.drawArc(xLoc, yLoc, SSWIDTH, SSHEIGHT, 0, 360);
		
		if (stationLight && reloadReady)
		{			
			g.fillArc(xLoc, yLoc, SSWIDTH, SSHEIGHT, 0, 360);
		}
	}

	@Override
	public boolean collidesWith(ICollider other) {
		boolean retval = false;
		
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
		
		if (distBetweenCentersSqr <= radiiSqr) 
		{
			retval = true;
		}
		
		return retval;		
	}

	@Override
	public void handleCollision(ICollider other) {
		if (other instanceof PlayerShip && reloadReady)
		{
			((PlayerShip) other).reloadMissiles();
			reloadReady = false;
			reloadTimer = 0;
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
