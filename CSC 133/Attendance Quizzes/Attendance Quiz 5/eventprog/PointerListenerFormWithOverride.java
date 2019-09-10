package com.mycompany.eventprog;

import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;

public class PointerListenerFormWithOverride extends Form {
	public PointerListenerFormWithOverride() {
		// ...[set the form layout to borderlayout, generate and style buttons
		setLayout(new BorderLayout());
		// and
		// add them to on north and south containers]
		// have an empty container in the center and add a pointer pressed
		// listener to it
		PointerContainer myContainer = new PointerContainer();
		this.add(BorderLayout.CENTER, myContainer);
		show();
		
	}
}
