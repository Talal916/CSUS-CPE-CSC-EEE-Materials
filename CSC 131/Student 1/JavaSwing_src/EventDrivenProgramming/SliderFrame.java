package EventDrivenProgramming;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * An example that uses a slider
 *
 */
public class SliderFrame extends JFrame implements ChangeListener {
	Container contentPane;
	JSlider slider;
	JLabel titleLabel;

	/**
	 * Default constructor
	 */
	public SliderFrame() {
		super("A Really Amazing Window!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Get the content pane
		contentPane = getContentPane();
		contentPane.setLayout(null);

		// Construct the widgets.components
		titleLabel = new JLabel("A Slider Example");
		slider = new JSlider(0, 100, 50);

		// Layout the content pane
		contentPane.add(titleLabel);
		titleLabel.setBounds(60, 20, 150, 30);

		contentPane.add(slider);
		slider.setBounds(60, 100, 290, 30);

		// Make this object an ChangeListener on the slider
		slider.addChangeListener(this);
	}

	/**
	 * Handle stateChanged message (required by ChangeListener)
	 *
	 * @param event
	 *            The ActionEvent that generated this message
	 */
	public void stateChanged(ChangeEvent event) {
		int value;
		Object source;

		source = event.getSource();
		if (source == slider) {
			value = slider.getValue();
			titleLabel.setText("I'm now at: " + value);
		}
	}

}