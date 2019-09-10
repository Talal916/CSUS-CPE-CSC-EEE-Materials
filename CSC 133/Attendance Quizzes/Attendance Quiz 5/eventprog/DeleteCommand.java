package com.mycompany.eventprog;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class DeleteCommand extends Command{
	  public DeleteCommand() {
	    super("Delete");
	  }
	  @Override
	  public void actionPerformed(ActionEvent e){
	   System.out.println("CSC 133 Students: Delete command is invoked...");
	  }
	}
