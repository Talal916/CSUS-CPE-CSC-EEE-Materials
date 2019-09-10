package com.mycompany.cmd;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class LauncherRCommand extends Command 
{
	private GameWorld gw;
	
	/**
	 * Creates a button command to rotate missile launcher right
	 * @param gw - Reference to game world to invoke appropriate method
	 */
	public LauncherRCommand(GameWorld gw)
	{
		super("Rotate launcher right");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		gw.turnML(2);
		System.out.println("Rotate launcher right");
	}
}
