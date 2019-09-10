package GUILayout;

import java.awt.*;
import javax.swing.*;

/**
 * A frame that illustrates relative layout with the FlowLayout manager
 *
 */
public class FlowLayoutFrame extends CloseableFrame {
	Container contentPane;
	JButton cancelButton, okButton;
	JLabel titleLabel;
	JTextArea textArea;

	/**
	 * Default constructor
	 */
	public FlowLayoutFrame() {

		contentPane = getContentPane();

		contentPane.setLayout(new FlowLayout());

		titleLabel = new JLabel();
		titleLabel.setText("An Example of Relative Layout");
		contentPane.add(titleLabel);

		textArea = new JTextArea(40, 20);
		contentPane.add(textArea);

		okButton = new JButton();
		okButton.setText("OK");
		contentPane.add(okButton);

		cancelButton = new JButton();
		cancelButton.setText("Cancel");
		contentPane.add(cancelButton);
	}

}
