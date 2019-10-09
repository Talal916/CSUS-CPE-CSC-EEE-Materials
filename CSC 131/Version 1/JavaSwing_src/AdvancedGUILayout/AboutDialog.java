package AdvancedGUILayout;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * An "About" box
 *
 * This class illustrates the use of constrained template
 * layout (i.e., GridBagLayout)
 *
 */
public class AboutDialog extends    JDialog
   implements ActionListener
{

    /**
     * Constructor
     */
    public AboutDialog(Frame owner, String name, String description)
    {
       super(owner, "About "+name+"...", true);
       Container            contentPane;
       GridBagConstraints   gbc;
       GridBagLayout        gbl;
       JButton              button;
       JLabel               label;
       JTextArea            text;


       setSize(350,200);


       contentPane = getContentPane();
       gbl = new GridBagLayout();
       contentPane.setLayout(gbl);

       label = new JLabel(name, JLabel.CENTER);
       label.setFont(new Font("Sans Serif", Font.BOLD, 16));
       gbc = new GridBagConstraints();
       gbc.gridx = 1;
       gbc.gridy = 0;
       gbc.gridwidth = 3;
       gbc.gridheight = 1;
       gbc.fill = GridBagConstraints.HORIZONTAL;
       gbc.anchor = GridBagConstraints.CENTER;
       gbc.weightx = 100;
       gbc.weighty = 0;
       gbl.setConstraints(label, gbc);
       contentPane.add(label);


       label = new JLabel(" JMU ");
       label.setFont(new Font("Sans Serif", Font.PLAIN, 40));
       gbc = new GridBagConstraints();
       gbc.gridx = 0;
       gbc.gridy = 1;
       gbc.gridwidth = 1;
       gbc.gridheight = 3;
       gbc.fill = GridBagConstraints.NONE;
       gbc.anchor = GridBagConstraints.CENTER;
       gbl.setConstraints(label, gbc);
       contentPane.add(label);


       text = new JTextArea(20,20);
       text.append(description);
       text.setEditable(false);
       gbc = new GridBagConstraints();
       gbc.gridx = 1;
       gbc.gridy = 1;
       gbc.gridwidth = 3;
       gbc.gridheight = 3;
       gbc.fill = GridBagConstraints.BOTH;
       gbc.anchor = GridBagConstraints.WEST;
       gbc.weightx = 100;
       gbc.weighty = 100;
       gbl.setConstraints(text, gbc);
       contentPane.add(text);


       label = new JLabel("Copyright, James Madison University");
       label.setFont(new Font("Sans Serif", Font.PLAIN, 10));
       gbc = new GridBagConstraints();
       gbc.gridx = 0;
       gbc.gridy = 4;
       gbc.gridwidth = 3;
       gbc.gridheight = 1;
       gbc.fill = GridBagConstraints.NONE;
       gbc.anchor = GridBagConstraints.WEST;
       gbl.setConstraints(label, gbc);
       contentPane.add(label);


       button = new JButton("OK");
       button.addActionListener(this);
       gbc = new GridBagConstraints();
       gbc.gridx = 3;
       gbc.gridy = 4;
       gbc.gridwidth = 1;
       gbc.gridheight = 1;
       gbc.fill = GridBagConstraints.NONE;
       gbc.anchor = GridBagConstraints.EAST;
       gbl.setConstraints(button, gbc);
       contentPane.add(button);

    }




    /**
     * Handle actionPerformed events (required by ActionListener)
     *
     * @param evt   The event
     */
    public void actionPerformed(ActionEvent evt)
    {
       String command;


       command = evt.getActionCommand();
       if (command.equals("OK")) setVisible(false);
    }
}
