package com.mycompany.cmd;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class LauncherLCommand extends Command 
{
	private GameWorld gw;
	
	/**
	 * Creates a button command to rotate missile launcher left
	 * @param gw - Reference to game world to invoke appropriate method
	 */
	public LauncherLCommand(GameWorld gw)
	{
		super("Rotate launcher left");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		gw.turnML(-2);
		System.out.println("Rotate launcher left");
	}
}
