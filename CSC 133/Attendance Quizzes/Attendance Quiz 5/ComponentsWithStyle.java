package com.mycompany.sampleui;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Form;
public class ComponentsWithStyle extends Form {
	  public ComponentsWithStyle () {
		  Button button1 = new Button("Plain button");
		  Button button2 = new Button("Button with style");
			//change background and foreground colors of the unselected style of the button
		  button2.getUnselectedStyle().setBgTransparency(255);
		  button2.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		  button2.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		  //[use button2.getAllStyles() to set all styles (selected, pressed, disabled, etc.) of the component at once]
		  //add padding to all styles of button2
		  button2.getAllStyles().setPadding(Component.TOP, 10);
		  button2.getAllStyles().setPadding(Component.BOTTOM, 100);
		  //[you can also add padding to left and right by using Component.LEFT and Component.RIGHT] 
		  addComponent(button1);
		  addComponent(button2);
		  this.show(); //not listed in the rest of the examples
		}
	}