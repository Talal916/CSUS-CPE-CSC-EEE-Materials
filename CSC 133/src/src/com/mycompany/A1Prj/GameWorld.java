package com.mycompany.A1Prj;

import java.util.Random;
import java.util.Vector;

import com.codename1.ui.Dialog;
import com.codename1.ui.Display;

public class GameWorld {
	Random random = new Random();
	public Vector<GameObject> store = new Vector<GameObject>();
	int totalGameTime = 0;
	int totalScore = 0;
	int lives = 3;
	
	public GameWorld() {
		init();
	}
	public void init()
	{
		
	}

	public void addNewAsteroid()
	{	
		Asteroid asteroid = new Asteroid();
		store.add(asteroid);
		System.out.println("A new ASTEROID has been created");
	}

	public void addNonPlayerShip()
	{	
		NonPlayerShip NPS = new NonPlayerShip();
		
		store.add(NPS);
		System.out.println("A new Enemy Ship has arived");
	}
	//TODO: needs a unique ID
	public void addSpaceStation()
	{
		if(checkSpaceStation())
			System.out.println("A SPACE STATION already exists");
		else
		{
			 SpaceStation spaceStation = new SpaceStation();
 			  
			  store.add(spaceStation);
			  System.out.println("A SPACE STATION has been created");
		}			
	}
	
	public void addPlayerShip()
	{	
		if(checkPlayerShip())
			System.out.println("A PLAYER SHIP already exists");
		else
		{						
		  PlayerShip PS = new PlayerShip();	
		  store.add(PS);
		  System.out.println("A new PLAYER SHIP has been created");
		 }
	}
	
	public void changeSpeed(int speed)
	{	
		if(checkPlayerShip())
		{
			for (int i=0; i<store.size(); i++) {    
			  if (store.elementAt(i) instanceof PlayerShip) 
			  {	  
				  ((PlayerShip) store.elementAt(i)).changeAccel(speed);
				  System.out.println("SPEED increased to "+ ((PlayerShip) store.elementAt(i)).getSpeed());	  
			  }
			}
		}
		else
		{
			  System.out.println("There is no PLAYER SHIP");
		}
	}
	
	public void turnShip(int direction)
	{
		if(checkPlayerShip())
		{
			for (int i=0; i<store.size(); i++) {    
				  if (store.elementAt(i) instanceof PlayerShip) 
				  {	  
					  ((PlayerShip) store.elementAt(i)).changeDirection(direction);
					  System.out.println("DIRECTION changed to "+ ((PlayerShip) store.elementAt(i)).getDirection());	  
				  }
			}
		}
		else
		{
			System.out.println("There is no PLAYER SHIP");
		}
	}
	
	public void RotateLauncher(int direction)
	{
		if(checkPlayerShip())
		{
			for (int i=0; i<store.size(); i++) {   
			if (store.elementAt(i) instanceof PlayerShip) 
			  {	  
				((PlayerShip) store.elementAt(i)).getML().changeDirection(direction);
				System.out.println("DIRECTION changed to "+ ((PlayerShip) store.elementAt(i)).getML().getDirection());
			  }
			}
		}
		  else
		  {
			  System.out.println("There is no PLAYER SHIP");
		  }
	}
	
	public void firePlayerMissile()
	{
		if(checkPlayerShip())
		{
			for (int i=0; i<store.size(); i++) {    
				  if (store.elementAt(i) instanceof PlayerShip) 
				  {	  
					  if (((Ship) store.get(i)).getMissileCount() > 0)
						  System.out.println("No more MISSILES");
					  else
					  {
						  ((Ship) store.get(i)).setMissileCount(((Ship)store.get(i)).getMissileCount() - 1);
						  Missile missile = new Missile();
						  missile.setDirection(((MoveableGameObject) store.get(i)).getDirection());
						  missile.setSpeed(((MoveableGameObject) store.get(i)).getSpeed() + 10);
						  store.add(missile);
						  System.out.println("MISSILE inbound");
					  }
				  }
			}
		}
	  else
	  {
		  System.out.println("There is no PLAYER SHIP");
	  }
	}
	// firing of NPS missile is selected randomly 
	public void fireNonPlayerMissile()
	{
		if(checkNonPlayerShip())
		{
			for (int i=0; i<store.size(); i++) {    
				  if (store.elementAt(i) instanceof NonPlayerShip) 
				  {	  
					  if (((Ship) store.get(i)).getMissileCount() <= 0)
						  System.out.println("No more MISSILES");
					  else
					  {
						  ((Ship) store.get(i)).setMissileCount(((Ship)store.get(i)).getMissileCount() - 1);
						  Missile missile = new Missile();
						  missile.setDirection(((MoveableGameObject) store.get(i)).getDirection());
						  missile.setSpeed(((MoveableGameObject) store.get(i)).getSpeed() + 10);
						  store.add(missile);
						  System.out.println("MISSILE inbound");
					  }
				  }
			}
		}
		  else
		  {
			  System.out.println("There is no NPS");
		  }
	}

