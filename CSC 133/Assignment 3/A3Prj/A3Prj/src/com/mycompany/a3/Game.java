package com.mycompany.a3;

import com.codename1.ui.Form;   
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;



import com.codename1.ui.CheckBox; 
import com.codename1.ui.Container;

import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.UITimer;
import com.mycompany.cmd.*;

import java.lang.String;


public class Game extends Form implements Runnable {
	
	private final double TIMETOTICK =20;
	private GameWorld gw;
	private boolean waitGameEnd = false;
	private boolean returnGame = false;
	private boolean pauseState = false;
	private UITimer timer;
	private Toolbar menu;
	private int timeElapsed = 0;
	private BGSound bg;
	private PointsView pv;
	private MapView mv;
	private buttonObj refuelButton;
	private buttonObj addAsteroid;
	private buttonObj addEnemy;
	private buttonObj addStation;
	private buttonObj playerButton;
	private buttonObj accelButton;
	private buttonObj decelButton;
	private buttonObj leftButton;
	private buttonObj rightButton;
	private buttonObj launcherLeftButton;
	private buttonObj launcherRightButton;
	private buttonObj fireButton;
	private buttonObj enemyFireButton;
	private buttonObj jumpButton;
	private buttonObj reloadButton;
	private buttonObj pShootAstButton;
	private buttonObj playerShootsEnemyButton;
	private buttonObj enemyShootsPlayerButton;
	private buttonObj pAstCollisionButton;
	private buttonObj pEnemyCollideButton;
	private buttonObj astCollisionButton;
	private buttonObj eAstCollisionButton;
	private buttonObj clockButton;
	private buttonObj gamePauseButton;
	private PauseCommand pauseCmd;
	private AddAstCommand astButton;
	private EShipAddCommand enemyButton;
	private SSAddCommand ssButton;
	private PShipAddCommand addPlayer;
	private AccelCommand accelerateCommand;
	private DeccelCommand deccelerateCommand;
	private PShipLCommand leftCommand;
	private PShipRCommand rightCommand;
	private LauncherLCommand launcherLeftCMD;
	private LauncherRCommand launcherRightCMD;
	private FirePMissileCommand fireCommand;
	private WarpCommand jumpCommand;
	private ReloadCommand reloadCommand;

	private RefuelCommand refuelCommand;
	private static String versionTitle = "Asteroids Game"; //change for Play store uploads
	

	
	public Game()
	{
		
		
		
		
		this.setLayout(new BorderLayout());
		this.setScrollable(false);
		gw = new GameWorld();
		mv = new MapView();
		pv = new PointsView();

		gw.addObserver(mv);
		gw.addObserver(pv);
		
		setUp();
		
		this.addComponent(BorderLayout.NORTH, pv);
		this.addComponent(BorderLayout.CENTER, mv);
		
		gw.init();
		this.show();
		
		
		gw.setGWHeight(mv.getMapHeight());
		gw.setGWWidth(mv.getMapWidth());
		
		timer  =  new UITimer(this);
		
		timer.schedule((int)TIMETOTICK,true, this);
		bg = new BGSound("bg.wav");
		bg.play();
	
	}
	
	private void setUp() {
			setUPMenu();
			setUpCMD();
			
	}



	private void setUPMenu() {
			Toolbar menu = new Toolbar();
			this.setToolbar(menu);
			menu.setTitle(versionTitle);
			NewGameCommand newGame = new NewGameCommand();
			menu.addCommandToSideMenu(newGame);
			
			SaveCommand saveCommand = new SaveCommand();
			menu.addCommandToSideMenu(saveCommand);
			
			UndoCommand undoCommand = new UndoCommand();
			menu.addCommandToSideMenu(undoCommand);
			
			CheckBox soundOn = new CheckBox("Sound");
			SoundCmd soundCommand = new SoundCmd(gw, soundOn);
			soundOn.setCommand(soundCommand);
			menu.addCommandToSideMenu(soundCommand);
			
			
			AboutCmd aboutCommand = new AboutCmd();
			menu.addCommandToSideMenu(aboutCommand);
			
			QuitCommand quit = new QuitCommand();
			menu.addCommandToSideMenu(quit);
			
			
	}

	
	
	
	@Override
	public void run()
	{
		gw.clkTick(TIMETOTICK);
		timeElapsed += TIMETOTICK;
		
		if (timeElapsed >= 5000 && timeElapsed % 500 == 0)
		{
			int roll = RandomClass.getRandInt(0, 100);
			if (roll <= 5) //5 percent chance to spawn enemy ship
			{
				gw.addObj('s'); // spawn enemy ship
			}
		}
		
		if (gw.getLives() == 0)
		{
			bg.pause();
			timer.cancel();
			gw.gameOver();
		}
	}//run()
	
	
	
