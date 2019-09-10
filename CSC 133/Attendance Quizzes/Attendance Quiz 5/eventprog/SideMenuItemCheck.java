package com.mycompany.eventprog;

import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class SideMenuItemCheck extends Command {
	  private SideMenuItemCheckFormUsingCommand myForm;
	  public SideMenuItemCheck (SideMenuItemCheckFormUsingCommand fForm){
	    super("Side Menu Check"); //do not forget to set the "command name
	    myForm = fForm;
	  }
	@Override
	public void actionPerformed(ActionEvent evt){
	  if (((CheckBox)evt.getComponent()).isSelected())//getComponent() returns the component 					        //that generated the event
	    myForm.setCheckStatusVal(true);
	  else
	    myForm.setCheckStatusVal(false);
	  }//actionPerformed
}// SideMenuItemCheck class
