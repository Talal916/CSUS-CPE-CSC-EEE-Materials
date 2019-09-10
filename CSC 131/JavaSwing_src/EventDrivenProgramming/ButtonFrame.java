package EventDrivenProgramming;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * An example that uses buttons
 *
 */
public class ButtonFrame extends JFrame implements ActionListener {
	Container contentPane;
	JButton cancelButton, okButton;
	JLabel titleLabel;

	/**
	 * Default constructor
	 */
	public ButtonFrame() {
		super("A Really Amazing Window!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Get the content pane
		contentPane = getContentPane();
		contentPane.setLayout(null);

		// Construct the widgets.components
		titleLabel = new JLabel("A Button Example");
		okButton = new JButton("OK");
		cancelButton = new JButton("Cancel");

		// Layout the content pane
		contentPane.add(titleLabel);
		titleLabel.setBounds(60, 20, 290, 30);

		contentPane.add(okButton);
		okButton.setBounds(190, 210, 60, 30);

		contentPane.add(cancelButton);
		cancelButton.setBounds(260, 210, 90, 30);

		// Make this object an ActionListener on the buttons
		okButton.addActionListener(this);
		cancelButton.addActionListener(this);
	}

	/**
	 * Handle actionPerformed message (required by ActionListener)
	 *
	 * @param event
	 *            The ActionEvent that generated this message
	 */
	public void actionPerformed(ActionEvent event) {
		String command;

		command = event.getActionCommand();
		if (command.equals("Cancel")) {
			titleLabel.setText("You can't cancel me!");
		} else if (command.equals("OK")) {
			titleLabel.setText("I'm OK, you're not.");
		}
	}

}