	public void jumpSpace()
	{
		boolean contains = false;
		for (int i=0; i<store.size(); i++) {    
			  if (store.elementAt(i) instanceof PlayerShip) 
			  {	  
				  ((PlayerShip) store.get(i)).setXLocation(512);
				  ((PlayerShip) store.get(i)).setXLocation(384);
				  ((PlayerShip) store.get(i)).setDirection(0);
				  ((PlayerShip) store.get(i)).setSpeed(0);
				  ((PlayerShip) store.get(i)).updateML();

				  System.out.println("WARP DRIVE 10 activated");
				  contains = true;
			  }
		}
			  if(contains == false)
			  {		
				  System.out.println("There is no PLAYER SHIP");
			  }
			
	}
	
	public void loadNewMissile()
	{
		for (int i=0; i<store.size(); i++) {    
			  if (store.elementAt(i) instanceof PlayerShip) 
			  {	  
				  ((PlayerShip) store.elementAt(i)).setMissileCount(10);
			  }
		}
	}
	
	public void playerHitAsteroid()
	{
		int destroyAsteroid = 0;
		int destroyMissile = 0;
		
		if(!checkPlayerShip())
		System.out.println("There is no PLAYER SHIP");
		
		if(checkAsteroid())
		{
			for(int i = 0; i<store.size(); i++)
			{
				if (store.elementAt(i) instanceof Asteroid) 
				{
					destroyAsteroid = i;
				}
			}
		}
		else
			System.out.println("There is no ASTEROID to blow up");
		
		if(checkMissile())
		{
			for(int i = 0; i<store.size(); i++)
			{
				if (store.elementAt(i) instanceof Missile) 
				{
					destroyMissile = i;
				}
			}
		}
		else
			System.out.println("There are no MISSILES");
		if(checkPlayerShip() && checkMissile() && checkAsteroid())
		{
			store.remove(destroyAsteroid);
			store.remove(destroyMissile);
			totalScore += 100;
			System.out.println("Direct hit to ASTEROID");
		}
		
	}
	
	public void playerHitNonPlayerShip()
	{
		int destroyNPS = 0;
		int destroyMissile = 0;
		
		if(!checkPlayerShip())
			System.out.println("There is no PLAYER SHIP");
			
		if(checkNonPlayerShip())
		{
			for(int i = 0; i<store.size(); i++)
			{
				if (store.elementAt(i) instanceof NonPlayerShip) 
				{
					destroyNPS = i;
					break;
				}
			}
		}
		else
			System.out.println("There is no ENEMY SHIP to blow up");
			
		if(checkMissile())
		{
			for(int i = 0; i<store.size(); i++)
			{
				if (store.elementAt(i) instanceof Missile) 
				{
					destroyMissile = i;
				}
			}
		}
		else
				System.out.println("There are no Missiles");
	
		if(checkPlayerShip() && checkNonPlayerShip() && checkMissile())
		{
			store.remove(destroyNPS);
			store.remove(destroyMissile);
			totalScore += 100;
			System.out.println("Direct hit to ENEMY SHIP");
		}
	}
	
