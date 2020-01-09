package EventDrivenProgramming;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

/**
 * A frame that illustrates the use of combo boxes. Note that this frame listens
 * to events itself.
 *
*/
public class ComboBoxFrame extends JFrame implements ItemListener {
	Container contentPane;
	JComboBox comboBox;
	JLabel titleLabel;

	/**
	 * Default constructor
	 */
	public ComboBoxFrame() {
		String[] data;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		data = new String[7];
		contentPane = getContentPane();

		contentPane.setLayout(new BorderLayout());

		titleLabel = new JLabel();
		titleLabel.setText("A ComboBox Example");
		contentPane.add(titleLabel, BorderLayout.NORTH);

		data[0] = "CSC130";
		data[1] = "CSC131";
		data[2] = "CSC132";
		data[3] = "CSC133";
		data[4] = "CSC134";
		data[5] = "CSC135";
		data[6] = "CSC136";

		comboBox = new JComboBox(data);
		comboBox.addItemListener(this);
		comboBox.setEditable(true);

		contentPane.add(comboBox, BorderLayout.SOUTH);
	}

	/**
	 * Handle itemStateChanged events (required by ItemListener)
	 *
	 * @param e
	 *            The event
	 */
	public void itemStateChanged(ItemEvent e) {
		int state;
		String selected;

		selected = (String) (e.getItem());
		state = e.getStateChange();

		if (state == ItemEvent.SELECTED) {
			System.out.println("Selected: " + selected);
		}
	}

}