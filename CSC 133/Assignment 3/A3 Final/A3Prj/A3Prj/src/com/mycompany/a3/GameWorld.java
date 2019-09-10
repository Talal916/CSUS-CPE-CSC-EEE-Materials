package com.mycompany.a3;

import com.codename1.ui.Dialog; 

import java.util.Observable;


public class GameWorld extends Observable implements IGameWorld {

	
	
	private GameCollection gameObjs;
	
	private int score;
	private int elapsedTime;
	private int playerLives;
	private boolean endGame;
	private boolean soundSetting;
	private Sound missileSound;
	private Sound firedSound;
	private Sound launcherRotationSound;
	private Sound endSound;
	
	private double GWWidth;
	private double GWHeight;

	private int numMissiles;

	public GameWorld() {
		init();
	
	}
	public void init() 
	{
		score = 0;
		elapsedTime = 0;
		playerLives = 3;
		endGame = false;
		soundSetting = true;
		missileSound = new Sound("missileSound.wav");
		firedSound = new Sound("firedSound.wav");
		launcherRotationSound = new Sound("launcherRotationSound.wav");
		endSound = new Sound("endSound.wav");
		
		setEndGame(false);
		//code here to create the initial game objects/setup
		gameObjs = new GameCollection();
		
		localNotifyObserver();
		
	}
	
	

	public int getMissileCount() {
		return numMissiles;
		
	}

	public int getPoints() {
		return score;
	}

	public boolean getSoundSetting() {
		// TODO Auto-generated method stub
		return soundSetting;
	}

	public GameCollection getCollection() {
		return this.gameObjs;
	}

	public int getTime() {
		// TODO Auto-generated method stub
		return elapsedTime;
	}

	public void setGWHeight(double mapHeight) {
			GWHeight = mapHeight;
	}

	public double getGWHeight() {
		// TODO Auto-generated method stub
		return GWHeight;
	}
	
	public void setGWWidth(double mapWidth) {
		// TODO Auto-generated method stub
		GWWidth = mapWidth;
	}

	public double getGWWidth() {
		// TODO Auto-generated method stub
		return this.GWWidth;
	}

	@Override
	public int getLives() {
		// TODO Auto-generated method stub
		return playerLives;
	}

	public void setSound() {
		if(soundSetting)
			soundSetting = false;
		else
			soundSetting=true;
		

		localNotifyObserver();
	}
	
	
	
	public boolean isEndGame() {
		return endGame;
	}

	/**
	 * @param endGame the endGame to set
	 */
	public void setEndGame(boolean endGame) {
		this.endGame = endGame;
	}
	
	public void loseLife()
	{
		playerLives--;
		localNotifyObserver();
		
	}
	public int getPlayerLives()
	{
		return playerLives;
		
	}
	public PlayerShip findPS()
	{
		for(int i=0; i < gameObjs.getSize(); i++)
		{
			if(gameObjs.getObjAt(i) instanceof PlayerShip)
			{
				localNotifyObserver();

				return (PlayerShip) gameObjs.getObjAt(i);
			}
		}
		System.out.println("No Player Ship found!");
		localNotifyObserver();

		return null;
		
	}
	
	public SpaceStation findSS()
	{
		for(int i=0; i < gameObjs.getSize(); i++)
		{
			if(gameObjs.getObjAt(i) instanceof SpaceStation)
			{
				localNotifyObserver();

				return (SpaceStation) gameObjs.getObjAt(i);
			}
		}
		System.out.println("No Space Station found!");
		return null;
	}
	
	public MissileLauncher findML()
	{
		for(int i=0; i < gameObjs.getSize(); i++)
		{
			if(gameObjs.getObjAt(i) instanceof MissileLauncher)
			{
				localNotifyObserver();

				return (MissileLauncher) gameObjs.getObjAt(i);
			}
		}
		System.out.println("No Missile Launcher found!");
		localNotifyObserver();

		return null;
	}
	
	public EnemyShip findES()
	{
		for(int i=0; i < gameObjs.getSize(); i++)
		{
			if(gameObjs.getObjAt(i) instanceof EnemyShip)
			{
				localNotifyObserver();

				return (EnemyShip) gameObjs.getObjAt(i);
			}
		}
		System.out.println("No Enemy Ship found!");
		localNotifyObserver();

		return null;
	}
	
