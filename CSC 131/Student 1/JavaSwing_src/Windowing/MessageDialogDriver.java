package Windowing;

import javax.swing.*;

/**
 * An example that uses a standard message dialog box
 *
 */
public class MessageDialogDriver {

	/**
	 * The entry point
	 *
	 * @param args
	 *            The command line arguments
	 */
	public static void main(String[] args) {
		ImageIcon icon;

		System.out.println("Before the dialogs...");

		JOptionPane.showMessageDialog(null, "The power will be shut off in 5 minutes!");

		JOptionPane.showMessageDialog(null, "Please do it right!", "Error", JOptionPane.ERROR_MESSAGE);

		// Possible types:
		//
		// PLAIN_MESSAGE, INFORMATION_MESSAGE, WARNING_MESSGAE
		// QUESTION_MESSAGE, ERROR_MESSAGE

		icon = new ImageIcon("C:/Users/Jingwei/OneDrive/@FAll 2018/CSC 131/Week07/sacstate.gif");

		JOptionPane.showMessageDialog(null, "Welcome to Sac State", "SacState",
				JOptionPane.INFORMATION_MESSAGE, icon);

		System.out.println("After the dialogs...");
	}
}