	public void nonPlayerHitPlayer()
	{
		int destroyPlayer = 0;
		int destroyMissile = 0;
		
		if(checkPlayerShip())
		{
			for (int i=0; i<store.size(); i++) {    
				  if (store.elementAt(i) instanceof PlayerShip) 
				  {	  
					  destroyPlayer = i;
					  break;
				  }
			}
		}
		  else
		  	System.out.println("There is no PLAYER SHIP to blow up");
			
		if(!checkNonPlayerShip())
			System.out.println("There is no ENEMY SHIP to blow up a PLAYER");
		
		if(checkMissile())
		{
			for(int i = 0; i<store.size(); i++)
			{
				if (store.elementAt(i) instanceof Missile) 
				{
					destroyMissile = i;
				}
			}
		}
		else
			System.out.println("There is no ASTEROID to blow up");
		
		if(checkPlayerShip() && checkNonPlayerShip() && checkMissile())
		{
			store.remove(destroyPlayer);
			store.remove(destroyMissile);
			totalScore += 100;
			System.out.println("Direct hit from ENEMY SHIP, lost all sheilds");
		}
	}
	
	public void playerCrashAsteroid()
	{
		int destroy = 0;
		int destroy2 = 0;
		
		if(checkPlayerShip())
		{
			for (int i=0; i<store.size(); i++) {    
				  if (store.elementAt(i) instanceof PlayerShip) 
				  {	  
					  destroy2 = i;
					  break;
				  }
			}
		}
		else
			System.out.println("There is no PLAYER SHIP");
		
		if(checkAsteroid())
		{
			for(int i = 0; i<store.size(); i++)
			{
				if (store.elementAt(i) instanceof Asteroid) 
				{
					destroy = i;
				}
			}
		}
		else
			System.out.println("There is no ASTEROID to crash into");
			
		if(checkPlayerShip() && checkAsteroid())
		{
			store.remove(destroy);
			store.remove(destroy2);
			decreaseLife();
			System.out.println("We have lost all ablity to steer and crash into an ASTEROID");
		}
	}
	
	public void playerCrashNonPlayer()
	{
		int destroy = 0;
		int destroy2 = 0;
		
		if(checkPlayerShip())
		{
			for (int i=0; i<store.size(); i++) {    
				  if (store.elementAt(i) instanceof PlayerShip) 
				  {	  
					  destroy2 = i;
				  }
			}
		}
		  else
		  	System.out.println("There is no PLAYER SHIP");
			
		if(checkNonPlayerShip())
		{
			for(int i = 0; i<store.size(); i++)
			{
				if (store.elementAt(i) instanceof NonPlayerShip) 
				{
					destroy = i;
				}
			}
		}
		else
			System.out.println("There is no ENEMY SHIP to crash into");
			
		if(checkPlayerShip() && checkNonPlayerShip())
		{
			store.remove(destroy);
			store.remove(destroy2);
			decreaseLife();
			System.out.println("We have lost all ablity to steer and crash into an ENEMY SHIP");
		}
	}
	
	public void asteroidCrashAsteroid()
	{
		boolean containsAsteroid1 = false;
		boolean containsAsteroid2 = false;
		int destroy = 0;
		int destroy2 = 0;
		
		if(checkAsteroid())
		{
			for (int i=0; i<store.size(); i++) {    
				  if (store.elementAt(i) instanceof Asteroid) 
				  {	  
					  destroy2 = i;
					  containsAsteroid1 = true;
				  }
			}
		}
		  else
		  	System.out.println("There are no Asteroids");
			
		for(int i = 0; i<store.size(); i++)
		{
			if ((store.elementAt(i) instanceof Asteroid) && (i != destroy)) 
			{
				containsAsteroid2 = true;
				destroy = i;
			}
		}
			if(!containsAsteroid2)
				System.out.println("Need 2 Asteroids");
			
		if(containsAsteroid1 && containsAsteroid2)
		{
			store.remove(destroy);
			store.remove(destroy2);
			System.out.println("2 ASTEROIDS collided into eachother");
		}
	}
	
