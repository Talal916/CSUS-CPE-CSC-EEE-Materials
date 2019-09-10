package com.mycompany.a3;

import java.util.Observable;

public class GameWorldProxy extends Observable implements IGameWorld{

	private GameWorld gameProxy;
	
	public GameWorldProxy(GameWorld gameWorld)
	{
		gameProxy = gameWorld;
	}
	


	@Override
	public int getPoints() {
		return gameProxy.getPoints();
		
	}

	@Override
	public int getMissileCount() {
		return gameProxy.getMissileCount();
	}

	@Override
	public int getTime() {
		return gameProxy.getTime();
	}

	@Override
	public int getLives() {
		return gameProxy.getPlayerLives();
	}

	@Override
	public boolean getSoundSetting() {
		return gameProxy.getSoundSetting();
	}

	@Override
	public GameCollection getCollection() {

		return gameProxy.getCollection();
	}

}
