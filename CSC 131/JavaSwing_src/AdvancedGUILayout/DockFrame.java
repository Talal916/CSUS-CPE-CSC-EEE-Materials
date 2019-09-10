package AdvancedGUILayout;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * A frame that illustrates the use of buttons
 * and docking tool bars
 *
 */
public class DockFrame extends JFrame implements ActionListener
{
    Container      contentPane;
    JButton        cancelButton, okButton;
    JLabel         titleLabel;
    JTextArea      messageArea;


    /**
     * Default constructor
     */
    public DockFrame()
    {
        JToolBar     toolBar;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        titleLabel = new JLabel();
        titleLabel.setText("A Button Example");
        contentPane.add(titleLabel, BorderLayout.NORTH);

        messageArea = new JTextArea(40,20);
        contentPane.add(messageArea, BorderLayout.CENTER);

          // This is new
          toolBar = new JToolBar();

          okButton = new JButton();
          okButton.setText("OK");
          okButton.setActionCommand("okButton");
          okButton.setMnemonic('O');
          okButton.addActionListener(this);
          // This is new
          toolBar.add(okButton);

          cancelButton = new JButton();
          cancelButton.setText("Cancel");
          cancelButton.setActionCommand("cancelButton");
          cancelButton.setMnemonic('C');
          cancelButton.addActionListener(this);
          // This is new
          toolBar.add(cancelButton);

        // This is new
        contentPane.add(toolBar, BorderLayout.SOUTH);

    }

    /**
     * Handle actionPerformed messages
     *
     * @param ae  The ActionEvent that generated the message 
     */
    public void actionPerformed(ActionEvent ae)
    {
       messageArea.append(ae.getActionCommand()+"\n");
    }

}
