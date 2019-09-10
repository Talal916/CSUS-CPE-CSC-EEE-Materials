package AdvancedGUILayout;

import java.awt.*;
import javax.swing.*;

//import gui.*;

/**
 * An example that uses Border
 *
 */
public class BorderExample
{

    public static void main(String[] args)
    {
       CloseableFrame    f;
       Container         contentPane;
       JPanel            p1, p2;



       f = new CloseableFrame();
       contentPane = f.getContentPane();

       contentPane.setLayout(new GridLayout(2,1));

       p1 = new JPanel();
       contentPane.add(p1);

       p2 = new JPanel();
       p2.setBorder(BorderFactory.createEtchedBorder());
       p2.add(new JLabel("This JPanel has a Border"));

       contentPane.add(p2);

       f.setVisible(true);

    }


}
