package com.mycompany.eventprog;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;

/** This class instantiates several command objects, creates several GUI
 * components (button, side menu item, title bar item), and attaches the command objects     
 * to the GUI components and keys.  The command objects then automatically get invoked 
 * when the GUI component or the key is activated.
 */

public class CommandPatternForm extends Form {
  public CommandPatternForm () {
    //...[set a Toolbar to form]
   Button buttonOne = new Button("Button One"); 
   Button buttonTwo = new Button("Button Two");
   Toolbar myToolbar = new Toolbar();
   setToolbar(myToolbar);//
    //...[style and add two bottons to the form]
   //create command objects and set them to buttons, notice that labels of buttons   
   //are set to command names
   CutCommand myCutCommand = new CutCommand();
   DeleteCommand myDeleteCommand = new DeleteCommand();
   buttonOne.setCommand(myCutCommand);
   buttonTwo.setCommand(myDeleteCommand);
    //add cut commnand to the right side of title bar area 
   myToolbar.addCommandToRightBar(myCutCommand);
   //add delete command to the side menu
   myToolbar.addCommandToSideMenu(myDeleteCommand);
    //bind 'c' ket to cut command and 'd' key to delete command
   addKeyListener('c', myCutCommand);
   addKeyListener('d', myDeleteCommand);
   show();
   }
}

