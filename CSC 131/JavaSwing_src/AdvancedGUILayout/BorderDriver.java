package AdvancedGUILayout;

import java.awt.*;
import javax.swing.*;

/**
 * An example that uses Border
 *
 */
public class BorderDriver
{

    public static void main(String[] args)
    {
       JFrame            f;
       Container         contentPane;
       JPanel            p1, p2;



       f = new JFrame();
       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       f.setSize(200,200);       
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
