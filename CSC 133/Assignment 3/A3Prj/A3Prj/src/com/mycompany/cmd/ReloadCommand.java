package com.mycompany.cmd;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class ReloadCommand extends Command 
{
	private GameWorld gw;
	

	public ReloadCommand(GameWorld gw)
	{
		super("Reload missiles");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		gw.loadPMissile();
		System.out.println("Reload missiles");
	}
}
