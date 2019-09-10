package com.mycompany.A1Prj;

import com.codename1.charts.util.ColorUtil;

public class SpaceStation extends FixedGameObject {

	private int blinkRate;							//in seconds, random value 1-4
	private boolean lightOn;
	
	public SpaceStation() {
		this.setBlinkRate(getRandom(4));
		this.setColor(ColorUtil.GREEN);
	}
	
	public int getBlinkRate()
	{
		return blinkRate;
	}
	
	public void setBlinkRate(int blinkRate)
	{
		this.blinkRate = blinkRate;
	}
	
	public boolean getLightOn()
	{
		return lightOn;
	}
	
	public void setLightOn(boolean lightOn)
	{
		this.lightOn = lightOn;
	}
			
	public String toString()
	{
		String parentDesc = super.toString();
		String myDesc = " Blink Rate: "+ this.getBlinkRate() + ", Light On: " + this.getLightOn() + ", Color: "+ this.getColor()+ ", Location(X,Y): " + this.getXLocation()+", " + this.getYLocation();
		return parentDesc + myDesc;				
	}
	
}
