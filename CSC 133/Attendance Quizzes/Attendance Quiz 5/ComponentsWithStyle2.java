package com.mycompany.sampleui;

import java.io.IOException;
import java.io.InputStream;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
public class ComponentsWithStyle2 extends Form {
	  public ComponentsWithStyle2 ()  {
		  Button button1 = new Button("Plain button");
		  Button button2 = new Button("Button with style");
			//change background and foreground colors of the unselected style of the button
		  button2.getUnselectedStyle().setBgTransparency(255);
		  button2.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		  button2.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		  //[use button2.getAllStyles() to set all styles (selected, pressed, disabled, etc.) of the component at once]
		  //add padding to all styles of button2
		  button2.getAllStyles().setPadding(Component.TOP, 10);
		  button2.getAllStyles().setPadding(Component.BOTTOM, 10);
		  //[you can also add padding to left and right by using Component.LEFT and Component.RIGHT] 
		  addComponent(button1);
		  addComponent(button2);
		  
		    //add button1 and button2 as shown in the previous example
			//set a background image for all styles of the form
		    //[copy the images directly under src  directory]
			InputStream is = Display.getInstance().getResourceAsStream(getClass(),"/icon.png");
			try {
			  Image i = Image.createImage(is);
			  this.getAllStyles().setBgImage(i);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//set an image for the unselected style of the button
			Button button3 = new Button("Expand");
		
			button3.getAllStyles().setPadding(Component.TOP, 10);
			//[if necessary, also add padding to bottom, left, right, etc]
			is = Display.getInstance().getResourceAsStream(getClass(), "/Expanding.png");
			//[copy the images directly under src  directory]
			try {
			  Image i = Image.createImage(is);
			  button3.getUnselectedStyle().setBgImage(i);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			addComponent(button3);

		    this.show(); //not listed in the rest of the examples
		}
	}