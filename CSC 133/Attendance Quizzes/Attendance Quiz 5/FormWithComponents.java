package com.mycompany.sampleui;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Component;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
public class FormWithComponents extends Form {
	  public FormWithComponents () {
			// create a new label object
			Label myLabel = new Label("I am a Label");
			// add the label to the "content pane" of the form
			this.getContentPane().addComponent(myLabel);
			// [you can also call this.addComponent(myLabel) or simply this.add(myLabel)]
			// create a button and add
			Button myButton = new Button("I am a Button");
			this.addComponent(myButton);
			// create a checkbox and add
			CheckBox myCheck = new CheckBox("I am a CheckBox");
			this.addComponent(myCheck);
			// add a combo box (drop-down list) and add
			ComboBox myCombo = new ComboBox("Choice 1","Choice 2","Choice 3");
			this.addComponent(myCombo);
			this.show();
		  }

}