	private void setUpCMD() {
		Container mainContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));

		
		 astButton = new AddAstCommand(gw);
		 addAsteroid = new buttonObj(astButton);
		mainContainer.add(addAsteroid);

 		 enemyButton = new EShipAddCommand(gw);
		 addEnemy = new buttonObj(enemyButton);
		mainContainer.add(addEnemy);
		
		 ssButton = new SSAddCommand(gw);
		 addStation = new buttonObj(ssButton);
		mainContainer.add(addStation);
 		
 		 addPlayer = new PShipAddCommand(gw);
		 playerButton = new buttonObj(addPlayer);
		mainContainer.add(playerButton);
 		
 		 accelerateCommand = new AccelCommand(gw);
		 accelButton = new buttonObj(accelerateCommand);
		addKeyListener('w', accelerateCommand);
		addKeyListener(-91, accelerateCommand);
		mainContainer.add(accelButton);
 		
 		 deccelerateCommand = new DeccelCommand(gw);
		 decelButton= new buttonObj(deccelerateCommand);
		addKeyListener('s', deccelerateCommand);
		addKeyListener(-92, deccelerateCommand);
		mainContainer.add(decelButton);
 		
 		 leftCommand = new PShipLCommand(gw);
		 leftButton = new buttonObj(leftCommand);
		addKeyListener('a', leftCommand);
		addKeyListener(-93, leftCommand);
		mainContainer.add(leftButton);
 		
		 rightCommand = new PShipRCommand(gw);
		 rightButton = new buttonObj(rightCommand);
		addKeyListener('d', rightCommand);
		addKeyListener(-94, rightCommand);
		mainContainer.add(rightButton);
		
		 launcherLeftCMD = new LauncherLCommand(gw);
		 launcherLeftButton = new buttonObj(launcherLeftCMD);
		addKeyListener(44, launcherLeftCMD);
		mainContainer.add(launcherLeftButton);
		
		 launcherRightCMD = new LauncherRCommand(gw);
		 launcherRightButton = new buttonObj(launcherRightCMD);
		addKeyListener(46, launcherRightCMD);
		mainContainer.add(launcherRightButton);
		
		 fireCommand = new FirePMissileCommand(gw);
		 fireButton = new buttonObj(fireCommand);
		addKeyListener(-90, fireCommand);
		mainContainer.add(fireButton);

		 jumpCommand = new WarpCommand(gw);
		 jumpButton = new buttonObj(jumpCommand);
		addKeyListener('j', jumpCommand);
		mainContainer.add(jumpButton);
		
		 reloadCommand = new ReloadCommand(gw);
		 reloadButton = new buttonObj(reloadCommand);
		addKeyListener('r', reloadCommand);
		mainContainer.add(reloadButton);
		

		
		 pauseCmd = new PauseCommand(this);
		 gamePauseButton = new buttonObj(pauseCmd);
		 this.addKeyListener('p', pauseCmd);
		mainContainer.add(gamePauseButton);
		
		 refuelCommand = new RefuelCommand(gw);
		 refuelButton = new buttonObj(refuelCommand);
		refuelButton.setEnabled(false);
		mainContainer.add(refuelButton);
		
		mv.setWidth(this.getWidth() - mainContainer.getPreferredW() - mv.getX());
		
		this.addComponent(BorderLayout.WEST, mainContainer);
		
	}
	
	public void pauseGame()
	{
		this.pauseState = !pauseState;
		
		addAsteroid.setEnabled(!addAsteroid.isEnabled());
		addStation.setEnabled(!addStation.isEnabled());
		playerButton.setEnabled(!playerButton.isEnabled());
		accelButton.setEnabled(!accelButton.isEnabled());
		decelButton.setEnabled(!decelButton.isEnabled());
		leftButton.setEnabled(!leftButton.isEnabled());
		rightButton.setEnabled(!rightButton.isEnabled());
		launcherLeftButton.setEnabled(!launcherLeftButton.isEnabled());
		launcherRightButton.setEnabled(!launcherRightButton.isEnabled());
		fireButton.setEnabled(!fireButton.isEnabled());
		jumpButton.setEnabled(!jumpButton.isEnabled());
		refuelButton.setEnabled(!refuelButton.isEnabled());
		
		if(pauseState)
		{
			timer.cancel();
			bg.pause();
			gamePauseButton.setText("Resume");
			
			

			removeKeyListener('w', accelerateCommand);
			removeKeyListener(-91, accelerateCommand);
	 		

			removeKeyListener('s', deccelerateCommand);
			removeKeyListener(-92, deccelerateCommand);

			removeKeyListener('a', leftCommand);
			removeKeyListener(-93, leftCommand);

			removeKeyListener('d', rightCommand);
			removeKeyListener(-94, rightCommand);
			
 			removeKeyListener(44, launcherLeftCMD);
 			
  			removeKeyListener(46, launcherRightCMD);
 			
 			removeKeyListener(-90, fireCommand);
 			
 			
 			removeKeyListener('j', jumpCommand);
 			
 			removeKeyListener('r', reloadCommand);
 			
	 
	 
			
		 
		 
 			removeKeyListener('p', pauseCmd);
			
			
		}
		else
		{
			timer.schedule((int)TIMETOTICK, true, this);
			bg.play();
			gamePauseButton.setText("Pause");
			
			

			addKeyListener('w', accelerateCommand);
			addKeyListener(-91, accelerateCommand);
	 		

			addKeyListener('s', deccelerateCommand);
			addKeyListener(-92, deccelerateCommand);

			addKeyListener('a', leftCommand);
			addKeyListener(-93, leftCommand);

			addKeyListener('d', rightCommand);
			addKeyListener(-94, rightCommand);
			
 			addKeyListener(44, launcherLeftCMD);
 			
  			addKeyListener(46, launcherRightCMD);
 			
 			addKeyListener(-90, fireCommand);
 			
 			
 			addKeyListener('j', jumpCommand);
 			
 			addKeyListener('r', reloadCommand);
 			
	 
	 
			
		 
		 
 			addKeyListener('p', pauseCmd);
 			
		}

	}

}



