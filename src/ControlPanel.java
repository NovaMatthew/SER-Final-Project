import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ControlPanel extends JPanel {
	public ControlPanel(DrawingPanel drawingPanel) {
	this.setLayout(new GridLayout());
	
	JButton button1 = new JButton("Button1");
	
	JButton button2 = new JButton("Button2");
	
	this.add(button1);
	this.add(button2);
	
	}
}
