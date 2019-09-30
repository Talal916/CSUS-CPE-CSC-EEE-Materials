//Talal Jawaid
// 4 x 1 Multiplexer Code
// CSC 137
// Professor Weide Chang
// No Array Version


module MuxMod(s1,s0,d0,d1,d2,d3,o);package com.mycompany.a1;

import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import java.lang.String;


public class Game extends Form {
	
	private GameWorld gw;
	
	public Game()
	{
		gw = new GameWorld();
		gw.init();
		play();
		
	}
	
	private void play()
	{
		Label myLabel = new Label("Enter a Command:");
		this.addComponent(myLabel);
		final TextField myTextField = new TextField();
		this.addComponent(myTextField);
		this.show();
		myTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt)
			{
				String sCommand = myTextField.getText().toString();
				myTextField.clear();
				
				if(!sCommand.equals(null) && sCommand.length() > 0) //&& !gameover
				{
					switch (sCommand.charAt(0))
					{
	
						case 'a': // add a new asteroid to the world 
							//method call to add asteroid
							gw.addObj('a');
							break;
						case 'y':
							//method call to add NPS to world
							gw.addObj('y');
							break;
						case 'b':
							//method call to add a new blinking space station to the world
							gw.addObj('b');
							break;
						case 's':
							//method call to add a PS to the world
							gw.addObj('s');
							break;
						case 'i': 
							gw.changeSpeed('i');
							//increase the speed of the PS by a small amount
							break;
						case 'd':
							gw.changeSpeed('d');
							//decrease the speed of the PS by a small amount, but not negative
							break;
						case 'l':
							gw.turnPS('l');
							//turn PS left by a small amount counter clockwise
							break;
						case 'r':
							gw.turnPS('r');
							//turn PS right by a small amount clock wise 
							break;
						case '>': 
							gw.turnML();
							//controls direction of PS's missile launcher
							//by revolving about center of PS in c.c direction
							break;
						case 'f':
							gw.firePMissile();
							//fire missile from front of PS
							//if no missiles remaining, display err message
							break;
						case 'L': 
							gw.fireEMissile();
							//launch a missile from front of NPS
							//if no missiles, display err msg
						case 'j':
							gw.resetPos();
							//jumps PS to center of initial default position screen
							break;
						case 'n':
							gw.loadPMissile();
							//load new supply of missiles into PS
							break;
						case 'k':
							gw.removeObj('A');
							//remove asteroid killed by PS and increment player score
							break;
						case 'e': //if letter e is input
							gw.eliminate(); 
							//eliminate gameworld.
							break;
						
						case 'E':
							gw.missileStrikePS();
							//remove missile and PS after a missile has struck a PS
							break;
						case 'c':
							gw.asteroidStrikePS();
							//PS crashed into asteroid, remove ship and asteroid 
							//decrement the count of lives left
							//game is over if no lives left
							break;
						case 'h':
							gw.NPSStrikePS();
							//the PS has hit a NPS, remove NPS and decrement lives left
							break;
						case 'x':
							gw.asteroidCollision();
							//two asteroids have collided
							//remove two asteroids from game
							break;
						case 'I':
							gw.asteroidStrikeNPS();
							//asteroid impacted NPS, remove both from game
							break;
						case 't':
							gw.clkTick();
							//game clock has ticked
							//updated game state variables
							break;
						case 'p':
							gw.printGameState();
							//print display of current game state values
							break;
						case 'm':
							gw.printGameMap();
							//print a map showing the current world state
							break;
						case 'q':
							//terminate program by using System.exit(0);
							System.exit(0);
							break;
						default:
							System.out.println("\nInput is invalid\n");
					} // switch (sCommand.chartAt(0))
				} //if sCommand not null
			} //public void actionPerformed(ActionEvent evt)
		} //myTextField.addActionListener(new ActionListener()
		
		); //myTextField.addActionListener(

	} // private void play()
}




	input s1,s0,d0,d1,d2,d3;
	output o;

	wire s1NOT, s0NOT, a0,a1,a2,a3,a4,a5,a6,a7,or0,or1;

	not(s1NOT,s1);
	not(s0NOT,s0);
	and(a0,d0,s1NOT);
	and(a1, a0,s0NOT);
	and(a2, d1,s1NOT);
	and(a3,a2,s0);
	and(a4,d2,s1);
	and(a5, a4, s0NOT);
	and(a6, d3,s1);
	and(a7, a6, s0);
	or(or0,a1,a3);
	or(or1,a5,a7);
	or(o,or0,or1);
endmodule

