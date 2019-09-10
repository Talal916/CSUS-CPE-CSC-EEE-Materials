package com.mycompany.a3;

public class FixGameObject extends GameObject{

	private static int objId; //id of fixed obj
	//cannot be changed once it has been created
	
	public int getObjId()
	{
		objId++;
		return objId;
	}
}
