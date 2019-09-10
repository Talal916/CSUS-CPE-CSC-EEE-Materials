package com.mycompany.eventprog;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

/** These classes define a Command which perform "cut" and "delete" operations. 
 *  The commands are implemented as a subclass of Command, allowing it
 *  to be added to any object supporting attachment of Commands. 
 *  This example does not show how the "Target" of the command is specified.
 */

public class CutCommand extends Command{
  public CutCommand() {
    super("Cut"); //do not forget to call parent constructor with command_name
  }
  @Override //do not forget @Override, makes sure you are overriding parent method
  //invoked to perform the 'cut' operation
  public void actionPerformed(ActionEvent ev){
    System.out.println("CSC-133 Students: Cut command is invoked...");
  }
}
