package com.mycompany.cmd;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class AboutCmd extends Command 
{
	/**
	 * Creates a command for side menu for info on program.
	 */
	public AboutCmd() 
	{
		super("About");
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String info = "Talal Jawaid\nAsteroid Assignment\nCSC 133\nProfessor Doan Nguyen";
		Dialog.show("About", info, "Ok", null);
	}
}
