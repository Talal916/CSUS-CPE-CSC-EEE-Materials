package com.mycompany.A1Prj;

public class FixedGameObject extends GameObject {
	private int objectID;							// not possible to change either the ID number or the location of a fixed object once it has been created
													// ID needs to be unique
	public int getObjectID()
	{
		return objectID;
	}
	
	public void setObjectID(int objectID)
	{
		this.objectID = objectID;
	}

}
