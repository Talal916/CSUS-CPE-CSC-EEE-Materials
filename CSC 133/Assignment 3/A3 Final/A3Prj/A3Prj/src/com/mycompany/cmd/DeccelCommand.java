package com.mycompany.cmd;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class DeccelCommand extends Command 
{
	private GameWorld gw;
	
	/**
	 * Creates a button command to decelerate the player
	 * @param gw - Reference to game world to invoke appropriate method
	 */
	public DeccelCommand(GameWorld gw)
	{
		super("Decelerate");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		gw.changeSpeed('d');
		System.out.println("Decelerate");
	}
}
