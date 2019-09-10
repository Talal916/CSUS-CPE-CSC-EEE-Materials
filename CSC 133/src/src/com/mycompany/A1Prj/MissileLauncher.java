package com.mycompany.A1Prj;

import com.codename1.charts.util.ColorUtil;

public class MissileLauncher extends MoveableGameObject implements ISteerable {
	
	public MissileLauncher(double x, double y, int spd, int dir) {
		this.setXLocation(x);
		this.setYLocation(y);
		this.setSpeed(spd);
		this.setDirection(dir);
		this.setColor(ColorUtil.GREEN);
	}
	
	public void move() {
		super.move();
	}

	public void changeDirection(int newDirection) {
		if(this.getDirection() > 0) 
			super.setDirection(newDirection + 360); 
		else if(this.getDirection() > 360)
			this.setDirection((this.getDirection()%360) + newDirection); 
		
	}
}
