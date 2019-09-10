package Windowing;

import java.awt.*;
import javax.swing.*;

/**
 * An example that uses a JFileChooser dialog box
 *
 */
public class FileDialogDriver {

	/**
	 * The entry point
	 *
	 * @param args
	 *            The command line arguments
	 */
	public static void main(String[] args) {
		JFrame f;
		Container contentPane;
		int retval;
		JFileChooser jfc;

		f = new JFrame();
		f.setSize(400, 200);

		contentPane = f.getContentPane();

		f.setVisible(true);

		jfc = new JFileChooser();
		retval = jfc.showOpenDialog(f);

		if (retval == JFileChooser.APPROVE_OPTION) {
			System.out.println(jfc.getSelectedFile().getName());
		}
	}

}
