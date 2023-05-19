package clases;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

/**
 * Class used to rotate JLabels, inherits from JLabel. Author: Andoni
 */
public class RotatedLabel extends JLabel {

	private static final long serialVersionUID = 1L;
	private double angle;
	private double[] size = new double[2];

	/**
	 * Retrieves the rotation angle of the label.
	 * 
	 * @return The rotation angle of the label
	 */
	public double getAngle() {
		return angle;
	}

	/**
	 * Sets the rotation angle of the label.
	 * 
	 * @param angle The rotation angle of the label to set
	 */
	public void setAngle(double angle) {
		this.angle = angle;
	}

	/**
	 * Retrieves the custom size of the label.
	 * 
	 * @return The custom size of the label
	 */
	public double[] getSizeCustom() {
		return size;
	}

	/**
	 * Sets the custom size of the label.
	 * 
	 * @param size The custom size of the label to set
	 */
	public void setSizeCustom(double[] size) {
		this.size = size;
	}

	/**
	 * Constructs a RotatedLabel object with the specified text.
	 * 
	 * @param text The text to be displayed on the label
	 */
	public RotatedLabel(String text) {
		super(text);
		Font font = new Font("OCR A Extended", Font.PLAIN, 25);
		FontMetrics metrics = new FontMetrics(font) {
			private static final long serialVersionUID = 1L;
		};
		Rectangle2D bounds = metrics.getStringBounds(text, null);
		setBounds(0, 0, (int) bounds.getWidth(), (int) bounds.getHeight());
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D gx = (Graphics2D) g;
		gx.rotate(angle, getWidth() / 2, getHeight() / 2);

		if (size[0] != 0 && size[1] != 0)
			gx.scale(size[0], size[1]);
		super.paintComponent(g);
	}
}
