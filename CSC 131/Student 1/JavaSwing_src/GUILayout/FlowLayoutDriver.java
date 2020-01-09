package GUILayout;

import java.awt.*;
import javax.swing.*;

import GUILayout.FlowLayoutFrame;


/**
 * An example of relative layout with the FlowLayout manager
 *
 */
public class FlowLayoutDriver
{

    /**
     * The entry point of the example
     *
     * @param args   The command line arguments
     */
    public static void main(String[] args)
    {
        FlowLayoutFrame   f;


        f = new FlowLayoutFrame();
        f.setSize(400,400);
        f.setVisible(true);
    }
}
