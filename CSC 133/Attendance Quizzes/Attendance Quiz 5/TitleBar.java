package com.mycompany.sampleui;
import com.codename1.ui.*;
 
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;

public class TitleBar extends Form{//not listed in the rest
	 public TitleBar() {		   //of the examples
		 /* Code for a form with a toolbar */
		 Toolbar myToolbar = new Toolbar();
		 setToolbar(myToolbar); //make sure to use lower-case "b", setToolBar() is depreciated
		 //add a text field to the title
		 TextField myTF = new TextField("CSC133");
		 myToolbar.setTitleComponent(myTF);
		 //[or you can simply have a text in the title: this.setTitle("Adding Items to Title Bar");]
		 //add an "empty" item (which does not perform any operation) to side menu
		 Command sideMenuItem1 = new Command("Side Menu Item 1");
		 myToolbar.addCommandToSideMenu(sideMenuItem1);
		 //add an "empty" item to overflow menu
		 Command overflowMenuItem1 = new Command("Overflow Menu Item 1");
		 myToolbar.addCommandToOverflowMenu(overflowMenuItem1);
		 //add an "empty" item to right side of title bar area
		 Command titleBarAreaItem1 = new Command("Title Bar Area Item 1");
		 myToolbar.addCommandToRightBar(titleBarAreaItem1);
		 //add an "empty" item to left side of title bar area
		 Command titleBarAreaItem2 = new Command("Title Bar Area Item 2");
		 myToolbar.addCommandToLeftBar(titleBarAreaItem2);
		 //...[add other side menu, overflow menu, and/or title bar area items]
		 this.show();
	}
}
