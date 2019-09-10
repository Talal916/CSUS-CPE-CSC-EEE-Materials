package Windowing;

import javax.swing.*;

/**
 * A frame that illustrates the use of menu bars. Note that this frame listens
 * to events itself.
 *
 */
public class MenuBarFrame extends JFrame {
	JMenuBar menuBar;
	JMenu editMenu, fileMenu, helpMenu;
	JMenuItem item;

	/**
	 * Default constructor
	 */
	public MenuBarFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		menuBar = new JMenuBar();

		// The File menu
		fileMenu = new JMenu("File");

		item = new JMenuItem("Exit");
		fileMenu.add(item);
		menuBar.add(fileMenu);

		// The Edit menu
		editMenu = new JMenu("Edit");

		item = new JMenuItem("Cut");
		editMenu.add(item);

		item = new JMenuItem("Paste");
		editMenu.add(item);

		menuBar.add(editMenu);

		// The Help menu
		helpMenu = new JMenu("Help");

		item = new JMenuItem("About");
		helpMenu.add(item);

		menuBar.add(helpMenu);

		// The menu bar
		setJMenuBar(menuBar);
	}
}