	public Asteroid findAst() //finds Asteroid and returns index of Asteroid
	{
		for(int i=0; i < gameObjs.getSize(); i++)
		{
			if(gameObjs.getObjAt(i) instanceof Asteroid)
			{
				localNotifyObserver();

				return (Asteroid) gameObjs.getObjAt(i);
			}
		}
		System.out.println("No Asteroid found!");
		localNotifyObserver();

		return null;
	}
	
	public Missile findMissile() //finds missile and returns Missile obj
	{
		for(int i=0; i < gameObjs.getSize(); i++)
		{
			if(gameObjs.getObjAt(i) instanceof Missile)
			{
				localNotifyObserver();

				return (Missile) gameObjs.getObjAt(i);
			}
		}
		System.out.println("No Missile found!");
		localNotifyObserver();

		return null;
	}
	
	public Missile findPMissile() //finds missile and returns Missile obj
	{
		for(int i=0; i < gameObjs.getSize(); i++)
		{
			if(gameObjs.getObjAt(i) instanceof Missile)
			{
				
				if(((Missile) gameObjs.getObjAt(i)).getisFriendly())
					return (Missile) gameObjs.getObjAt(i);
			}
		}
		
		System.out.println("No Player Missile found!");
		return null;
	}
	
	public Missile findEMissile() //finds missile and returns Missile obj
	{
		for(int i=0; i < gameObjs.getSize(); i++)
		{
			if(gameObjs.getObjAt(i) instanceof Missile)
			{
				if(!((Missile) gameObjs.getObjAt(i)).getisFriendly())
					return (Missile) gameObjs.getObjAt(i);
			}
		}
		System.out.println("No Enemy Missile found!");
		return null;
	}
	
	

	
	/*
	 * additional methods here to manipulate world objects and related game state data
	 */

	
	
	public void addObj(char c) {
		/*
		 * a for Asteroid
		 * y for Enemy Ship
		 * b for Space Station
		 * s for Player Ship
		 */
		switch(c)
		{
		case 'a': 
			Asteroid  a = new Asteroid();
			a.setRandLoc(GWWidth, GWHeight);
			gameObjs.add(a);
			System.out.println("An Asteroid has been created and added to game world!");
			localNotifyObserver();
			break;
		case 'y':
			EnemyShip y = new EnemyShip();
			y.setRandLoc(GWWidth, GWHeight);
			gameObjs.add(y);
			fireEMissile();
			System.out.println("An Enemy Ship has been created and added to game world!");
			
			localNotifyObserver();
			break;
		case 'b':
			SpaceStation b = new SpaceStation();
			b.setRandLoc(GWWidth, GWHeight);
			gameObjs.add(b);
			System.out.println("A Space Station has been created and added to game world!");
			localNotifyObserver();
			break;
		case 's':
			PlayerShip s = new PlayerShip();
			if(findPS() == null)
			{
			gameObjs.add(s);
			gameObjs.add(findPS().getMissileLauncher());
			System.out.println("A Player Ship and the Missile Launcher has been created and added to game world!");
			}
			else
				System.out.println("A player ship already exists!");
			localNotifyObserver();
			break;
			
			
			 
		}
		
	}
	
	

	public void changeSpeed(char c) {
		if(findPS() != null)
		{
			findPS().changeSpeed(c); //finds player ship, and changes speed
		}
		else
			System.out.println("No Player Ship Exists!");
		localNotifyObserver();

	}

	public void turnPS(char c) {
		if(findPS() != null && c == 'r')
		{
			findPS().turn(10); //finds player ship, and changes dir right
		}		
		else if(findPS() != null && c == 'l')
			findPS().turn(-10);
		localNotifyObserver();

	}

	public void turnML(int dir) {
		if(findML() != null)
		{
			findML().turn(dir); //finds missile launcher, turns it
			System.out.println("Turning Missile Launcher!");
		}			
		localNotifyObserver();

	}

	public void firePMissile() {
		if(findML() != null && findPS().getMissileCount() != 0 && findPS() != null)
		{
			gameObjs.add(findPS().fireMissile()); //finds missile launcher, fires PS missile
			firedSound.play();
		}			
		else
			System.out.println("Sorry! Player Ship is all out of missiles!");
		
		
		localNotifyObserver();

	}

