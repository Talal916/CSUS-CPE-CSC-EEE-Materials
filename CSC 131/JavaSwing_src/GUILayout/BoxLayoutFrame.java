package GUILayout;

import java.awt.*;
import javax.swing.*;

/**
 * A frame that illustrates template layout with the BoxLayout manager
 *
 */
public class BoxLayoutFrame extends JFrame {
	Container contentPane;
	JButton cancelButton, okButton;
	JLabel textLabel, titleLabel;

	/**
	 * Default constructor
	 */
	public BoxLayoutFrame() {
		contentPane = getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		titleLabel = new JLabel();
		titleLabel.setText("An Example of Template Layout");
		contentPane.add(titleLabel);

		contentPane.add(Box.createHorizontalStrut(200));
		//contentPane.add(Box.createHorizontalGlue());
		//contentPane.add(Box.createRigidArea(new Dimension(200,100)));

		textLabel = new JLabel("Another Label");
		contentPane.add(textLabel);

		okButton = new JButton();
		okButton.setText("OK");
		contentPane.add(okButton);

		cancelButton = new JButton();
		cancelButton.setText("Cancel");
		contentPane.add(cancelButton);

		//contentPane.add(Box.createHorizontalGlue());
	}

}
