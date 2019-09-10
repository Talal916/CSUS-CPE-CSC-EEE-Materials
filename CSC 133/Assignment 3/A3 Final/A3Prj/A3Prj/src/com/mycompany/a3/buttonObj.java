package com.mycompany.a3;


import com.codename1.charts.util.ColorUtil; 
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.plaf.Border;


public class buttonObj extends Button{
	
	public buttonObj(Command cmd)
	{
		this.getAllStyles().setBgTransparency(255);
		this.getAllStyles().setBorder(Border.createBevelRaised());
		this.getAllStyles().setBorder(Border.createBevelLowered());
		this.getAllStyles().setBorder(Border.createDoubleBorder(2,ColorUtil.GRAY));
		this.getAllStyles().setMargin(TOP,1);
		this.getAllStyles().setMargin(BOTTOM,1);
		this.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 100, 100));
		this.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
		this.getPressedStyle().setBgTransparency(125);
		this.getPressedStyle().setBgColor(ColorUtil.rgb(0, 100, 100));
		this.getPressedStyle().setFgColor(ColorUtil.BLUE);
		this.getDisabledStyle().setBgTransparency(255);
		this.getDisabledStyle().setBgColor(ColorUtil.GRAY);
		this.getDisabledStyle().setFgColor(ColorUtil.BLUE);
		this.getDisabledStyle().setStrikeThru(true);
		this.setFocusable(false);
		this.setCommand(cmd);
	}
	

}
