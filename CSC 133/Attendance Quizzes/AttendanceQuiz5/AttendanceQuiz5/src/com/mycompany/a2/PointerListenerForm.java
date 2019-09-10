package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.contacts.Address;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.Border;

public class PointerListenerForm extends Form {
	public PointerListenerForm() {
			// ...[set the form layout to borderlayout, generate and style buttons
		setLayout(new BorderLayout());
		
		PointerContainer topCon = new PointerContainer();
//		topCon.getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.MAGENTA));
		topCon.add(new Label("Top Container"));
		this.add(BorderLayout.CENTER, topCon);

		PointerContainer centerCon = new PointerContainer();
		centerCon.getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.MAGENTA));
		centerCon.add(new Label("Center Container"));
		this.add(BorderLayout.CENTER, centerCon);
		
		
		PointerContainer rightCon = new PointerContainer();
		rightCon.getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.GREEN));
		rightCon.add(new Label("Right Container"));
		this.add(BorderLayout.EAST, rightCon);
		
		PointerContainer leftCon = new PointerContainer();
		leftCon.getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.YELLOW));
		leftCon.add(new Label("Left Container"));
		this.add(BorderLayout.WEST, leftCon);
		
		
		PointerContainer bottomCon = new PointerContainer();
		bottomCon.getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.GREEN));
		bottomCon.add(new Label("Bottom Container"));
		this.add(BorderLayout.SOUTH, bottomCon);
		
		
		Button leftB = new Button("Left Button");
		
		Button centerB = new Button("Release");
		centerB.setDropTarget(true);
		
		Button dragB = new Button("Drag");
		dragB.setDraggable(true);
		
		leftB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt)
			{
				System.out.println("Clicked left area");
			}
			
		});
		
		this.add(BorderLayout.WEST, leftB);
		
	
		
		centerB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt)
			{
				System.out.println("Dragged from Center region");
				System.out.println("Pointer DRAGGED X and Y: "+ centerB.getDraggedx()+ ","+centerB.getDraggedy());
			
			}
			
		});
		
		this.add(BorderLayout.CENTER, centerB);

		dragB.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent evt)
		{
			System.out.println("Pointer RELEASED X AND Y: "+ dragB.getDraggedx()+","+dragB.getDraggedy());
				
			
			
		}
		});
		
		this.add(BorderLayout.EAST, dragB);
		
		show();
		
		
		


	}
}
