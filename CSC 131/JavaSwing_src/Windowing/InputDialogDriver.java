package Windowing;

import javax.swing.*;

/**
 * An example that uses a standard input dialog box
 *
 */
public class InputDialogDriver {

	/**
	 * The entry point
	 *
	 * @param args
	 *            The command line arguments
	 */
	public static void main(String[] args) {
		ImageIcon icon;
		String response;
		String[] schools;

		response = JOptionPane.showInputDialog("What is your favorite University");

		System.out.println("\n\n\n\n");
		if (response == null) {
			System.out.println("I asked a question and" + "I expect an answer!");
		} else {
			if (response.equals("Sac State")) {
				System.out.println("Yes! Sac State rules!");
			} else {
				System.out.println("Are you kidding? " + response + "?");

				icon = new ImageIcon("C:/Users/Jingwei/OneDrive/@FAll 2018/CSC 131/Week07/sacstate.gif");

				schools = new String[5];
				schools[0] = "San Jose State";
				schools[1] = "Sac State";
				schools[2] = "San Francisco State";
				schools[3] = "Chico State";
				schools[4] = "Sonoma State";

				response = (String) JOptionPane.showInputDialog(null, "What is your favorite University?",
						"University Selection", JOptionPane.QUESTION_MESSAGE, icon, schools, schools[1]);

				System.out.println(response);
			}
		}

		System.out.println("\n\n\n\n");

	}
}
