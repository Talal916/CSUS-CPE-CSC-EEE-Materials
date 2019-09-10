package GUILayout;

import java.awt.*;
import javax.swing.*;


/**
 * An example of absolute layout with the null layout manager
 *
 */
public class NullLayoutDriver
{

    /**
     * The entry point of the example
     *
     * @param args   The command line arguments
     */
    public static void main(String[] args)
    {
        NullLayoutFrame   f;


        f = new NullLayoutFrame();
        f.setSize(400,400);
        f.setVisible(true);
    }
}
