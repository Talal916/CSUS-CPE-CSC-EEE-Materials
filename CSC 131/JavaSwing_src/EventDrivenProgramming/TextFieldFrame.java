package EventDrivenProgramming;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

/**
 * A frame that illustrates the use of text fields Note that unlike the earlier
 * examples, this frame listens to events itself.
 *
 */
public class TextFieldFrame extends JFrame implements DocumentListener {
	Container contentPane;
	JTextArea textArea;
	JLabel titleLabel;

	/**
	 * Default constructor
	 */
	public TextFieldFrame() {
		Document model;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();

		contentPane.setLayout(new BorderLayout());

		titleLabel = new JLabel();
		titleLabel.setText("A TextField Example");
		contentPane.add(titleLabel, BorderLayout.NORTH);

		textArea = new JTextArea();
		model = textArea.getDocument();
		model.addDocumentListener(this);

		contentPane.add(textArea, BorderLayout.SOUTH);
	}

	/**
	 * Handle changedUpdate events (required by DocumentListener)
	 *
	 * @param e
	 *            The event
	 */
	public void changedUpdate(DocumentEvent e) {
		Document source;

		source = e.getDocument();

		try {
			System.out.println("In changeUpdate:\n" + source.getText(0, source.getLength()) + "\n\n");
		} catch (BadLocationException ble) {
			// Shouldn't get here
		}
	}

	/**
	 * Handle insertUpdate events (required by DocumentListener)
	 *
	 * @param e
	 *            The event
	 */
	public void insertUpdate(DocumentEvent e) {
		Document source;

		source = e.getDocument();

		try {
			System.out.println("In insertUpdate:\n" + source.getText(0, source.getLength()) + "\n\n");
		} catch (BadLocationException ble) {
			// Shouldn't get here
		}
	}

	/**
	 * Handle removeUpdate events (required by DocumentListener)
	 *
	 * @param e
	 *            The event
	 */
	public void removeUpdate(DocumentEvent e) {
		Document source;

		source = e.getDocument();

		try {
			System.out.println("In removeUpdate:\n" + source.getText(0, source.getLength()) + "\n\n");
		} catch (BadLocationException ble) {
			// Shouldn't get here
		}
	}

}
