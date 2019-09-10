package GUILayout;

import java.awt.*;
import javax.swing.*;


/**
 * An example of template layout with the BorderLayout manager
 *
 */
public class BorderLayoutDriver
{

    /**
     * The entry point of the example
     *
     * @param args   The command line arguments
     */
    public static void main(String[] args)
    {
        BorderLayoutFrame   f;


        f = new BorderLayoutFrame();
        f.setSize(400,400);
        f.setVisible(true);
    }
}
