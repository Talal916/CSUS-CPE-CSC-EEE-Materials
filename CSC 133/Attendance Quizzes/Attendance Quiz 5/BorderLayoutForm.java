package com.mycompany.sampleui;

import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;

public class BorderLayoutForm extends Form{//not listed in the rest
	  public BorderLayoutForm() {		   //of the examples
	    //default layout for container is FlowLayout, change it to BorderLayout
	    this.setLayout(new BorderLayout());
	    //add a label to the top area of border layout
	  //add a label to the top area of border layout
	    Label myLabel = new Label("I am the label at north");
	    this.add(BorderLayout.NORTH, myLabel);
	    //... [add a check box to BorderLayout.WEST, a combo box to BorderLayout.SOUTH]
		CheckBox myCheck = new CheckBox("I am a CheckBox");
		this.add(BorderLayout.WEST, myCheck);


	    //create a button to add to the center area 
	    Button myButton = new Button("I am a button with style");
	    //...[set style of the button and add it to BorderLayout.CENTER]
	    this.add(BorderLayout.CENTER, myButton);
	    //add other labels to the left area of border layout
	    Label myLabel2 = new Label("I am the first label added to east");
	    this.add(BorderLayout.EAST, myLabel2);
	    //[THIS LABEL WILL NOT BE VISIBLE, see upcoming slides for a solution]
	    Label myLabel3 = new Label("I am the second label added to east");
	    this.add(BorderLayout.EAST, myLabel3);
	    this.show();
	    }
	}