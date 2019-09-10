package AdvancedGUILayout;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * A frame that illustrates the use of radio buttons. This version uses
 * hierarchical template layout.
 *
 */
public class HierarchicalLayoutFrame extends JFrame implements ActionListener {
	Container contentPane;
	JButton cancelButton, noButton, yesButton;
	JLabel titleLabel;
	JTextArea textArea;

	/**
	 * Default constructor
	 */
	public HierarchicalLayoutFrame() {
		JPanel southPanel;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = getContentPane();

		contentPane.setLayout(new BorderLayout());

		titleLabel = new JLabel();
		titleLabel.setText("An Example of Hierarchical Layout");
		contentPane.add(titleLabel, BorderLayout.NORTH);

		textArea = new JTextArea(40, 20);
		contentPane.add(textArea, BorderLayout.CENTER);

		southPanel = new JPanel();
		southPanel.setLayout(new FlowLayout());

		yesButton = new JButton("Oui");
		yesButton.setActionCommand("YES");
		yesButton.setMnemonic('O');
		yesButton.addActionListener(this);
		southPanel.add(yesButton);

		noButton = new JButton("Non");
		noButton.setActionCommand("NO");
		noButton.setMnemonic('N');
		noButton.addActionListener(this);
		southPanel.add(noButton);

		cancelButton = new JButton("Anuller");
		cancelButton.setActionCommand("CANCEL");
		cancelButton.setMnemonic('A');
		cancelButton.addActionListener(this);
		southPanel.add(cancelButton);

		contentPane.add(southPanel, BorderLayout.SOUTH);

	}

	/**
	 * Handle actionPerformed messages
	 *
	 * @param ae
	 *            The ActionEvent that generated the message
	 */
	public void actionPerformed(ActionEvent ae) {
		textArea.append(ae.getActionCommand() + "\n");
	}

}
