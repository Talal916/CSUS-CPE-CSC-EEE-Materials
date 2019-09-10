package GUILayout;

import java.awt.*;
import javax.swing.*;

/**
 * A frame that illustrates template layout with the BorderLayout manager
 *
 */
public class BorderLayoutFrame extends JFrame {
	Container contentPane;
	JButton cancelButton, okButton;
	JLabel titleLabel, note;
	JTextArea textArea;

	/**
	 * Default constructor
	 */
	public BorderLayoutFrame() {
		contentPane = getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane.setLayout(new BorderLayout());

		titleLabel = new JLabel();
		titleLabel.setText("An Example of Template Layout");
		contentPane.add(titleLabel, BorderLayout.NORTH);
		
		note = new JLabel();
		note.setText("This is a note.");
		//note.setHorizontalTextPosition(JLabel.CENTER);
		contentPane.add(note, BorderLayout.SOUTH);

		textArea = new JTextArea(40, 20);
		contentPane.add(textArea, BorderLayout.CENTER);

		//okButton = new JButton();
		//okButton.setText("OK");
		//contentPane.add(okButton, BorderLayout.WEST);

		cancelButton = new JButton();
		cancelButton.setText("Cancel");
		contentPane.add(cancelButton, BorderLayout.EAST);
	}

}