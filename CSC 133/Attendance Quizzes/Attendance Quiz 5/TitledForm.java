package com.mycompany.sampleui;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
/** This class creates a "Form" that has a title specified by the user
 *  User types the title on a
 */
public class TitledForm extends Form {
public TitledForm() {  
		Command cOk = new Command("Ok");
		Command cCancel = new Command("Cancel");
		Command[] cmds = new Command[]{cOk, cCancel};
		TextField myTF = new TextField();
		Command c = Dialog.show("Enter the title:", myTF, cmds);
		//[if you only want to display the okay option, you do not need to
		//create cmds, just use Dialog.show("Enter the title:", myTF, cOk);]
		if (c == cOk)
			this.setTitle(myTF.getText());
		else
			this.setTitle("Title not specified");
		this.show();	
	}
}