module TestMod;

	reg s1,s0,d0,d1,d2,d3;
	wire o;

	MuxMod test(s1,s0,d0,d1,d2,d3,o);

	initial begin
		$display("  Time s1 s0 d0 d1 d2 d3 o");
		$display("---------------------------------");
		$monitor("%5d %2b %2b %2b %2b %2b %2b %2b",
		$time ,s1 ,s0 ,d0 ,d1,d2,d3,o);
	end

	initial begin
		 s1=0;s0=0;d0=0;d1=0;d2=0;d3=0;//1
	     #1  s1=0;s0=0;d0=0;d1=0;d2=0;d3=1;
	     #1	 s1=0;s0=0;d0=0;d1=0;d2=1;d3=0;
 	     #1	 s1=0;s0=0;d0=0;d1=0;d2=1;d3=1;
	     #1	 s1=0;s0=0;d0=0;d1=1;d2=0;d3=0;
	#1	 s1=0;s0=0;d0=0;d1=1;d2=0;d3=1;
	#1	 s1=0;s0=0;d0=0;d1=1;d2=1;d3=0;
	#1	 s1=0;s0=0;d0=0;d1=1;d2=1;d3=1;
 	#1	 s1=0;s0=0;d0=1;d1=0;d2=0;d3=0;
	#1	 s1=0;s0=0;d0=1;d1=0;d2=0;d3=1;//10
	#1	 s1=0;s0=0;d0=1;d1=0;d2=1;d3=0;
	#1	 s1=0;s0=0;d0=1;d1=0;d2=1;d3=1;
	#1	 s1=0;s0=0;d0=1;d1=1;d2=0;d3=0;
	#1	 s1=0;s0=0;d0=1;d1=1;d2=0;d3=1;
	#1	 s1=0;s0=0;d0=1;d1=1;d2=1;d3=0;
	#1	 s1=0;s0=0;d0=1;d1=1;d2=1;d3=1;
	#1	 s1=0;s0=1;d0=0;d1=0;d2=0;d3=0;
	#1	 s1=0;s0=1;d0=0;d1=0;d2=0;d3=1;
	#1	 s1=0;s0=1;d0=0;d1=0;d2=1;d3=0;
	#1	 s1=0;s0=1;d0=0;d1=0;d2=1;d3=1;//20
	#1	 s1=0;s0=1;d0=0;d1=1;d2=0;d3=0;
	#1	 s1=0;s0=1;d0=0;d1=1;d2=0;d3=1;
	#1	 s1=0;s0=1;d0=0;d1=1;d2=1;d3=0;
	#1	 s1=0;s0=1;d0=0;d1=1;d2=1;d3=1;
	#1	 s1=0;s0=1;d0=1;d1=0;d2=0;d3=0;
	#1	 s1=0;s0=1;d0=1;d1=0;d2=0;d3=1;
	#1	 s1=0;s0=1;d0=1;d1=0;d2=1;d3=0;
	#1	 s1=0;s0=1;d0=1;d1=0;d2=1;d3=1;
	#1	 s1=0;s0=1;d0=1;d1=1;d2=0;d3=0;
	#1	 s1=0;s0=1;d0=1;d1=1;d2=0;d3=1;//30
	#1	 s1=0;s0=1;d0=1;d1=1;d2=1;d3=0;
	#1	 s1=0;s0=1;d0=1;d1=1;d2=1;d3=1;
	#1	 s1=1;s0=0;d0=0;d1=0;d2=0;d3=0;
	#1	 s1=1;s0=0;d0=0;d1=0;d2=0;d3=1;
	#1	 s1=1;s0=0;d0=0;d1=0;d2=1;d3=0;
	#1	 s1=1;s0=0;d0=0;d1=0;d2=1;d3=1;
	#1	 s1=1;s0=0;d0=0;d1=1;d2=0;d3=0;
	#1	 s1=1;s0=0;d0=0;d1=1;d2=0;d3=1;
	#1	 s1=1;s0=0;d0=0;d1=1;d2=1;d3=0;
	#1	 s1=1;s0=0;d0=0;d1=1;d2=1;d3=1;//40
	#1	 s1=1;s0=0;d0=1;d1=0;d2=0;d3=0;
	#1	 s1=1;s0=0;d0=1;d1=0;d2=0;d3=1;
	#1	 s1=1;s0=0;d0=1;d1=0;d2=1;d3=0;
	#1	 s1=1;s0=0;d0=1;d1=0;d2=1;d3=1;
	#1	 s1=1;s0=0;d0=1;d1=1;d2=0;d3=0;
	#1	 s1=1;s0=0;d0=1;d1=1;d2=0;d3=1;
	#1	 s1=1;s0=0;d0=1;d1=1;d2=1;d3=0;
	#1	 s1=1;s0=0;d0=1;d1=1;d2=1;d3=1;
	#1	 s1=1;s0=1;d0=0;d1=0;d2=0;d3=0;
	#1	 s1=1;s0=1;d0=0;d1=0;d2=0;d3=1;//50
	#1	 s1=1;s0=1;d0=0;d1=0;d2=1;d3=0;
	#1	 s1=1;s0=1;d0=0;d1=0;d2=1;d3=1;
	#1	 s1=1;s0=1;d0=0;d1=1;d2=0;d3=0;
	#1	 s1=1;s0=1;d0=0;d1=1;d2=0;d3=1;
	#1	 s1=1;s0=1;d0=0;d1=1;d2=1;d3=0;
	#1	 s1=1;s0=1;d0=0;d1=1;d2=1;d3=1;
	#1	 s1=1;s0=1;d0=1;d1=0;d2=0;d3=0;
	#1	 s1=1;s0=1;d0=1;d1=0;d2=0;d3=1;
	#1	 s1=1;s0=1;d0=1;d1=0;d2=1;d3=0;
	#1	 s1=1;s0=1;d0=1;d1=0;d2=1;d3=1;//60
	#1	 s1=1;s0=1;d0=1;d1=1;d2=0;d3=0;
	#1	 s1=1;s0=1;d0=1;d1=1;d2=0;d3=1;
	#1	 s1=1;s0=1;d0=1;d1=1;d2=1;d3=0;
	#1	 s1=1;s0=1;d0=1;d1=1;d2=1;d3=1;
	end
endmodule

