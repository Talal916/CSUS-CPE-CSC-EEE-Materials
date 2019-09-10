package com.mycompany.eventprog;

import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;

public class PointerListenerForm extends Form {
	public PointerListenerForm() {
		// ...[set the form layout to borderlayout, generate and style buttons
		setLayout(new BorderLayout());
		// and
		// add them to on north and south containers]
		// have an empty container in the center and add a pointer pressed
		// listener to it
		Container myContainer = new Container();
		PointerListener myPointerListener = new PointerListener();
		myContainer.addPointerPressedListener(myPointerListener);
		this.add(BorderLayout.CENTER, myContainer);
		show();
		
	}
}
