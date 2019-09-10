package com.mycompany.A1Prj;

public abstract class Ship extends MoveableGameObject {

	private int missileCount;
	private MissileLauncher ML;
	
	public Ship() {
		this.setML(this.getXLocation(), this.getYLocation(), this.getSpeed(), this.getDirection());
	}
	
	public int getMissileCount()
	{
		return missileCount;
	}
	
	public void setMissileCount(int missileCount)
	{
		this.missileCount = missileCount;
	}
	
	public void setML(double x, double y, int speed, int direction) {
		ML = new MissileLauncher(x, y, speed, direction);
	}
	public MissileLauncher getML() {
		return ML;
	}
	public void updateML() {
		ML.setDirection(this.getDirection()+ML.getDirection());
		ML.setSpeed(this.getSpeed());
		ML.setXLocation(this.getXLocation());
		ML.setYLocation(this.getYLocation());
	}
}
