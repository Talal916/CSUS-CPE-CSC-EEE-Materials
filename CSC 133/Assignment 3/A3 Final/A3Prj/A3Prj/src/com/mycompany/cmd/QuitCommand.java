package com.mycompany.cmd;

import com.codename1.ui.Command; 
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class QuitCommand extends Command 
{
	
	public QuitCommand()
	{
		super("Quit");
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (Dialog.show("Quit", "Do you want to quit the game?", "Yes", "No"))
		{
			System.exit(0);
		}
	}
}
