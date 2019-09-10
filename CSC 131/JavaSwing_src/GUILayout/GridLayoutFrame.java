package GUILayout;

import java.awt.*;
import javax.swing.*;

/**
 * A frame that illustrates template layout with the GridLayout manager
 *
 */
public class GridLayoutFrame extends JFrame {
	Container contentPane;
	JButton cancelButton, okButton;
	JLabel titleLabel;
	JTextArea textArea;

	/**
	 * Default constructor
	 */
	public GridLayoutFrame() {
		contentPane = getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane.setLayout(new GridLayout(2, 2));

		titleLabel = new JLabel();
		titleLabel.setText("An Example of Template Layout");
		contentPane.add(titleLabel);

		//textArea = new JTextArea(40, 20);
		//contentPane.add(textArea);

		okButton = new JButton();
		okButton.setText("OK");
		contentPane.add(okButton);

		cancelButton = new JButton();
		cancelButton.setText("Cancel");
		contentPane.add(cancelButton);
	}

}
