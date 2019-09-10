package com.mycompany.eventprog;

import com.codename1.ui.Button;
import com.codename1.ui.Form;

/** Code for a form with a single button which the form listens to. */
public class ButtonListenerForm extends Form {
	  //need to make this button a class field
	  public ButtonListenerForm () {
	    Button buttonOne = new Button("Button One"); 
	    add(buttonOne);
		ButtonListener myButtonListener = new ButtonListener ();
	    buttonOne.addActionListener(myButtonListener);
	    show();
	   }
}