	public void asteroidCrashNonPlayer()
	{
		int destroy = 0;
		int destroy2 = 0;
		
		if(checkNonPlayerShip())
		{
			for (int i=0; i<store.size(); i++) {    
				  if (store.elementAt(i) instanceof NonPlayerShip) 
				  {	  
					  destroy2 = i;
				  }
			}
		}
		  else
		  	System.out.println("There is no NONPLAYER SHIP");
			
		if(checkAsteroid())
		{
			for(int i = 0; i<store.size(); i++)
			{
				if (store.elementAt(i) instanceof Asteroid) 
				{
					destroy = i;
				}
			}
		}
		else
			System.out.println("There is no ASTEROID to crash into");
			
		if(checkNonPlayerShip() && checkAsteroid())
		{
			store.remove(destroy);
			store.remove(destroy2);
			System.out.println("A NONPLAYER SHIP has lost all of its ablity to steer and crashed into an ASTEROID");
		}
	}
	//finish blinking light
	public void gameClock()
	{
		for (int i = 0; i<store.size(); i++)
		{
			if (store.elementAt(i) instanceof IMoveable)
			{
				IMoveable mObj = (IMoveable) store.elementAt(i);
				mObj.move();
			}
			if(store.elementAt(i) instanceof Missile)
			{
				int setMissileLevel;
				setMissileLevel = ((Missile) store.elementAt(i)).getfuelLevel() - 1;
				if(setMissileLevel <= 0)
					store.remove(i);
				else
					((Missile) store.elementAt(i)).setfuelLevel(setMissileLevel);
			}
			
			if(store.elementAt(i) instanceof SpaceStation)
			{
				int blink;
				blink = ((SpaceStation) store.elementAt(i)).getBlinkRate() - 1;
				if (blink == 0 )
				{
					((SpaceStation) store.elementAt(i)).setLightOn(true);
					
				}
			}
		}
		
		totalGameTime++;
		
	}
	
	public void print()
	{
		int missile = 0;
		for(int i = 0; i<store.size(); i++)
		{
			if (store.elementAt(i) instanceof PlayerShip) 
			{
				missile = ((Ship) store.get(i)).getMissileCount();
				break;			
			}
		}
		
		System.out.println("\nScore: " + totalScore +
				"  Missiles: " + missile  +
				"  Time: " + totalGameTime +
				"  Lives: " + lives);
	}
	
	public void map()
	{
		for (int i=0; i<store.size(); i++) {
			System.out.print(store.elementAt(i).toString()+'\n');
		}
	}
	
	public void decreaseLife()
	{
		if(lives > 0)
			lives -= 1;
		else
			gameOver();
	}
	
	public void gameOver() {
		boolean bOk = Dialog.show("You scored " + totalScore + " points!", "Try again?", "Yes", "No");
		
		if(bOk) {
			resetGame();
		} else {
			Display.getInstance().exitApplication();
		}
	}
	
	public void resetGame() {
		store = new Vector<GameObject>();
		lives = 3;
		totalGameTime = 0;
		totalScore = 0;
	}

	public void quit(){
		boolean bOk = Dialog.show("Confirm quit", "Are you sure you want to quit?", "Ok", "Cancel");
		
		if(bOk) {
			Display.getInstance().exitApplication();
		}
	}
	
	public boolean checkAsteroid()
	{
		for (int i=0; i<store.size(); i++) {    
			  if (store.elementAt(i) instanceof Asteroid)   
				  return true;
		}
		return false;			  
	}
	public boolean checkNonPlayerShip()
	{
		for (int i=0; i<store.size(); i++) {    
			  if (store.elementAt(i) instanceof NonPlayerShip)   
				  return true;
		}
		return false;			  
	}
	public boolean checkPlayerShip()
	{
		for (int i=0; i<store.size(); i++) {    
			  if (store.elementAt(i) instanceof PlayerShip)   
				  return true;
		}
		return false;			  
	}
	
	public boolean checkSpaceStation()
	{
		for (int i=0; i<store.size(); i++) {    
			  if (store.elementAt(i) instanceof SpaceStation)   
				  return true;
		}
		return false;			  
	}
	public boolean checkMissile()
	{
		for (int i=0; i<store.size(); i++) {    
			  if (store.elementAt(i) instanceof Missile)   
				  return true;
		}
		return false;			  
	}
}
