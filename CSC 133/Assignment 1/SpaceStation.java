package com.mycompany.a1;

public class SpaceStation extends FixGameObject {

	
	private int blinkRate, blinkTimer, spaceStationID;
	private boolean stationLight;
	

	
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
	}
}
