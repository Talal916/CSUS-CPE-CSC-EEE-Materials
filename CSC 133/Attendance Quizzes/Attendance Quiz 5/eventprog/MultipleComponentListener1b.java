package com.mycompany.eventprog;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

/** Code for a form with a single button which the form listens to. */
public class MultipleComponentListener1b extends Form implements ActionListener {
	  private Button buttonOne = new Button("Button One"); //need to make this button a class field
	  public MultipleComponentListener1b () {
	    setTitle("Multiple Component Listener");
	    Button buttonTwo = new Button("Button Two");
	    //...[set styles of the buttons and add them to form]
	    buttonOne.addActionListener(this);
	    buttonTwo.addActionListener(this);
	    this.add(buttonOne);
	    this.add(buttonTwo);
	    show();
	   }
	  public void actionPerformed(ActionEvent evt) {
	    if(evt.getComponent().equals(buttonOne)){ //buttonOne must be a class field
	      System.out.println ("Button One Pushed (printed from the form using getComponent())...");
	    }
	    else if(((Button)evt.getComponent()).getText().equals("Button Two")){
	      //if we change the label of the button, this code would not work 	
	      System.out.println ("Button Two Pushed (printed from the form using getComponent().getText())...");
	    }//else if
	  }//actionPerformed

}


