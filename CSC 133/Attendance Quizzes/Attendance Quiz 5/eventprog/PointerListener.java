package com.mycompany.eventprog;

import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

public class PointerListener implements ActionListener {
	public void actionPerformed(ActionEvent evt) {
		System.out.println("Pointer x and y: " + evt.getX() + " " + evt.getY());
	}
}
