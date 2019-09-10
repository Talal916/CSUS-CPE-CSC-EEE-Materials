package com.mycompany.eventprog;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
//import com.codename1.ui.SideMenuBar;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;

public class SideMenuItemCheckFormUsingCommand extends Form {
	    private Label checkStatusVal = new Label("OFF");
	    public SideMenuItemCheckFormUsingCommand() {
    	  //...[add a Toolbar and some side menu items]	    	
	      Toolbar myToolbar = new Toolbar();	
	      this.setToolbar(myToolbar);
		  CheckBox checkSideMenuComp = new CheckBox("Check Side Menu Component");
		  checkSideMenuComp.getAllStyles().setBgTransparency(255);
		  checkSideMenuComp.getAllStyles().setBgColor(ColorUtil.LTGRAY);

		  //create a command object and set it as the command of check box
		  Command mySideMenuItemCheck = new SideMenuItemCheck(this);
		  checkSideMenuComp.setCommand(mySideMenuItemCheck);

		  //add the checkbox comp to the side menu, this places its side component (check box) 
		  //in the side menu
		  myToolbar.addComponentToSideMenu(checkSideMenuComp);
		  //add a label to indicate the check box value on the form, divide the label to two parts, text
		  //and value, and add padding to value part so that the labels looks stable when value changes
		  checkStatusVal.getAllStyles().setPadding(LEFT, 5);	
		  checkStatusVal.getAllStyles().setPadding(RIGHT,5);	
		  this.add(checkStatusVal);
		  this.show();
		}
	    public void setCheckStatusVal(boolean bVal){
		   if (bVal)
			    checkStatusVal.setText("ON");
		   else
			   checkStatusVal.setText("OFF");
	    } 
}
