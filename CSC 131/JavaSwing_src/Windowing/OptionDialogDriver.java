package Windowing;

import javax.swing.*;

/**
 * An example that uses a standard option dialog box
 *
 */
public class OptionDialogDriver {

	/**
	 * The entry point
	 *
	 * @param args
	 *            The command line arguments
	 */
	public static void main(String[] args) {
		int result;

		result = JOptionPane.showOptionDialog(null, "Do you want to retry?", "Error!", JOptionPane.YES_NO_OPTION,
				JOptionPane.ERROR_MESSAGE, null, null, null);

		if (result == JOptionPane.CLOSED_OPTION) {
			System.out.println("Closed the window");
		} else if (result == 0) {
			System.out.println("Yes");
		} else if (result == 1) {
			System.out.println("No");
		}
	}
}
