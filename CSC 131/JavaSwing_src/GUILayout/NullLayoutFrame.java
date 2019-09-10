package GUILayout;

import java.awt.*;
import javax.swing.*;

/**
 * A frame that illustrates absolute layout with the null layout manager
 *
 */
public class NullLayoutFrame extends JFrame {
	Container contentPane;
	JButton cancelButton, okButton;
	JLabel titleLabel;

	/**
	 * Default constructor
	 */
	public NullLayoutFrame() {
		super("A Really Amazing Window!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = getContentPane();
		contentPane.setLayout(null);

		titleLabel = new JLabel("An Example of Absolute Layout");
		contentPane.add(titleLabel);
		titleLabel.setBounds(60, 20, 290, 30);

		okButton = new JButton("OK");
		contentPane.add(okButton);
		okButton.setBounds(190, 210, 60, 30);

		cancelButton = new JButton("Cancel");
		contentPane.add(cancelButton);
		cancelButton.setBounds(260, 210, 90, 30);
	}

}
