package GUILayout;

import java.awt.*;
import javax.swing.*;

/**
 * An example of template layout with the BoxLayout manager
 *
 * @version 1.0
 * @author  Prof. David Bernstein, James Madison Univeristy
 */
public class BoxLayoutDriver
{

    /**
     * The entry point of the example
     *
     * @param args   The command line arguments
     */
    public static void main(String[] args)
    {
        BoxLayoutFrame   f;


        f = new BoxLayoutFrame();
        f.setSize(400,400);
        f.setVisible(true);
    }
}
