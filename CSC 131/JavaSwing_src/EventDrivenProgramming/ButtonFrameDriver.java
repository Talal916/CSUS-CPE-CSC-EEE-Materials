package EventDrivenProgramming;

import java.awt.*;
import javax.swing.*;


/**
 * An example that uses a button
 *
 */
public class ButtonFrameDriver
{

    /**
     * The entry point of the example
     *
     * @param args   The command line arguments
     */
    public static void main(String[] args)
    {
        ButtonFrame   window;


        window = new ButtonFrame();
        window.setSize(400,400);
        window.setVisible(true);
    }
}