	public void fireEMissile() {
		if(findES() != null && findES().getMissileCount() != 0 && findPS() != null)
		{
			gameObjs.add(findES().fire()); //finds ES, fires missile
			firedSound.play();

		}			
		else
			System.out.println("Enemy Ship is all out of missiles!");
		localNotifyObserver();

	}

	public void resetPos() {
		if(findPS() != null)
		{
			findPS().resetPos(GWWidth/2.0,GWHeight/2.0); //finds PS and resets position to center of screen		
		}		
		localNotifyObserver();

	}
		
	


	public void removeAsteroid() {
		if(findAst() != null)
		{
			gameObjs.remove(findAst()); //finds first asteroid and removes that asteroid
		}		
		localNotifyObserver();

	}
	

	public void missileStrikePS() {
		if(findPS() != null && findEMissile() != null)
		{
			gameObjs.remove(findPS());
			gameObjs.remove(findEMissile());
		}
		if(playerLives <= 1)
		{
			gameOver();
		}
		else
		{
			System.out.println("Sorry, a missile struck your ship and destroyed it!");	
		playerLives--;
		addObj('s');
		}
		localNotifyObserver();
		
	}
	
	public void missileStrikeAst() { //missileStrikeAst
		if(findAst() != null && findMissile() != null)
		{
			gameObjs.remove(findES());
			gameObjs.remove(findMissile());  //any missile
			score = score +1000;
		}
		localNotifyObserver();

	}
	
	
	public void eliminate() { //missileStrikeNPS
		if(findES() != null && findPMissile() != null)
		{
			gameObjs.remove(findES());
			gameObjs.remove(findPMissile());
			score = score +1000;
		}
		localNotifyObserver();

	}

	public void gameOver() {
		System.out.println("Sorry! Your ship was destroyed! Game OVER! \nYour Stats\n--------------------------------------------\n\n");
		endSound.play();
		endGameStats();
		setEndGame(true);
		localNotifyObserver();


	}

	public void asteroidStrikePS() {
		if(findPS() != null && findAst() != null)
		{
			gameObjs.remove(findPS());
			gameObjs.remove(findAst());
			if(playerLives == 1)
				gameOver();
			else
			{
				playerLives--;
				addObj('s');
			}
		}		
		localNotifyObserver();

	}

	public void NPSStrikePS() {
		if(findES() != null && findPS() != null)
		{
			gameObjs.remove(findPS());
			gameObjs.remove(findES());
			if(playerLives == 1)
				gameOver();
			else
			{
				playerLives--;
				addObj('s');
			}
		}				
		localNotifyObserver();

	}

	public void asteroidCollision() {
		if(findAst() != null)
		{
			int astCount =0;
			for(int i=0;i<gameObjs.getSize();i++)
			{
				if(gameObjs.getObjAt(i) instanceof Asteroid)
					astCount++;
			}
			if(astCount >= 2) //require two or more asteroids for a collision
			{
				gameObjs.remove(findAst());
				gameObjs.remove(findAst());
			}
		}
		localNotifyObserver();

	}

	public void asteroidStrikeNPS() {
		if(findES() != null && findAst() != null)
		{
			gameObjs.remove(findES());
			gameObjs.remove(findAst());
		}				
		localNotifyObserver();

	}

	

	public void printGameState() {
		System.out.println("Score: "+ score);
		if(findPS() != null)
			System.out.println("Missiles Left: "+findPS().getMissileCount());
		System.out.println("Game Time: " + elapsedTime +"\n");
		System.out.println("Lives Left: "+ playerLives);
		
		localNotifyObserver();

	}
	
	public void endGameStats()
	{
		System.out.println("Score:  "+ score);
		System.out.println("Game Time: "+elapsedTime);
		System.out.println("Lives left: "+playerLives);
	}

	public void printGameMap() {
		for(int i=0; i <  gameObjs.getSize(); i++)
		{
			if(!(gameObjs.getObjAt(i) instanceof MissileLauncher))
				System.out.println(gameObjs.getObjAt(i));
		}
		localNotifyObserver();

	}

	public void exitGame() {
		System.out.println("Are you sure you want to exit the game?");
		
		// TODO Auto-generated method stub
		
	}


