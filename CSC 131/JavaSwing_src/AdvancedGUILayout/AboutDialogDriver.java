package AdvancedGUILayout;

import java.awt.*;

import AdvancedGUILayout.AboutDialog;



/**
 * An example that uses the AboutDialog
 *
 */
public class AboutDialogDriver
{

    /**
     * The entry point
     *
     * @param args  The command line arguments
     */
    public static void main(String[] args)
    {
        AboutDialog           about;
        CloseableFrame        f;



        f = new CloseableFrame();
        about = new AboutDialog(f, "JMUnicycle",
                                "JMUnicycle is a three-dimensional\n"+
                                "unicycle simulator.  What makes\n"+
                                "this particular simulator unique is\n"+
                                "that when you have an accident the\n"+
                                "blood gushes in slow motion."
                                );
        about.setVisible(true);

    }


}

