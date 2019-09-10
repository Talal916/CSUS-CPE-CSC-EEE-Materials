package com.mycompany.cmd;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class SSAddCommand extends Command 
{
	private GameWorld gw;
	
	/**
	 * Creates a button command to spawn a space station
	 * @param gw - Reference to game world to invoke appropriate method
	 */
	public SSAddCommand(GameWorld gw)
	{
		super("Add space station");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		gw.addObj('b');
		System.out.println("Add space station");
	}
}
