package com.mycompany.A1Prj;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener; 
import com.codename1.ui.Label; 
import com.codename1.ui.TextField;  
import com.codename1.ui.events.ActionEvent; 
import java.lang.String;

public class Game extends Form {
	private GameWorld gw;
	
	public Game()
	{
		gw = new GameWorld();
		play();
	}
	
	private void play()
	{
		Label myLabel=new Label("Enter a Command:"); 
		this.addComponent(myLabel); 
		final TextField myTextField=new TextField(); 
		this.addComponent(myTextField);  
		this.show(); 
		myTextField.addActionListener(new ActionListener(){ 
			 
			public void actionPerformed(ActionEvent evt) { 
			 
			String sCommand=myTextField.getText().toString(); 
			myTextField.clear();  
			switch (sCommand.charAt(0)){ 
			case 'a':
				gw.addNewAsteroid();
				break;
			case 'y':
				gw.addNonPlayerShip();
				break;
			case 'b':
				gw.addSpaceStation();
				break;
			case 's':
				gw.addPlayerShip();
				break;
			case 'i':
				gw.changeSpeed(1);
				break;
			case 'd':
				gw.changeSpeed(-1);
				break;
			case 'l':
				gw.turnShip(15);
				break;
			case 'r':
				gw.turnShip(-15);
				break;
			case '<':
				gw.RotateLauncher(15);
				break;
			case 'f':
				gw.firePlayerMissile();
				break;
			case 'L':
				gw.fireNonPlayerMissile();
				break;
			case 'j':
				gw.jumpSpace();
				break;
			case 'n':
				gw.loadNewMissile();
				break;
			case 'k':
				gw.playerHitAsteroid();
				break;
			case 'e':
				gw.playerHitNonPlayerShip();
				break;
			case 'E':
				gw.nonPlayerHitPlayer(); 
				break;
			case 'c':
				gw.playerCrashAsteroid();
				break;
			case 'h':
				gw.playerCrashNonPlayer();
				break;
			case 'x':
				gw.asteroidCrashAsteroid();
				break;
			case 'I':
				gw.asteroidCrashNonPlayer();
				break;
			case 't':
				gw.gameClock();
				break;		
			case 'p':
				gw.print();
				break;
			case 'm':
				gw.map();
				break;
			case 'q':
				gw.quit();
				break;
				
				} //switch  
			} //actionPerformed 
		}//new ActionListener()  
		);//addActionListener 
	}	//play
			
}

