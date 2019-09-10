package com.mycompany.eventprog;

import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
/** This class acts as a listener for ActionEvents.
 *  It was designed to be attached and respond
 *  to button-push events.
 */ 
public class ButtonListener implements ActionListener{
// Action Listener method:  called from the object being observed
// (e.g. a  button) when it generates an "Action Event"
// (which is what a button-click does)
		public void actionPerformed(ActionEvent evt) {
				// we get here because the object being observed 
				// generated an Action Event
			System.out.println ("Button Pushed...");
		}
}

