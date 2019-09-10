package com.mycompany.sampleui;

import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;

public class ClosingApp extends Form {
	  public ClosingApp() {
		    this.setTitle("Closing App Demo");
		    Boolean bOk = Dialog.show("Confirm quit", "Are you sure you want to quit?", "Ok", "Cancel");
		    //[in a dialog if you only want to display the okay option, 
		    //use Dialog.show("Title of dialog", "Text to display on dialog", "Ok", null);]
		    if (bOk){
		        	//instead of System.exit(0), CN1 recommends using:
		            // This helps to quit the application
			         Display.getInstance().exitApplication();
		    }
		    this.show();
		  }

}
