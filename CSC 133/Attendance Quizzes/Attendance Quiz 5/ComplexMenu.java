package com.mycompany.sampleui;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;

public class ComplexMenu extends Form{//not listed in the rest
	 public ComplexMenu() {		   //of the examples
		 
		Toolbar myToolbar = new Toolbar();
		setToolbar(myToolbar);//make sure to use lower-case "b", setToolBar() is depreciated
		//add a text field to the title
		TextField myTF = new TextField("CSC133");
		myToolbar.setTitleComponent(myTF);
		 
		Command titleBarAreaItem2 = new Command("Title Bar Area Item 2");
		myToolbar.addCommandToLeftBar(titleBarAreaItem2);

		CheckBox myCheck = new CheckBox("I am a CheckBox");
	    this.addComponent(myCheck);

		 /* Code for a form which has a CheckBox as a side menu item*/
		//add a check box to side menu (which does not perform any operation yet..)
		Command sideMenuItemCheck = new Command("Side Menu Item Check ");
		CheckBox checkSideMenuComp = new CheckBox("Check Side Menu Component");
		//set the style of the check box
		checkSideMenuComp.getAllStyles().setBgTransparency(255);
		checkSideMenuComp.getAllStyles().setBgColor(ColorUtil.LTGRAY);
		//set "SideComponent" property of the command object to the check box
		sideMenuItemCheck.putClientProperty("SideComponent", checkSideMenuComp);
		
		Command sideMenuItem1 = new Command("Side Menu Item 1");
		myToolbar.addCommandToSideMenu(sideMenuItem1);

		Command sideMenuItem2 = new Command("Side Menu Item 2");
		myToolbar.addCommandToSideMenu(sideMenuItem2);
		
		//add the command to the side menu, this places its side component (check box) in the side menu
		myToolbar.addComponentToSideMenu(checkSideMenuComp);
		this.show();
	}
}