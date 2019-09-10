package com.mycompany.eventprog;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
//Contents of File  SimpleForm.java:
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class FormWithMultipleContainers extends Form {
	Container centerContainer, bottomContainer;

	public FormWithMultipleContainers(){
		//create the center container and add it to form
		/* Code for a form with containers in different layout arrangements */
		setLayout(new BorderLayout());
		//top Container with the GridLayout positioned on the north 
		Container topContainer = new Container(new GridLayout(1,2));
		topContainer.add(new Label("Read this (t)"));
		topContainer.add(new Button("Press Me (t)"));
		//Setting the Border Color
		topContainer.getAllStyles().setBorder(Border.createLineBorder(4,
														ColorUtil.YELLOW));
		add(BorderLayout.NORTH,topContainer);
		//left Container with the BoxLayout positioned on the west 
		Container leftContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		//start adding components at a location 50 pixels below the upper border of the container
		leftContainer.getAllStyles().setPadding(Component.TOP, 50);
		leftContainer.add(new Label("Text (l)"));
		leftContainer.add(new Button("Click Me (l)"));
		leftContainer.add(new ComboBox("Choice 1","Choice 2","Choice 3"));
		leftContainer.add(new CheckBox("Enable Printing (l)"));
		leftContainer.getAllStyles().setBorder(Border.createLineBorder(4,
														ColorUtil.BLUE));
		add(BorderLayout.WEST,leftContainer);	
		//right Container with the GridLayout positioned on the east 
		Container rightContainer = new Container(new GridLayout(4,1));
		//...[add similar components that exists on the left container]
		add(BorderLayout.EAST,rightContainer);
		//add empty container to the center
		Container centerContainer = new Container();
		//setting the back ground color of center container to light gray
		centerContainer.getAllStyles().setBgTransparency(255);
		centerContainer.getAllStyles().setBgColor(ColorUtil.LTGRAY);
		//setting the border Color
		centerContainer.getAllStyles().setBorder(Border.createLineBorder(4,
														ColorUtil.MAGENTA));
		add(BorderLayout.CENTER,centerContainer);
		//bottom Container with the FlowLayout positioned on the south, components are laid out //at the center 
		Container bottomContainer = new Container(new FlowLayout(Component.CENTER));
		//...[add similar components that exists on the top container] 
		bottomContainer.add(new Label("Read this (b)"));
		Button bPressMeB = new Button("Press Me (b)");
		bottomContainer.add(bPressMeB);
		bottomContainer.getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.BLUE));
		add(BorderLayout.SOUTH,bottomContainer);
		System.out.println("Center container width/height (printed BEFORE show()): "
				+ centerContainer.getWidth() + " " + centerContainer.getHeight());

		this.show();
		System.out.println("Center container width/height (printed AFTER show()): "
				+ centerContainer.getWidth() + " " + centerContainer.getHeight());

		
	}// constructor
}

