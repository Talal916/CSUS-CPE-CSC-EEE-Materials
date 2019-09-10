package com.mycompany.cmd;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class PShipAddCommand extends Command 
{
	private GameWorld gw;
	
	/**
	 * Creates a button command to spawn a player ship
	 * @param gw - Reference to game world to invoke appropriate method
	 */
	public PShipAddCommand(GameWorld gw)
	{
		super("Add player ship");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		gw.addObj('s');
		System.out.println("Add player ship");
	}
}
