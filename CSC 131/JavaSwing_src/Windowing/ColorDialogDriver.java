package Windowing;

import java.awt.*;
import javax.swing.*;

/**
 * An example that uses a JColorChooser dialog box
 *
 */
public class ColorDialogDriver {

	/**
	 * The entry point
	 *
	 * @param args
	 *            The command line arguments
	 */
	public static void main(String[] args) {
		JFrame f;
		Color color;
		Container contentPane;

		f = new JFrame();
		f.setSize(400, 200);

		contentPane = f.getContentPane();

		f.setVisible(true);

		color = JColorChooser.showDialog(f, "Choose a color", Color.blue);

		if (color != null) {
			System.out.println(color);
		}
	}

}
