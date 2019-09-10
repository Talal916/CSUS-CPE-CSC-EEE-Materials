package com.mycompany.sampleui;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;

public class BoxLayoutDemo extends Form{//not listed in the rest
	  public BoxLayoutDemo() {		   //of the examples
		    Form hi = new Form("Box Y Layout", new BoxLayout(BoxLayout.Y_AXIS));
	        Label l1 = new Label("First");
	        l1.getAllStyles().setFgColor(ColorUtil.BLUE);
	        hi.add(l1);
	        
	        Label l2= new Label("Second");
	        l2.getAllStyles().setFgColor(ColorUtil.BLUE);
	        hi.add(l2);
	        
	        Label l3= new Label("Third");
	        l3.getAllStyles().setFgColor(ColorUtil.BLUE);
	        hi.add(l3);
	        
	        Label l4= new Label("Four");
	        l4.getAllStyles().setFgColor(ColorUtil.BLUE);
	        hi.add(l4);
	        
	        Label l5= new Label("Five");
	        l5.getAllStyles().setFgColor(ColorUtil.BLUE);
	        hi.add(l5);
	        
	        hi.show();
	    }
	}