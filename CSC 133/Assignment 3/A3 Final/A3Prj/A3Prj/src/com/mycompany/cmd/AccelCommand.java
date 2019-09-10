package com.mycompany.cmd;

import com.codename1.ui.Command; 
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class AccelCommand extends Command 
{
	private GameWorld gw;
	
	/**
	 * Creates a button command to accelerate the player
	 * @param gw - Reference to game world to invoke appropriate method 
	 */
	public AccelCommand(GameWorld gw)
	{
		super("Accelerate");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		gw.changeSpeed('i');
		System.out.println("Accelerate");
	}
}