	public void loadPMissile() {
			PlayerShip 	pS = findPS();
			SpaceStation sS = findSS();
			if(pS != null && sS != null)
			{
				pS.reloadMissiles();
				numMissiles = 10;
			}
			localNotifyObserver();

			
	}
	


	
	private void localNotifyObserver()
	{
		GameWorldProxy prox = new GameWorldProxy(this);
		this.setChanged();
		this.notifyObservers(prox);

		
		
	}
	
	public void clkTick(double elapsedTime) {
	     /*
	      * Things to do when clock ticks-
	      * - move objects, check fuel levels of missiles
	      * - have spaceship blink
	      * -tick the clock
	      */
		
			IIterator iterator = gameObjs.getIterator();
			
			localNotifyObserver();

			while(iterator.hasNext())
			{
				GameObject obj = iterator.getNext();
				if(obj instanceof IMoveable)
				{
					IMoveable moveObj = (IMoveable) obj;
					
					moveObj.Move(GWWidth,GWHeight,elapsedTime); //finding each moveable object and moving it
					localNotifyObserver();

					if(moveObj instanceof Missile)
					{
							Missile missileObj = (Missile) moveObj;
							missileObj.burnFuel();
							localNotifyObserver();

						if(missileObj.getFuel() == 0 && missileObj.getisFriendly())
						{
							iterator.remove(missileObj); // //if object is missile and fuel level is 0, remove it.

						}
						if(!missileObj.getisFriendly() && missileObj.getFuel() == 0)
							fireEMissile();							
						localNotifyObserver();
						
					}
					else if(moveObj instanceof PlayerShip)
					{
						((PlayerShip)moveObj).launcherMove();
						numMissiles = ((PlayerShip)moveObj).getMissileCount();
						localNotifyObserver();

					}
					else if(moveObj instanceof EnemyShip)
					{
						((EnemyShip)moveObj).launcherMove();
						localNotifyObserver();

					}
				}
				else if(obj instanceof SpaceStation)
				{
					SpaceStation stationObj = (SpaceStation) obj;
					if(this.elapsedTime % 1000 == 0)
						stationObj.blinkCounter(); //increase blink counter on space ship
					localNotifyObserver();

				}
				
				
			}
			CheckCollisions();
			this.elapsedTime += elapsedTime;
			localNotifyObserver();

		}

	private void CheckCollisions() {
		IIterator iter = gameObjs.getIterator();
		while(iter.hasNext())
		{
			GameObject thisObj = iter.getNext();
			if(thisObj instanceof ICollider)
			{
				ICollider thisColliderObj = (ICollider) thisObj;
				IIterator otherIter = gameObjs.getIterator();
				while(otherIter.hasNext())
				{
					GameObject otherObj = otherIter.getNext();
					if(otherObj instanceof ICollider && !(thisObj.equals(otherObj)))
					{
						ICollider otherColliderObj = (ICollider) otherObj;
						
						if(thisColliderObj.collidesWith(otherColliderObj))
						{
							thisColliderObj.handleCollision(otherColliderObj);
							
						}
					}
				}
			}
		}
		removeCollidedObjects();
		localNotifyObserver();
	}
	private void removeCollidedObjects()
	{
		IIterator iter = gameObjs.getIterator();
		
		while(iter.hasNext())
		{
			GameObject obj = iter.getNext();
			if (obj instanceof ICollider && ((ICollider)obj).getCollisionFlag())
			{
				iter.remove(obj);
				if (obj instanceof PlayerShip)
				{
					loseLife();
					if (playerLives > 0)
					{						
						addObj('s');
					}
				}
				else if (obj instanceof Missile)
				{
					if (((Missile)obj).getisFriendly())
					{
						score += ((Missile)obj).getScore();
						if (((Missile)obj).getScore() > 0 )
						{
							missileSound.play();
						}
					}
					else if (((Missile)obj).getisFriendly())
					{
						findEMissile();
					}
				}
			}
		}
	}
	public void RefuelMissile() {
		// TODO Auto-generated method stub
		IIterator iterator = gameObjs.getIterator();
		while(iterator.hasNext())
		{
			GameObject curObj = iterator.getNext();
			if(curObj instanceof Missile && ((Missile) curObj).isSelected())
			{
				((Missile)curObj).resetFuel();
				break;
				
			}
		}
		
	}

}

