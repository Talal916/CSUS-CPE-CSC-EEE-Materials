package AdvancedGUILayout;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * A frame that illustrates the use of a scrollable text area.
 *
 */
public class ScrollFrame extends JFrame implements ActionListener
{
    Container       contentPane;
    ButtonGroup     group;
    JRadioButton    automobilesCB, planesCB, trainsCB;
    JLabel          titleLabel;
    JTextArea       messageArea;


    /**
     * Default constructor
     */
    public ScrollFrame()
    {
        JPanel       southPanel;
        JScrollPane  scrollPane;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = getContentPane();
        group = new ButtonGroup();


        contentPane.setLayout(new BorderLayout());

        titleLabel = new JLabel();
        titleLabel.setText("A Scrolling Example");
        contentPane.add(titleLabel, BorderLayout.NORTH);


        messageArea = new JTextArea(1,1);
        // This is new
        scrollPane = new JScrollPane(messageArea);
        contentPane.add(scrollPane, BorderLayout.CENTER);


          southPanel = new JPanel();
          southPanel.setLayout(new FlowLayout());

          planesCB = new JRadioButton("Planes");
          planesCB.setActionCommand("planesCB");
          planesCB.setMnemonic('P');
          planesCB.addActionListener(this);
          southPanel.add(planesCB);
          

          trainsCB = new JRadioButton("Trains");
          trainsCB.setActionCommand("trainsCB");
          trainsCB.setMnemonic('T');
          trainsCB.addActionListener(this);
          southPanel.add(trainsCB);

          automobilesCB = new JRadioButton("Automobiles");
          automobilesCB.setActionCommand("automobilesCB");
          automobilesCB.setMnemonic('A');
          automobilesCB.addActionListener(this);
          southPanel.add(automobilesCB);

        contentPane.add(southPanel, BorderLayout.SOUTH);


        group.add(planesCB);
        group.add(trainsCB);
        group.add(automobilesCB);
        
    }


    /**
     * Handle actionPerformed messages
     *
     * @param ae  The ActionEvent that generated the message
     */
    public void actionPerformed(ActionEvent ae)
    {
       messageArea.append(ae.getActionCommand()+"\n\n\n");
    }
    
}
