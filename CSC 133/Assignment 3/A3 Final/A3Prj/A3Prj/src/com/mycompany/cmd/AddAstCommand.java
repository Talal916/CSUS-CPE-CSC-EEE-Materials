package com.mycompany.cmd;

import com.codename1.ui.Command; 
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class AddAstCommand extends Command
{
	private GameWorld gw;
	
	/**
	 * 
	 * @param gw
	 */
	public AddAstCommand(GameWorld gw)
	{
		super("Add asteroid");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		gw.addObj('a');
		System.out.println("Add asteroid");
	}
}
