package EventDrivenProgramming;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

/**
 * A frame that illustrates the use of lists. Note that this frame listens to
 * events itself.
 *
 */
public class ListFrame extends JFrame implements ListSelectionListener {
	Container contentPane;
	JList list;
	JLabel titleLabel;

	/**
	 * Default constructor
	 */
	public ListFrame() {
		Document model;
		String[] data;

		data = new String[7];
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();

		contentPane.setLayout(new BorderLayout());

		titleLabel = new JLabel();
		titleLabel.setText("A List Example");
		contentPane.add(titleLabel, BorderLayout.NORTH);

		data[0] = "CSC130";
		data[1] = "CSC131";
		data[2] = "CSC132";
		data[3] = "CSC133";
		data[4] = "CSC134";
		data[5] = "CSC135";
		data[6] = "CSC136";

		list = new JList(data);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		//list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	

		list.addListSelectionListener(this);

		contentPane.add(list, BorderLayout.WEST);
	}

	/**
	 * Handle valueChanged events (required by ListSelectionListener)
	 *
	 * @param e
	 *            The event
	 */
	public void valueChanged(ListSelectionEvent e) {
		int i;
		JList list;
		Object[] selected;

		list = (JList) (e.getSource());
		selected = list.getSelectedValues();

		for (i = 0; i < selected.length; i++) {
			System.out.println((String) (selected[i]) + "\t" + e.getValueIsAdjusting());
		}
	}

}
