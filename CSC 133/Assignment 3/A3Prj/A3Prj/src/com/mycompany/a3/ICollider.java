package com.mycompany.a3;

public interface ICollider {

	
	
	public boolean collidesWith(ICollider other);
	
	public void handleCollision(ICollider other);
	
	public void setCollisionFlag();
	public boolean getCollisionFlag();
	
	
	
}


