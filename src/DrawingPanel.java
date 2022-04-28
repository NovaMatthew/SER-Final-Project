import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;

public class DrawingPanel extends JPanel {

	public DrawingPanel() {
		super();
		setLayout(null);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D brush = (Graphics2D) g;

	}
}
