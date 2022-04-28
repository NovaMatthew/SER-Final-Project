import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ControlPanel extends JPanel {

	private JButton button1, button2;

	public ControlPanel(DrawingPanel drawingPanel) {
		
		this.setLayout(new GridLayout());

		button1 = new JButton("Start");
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				button1.setEnabled(false);

			}

		});

		button2 = new JButton("Pause");
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (button2.getText().equals("Pause")) {
					button2.setText("Continue");
				} else {
					button2.setText("Pause");

				}
			}

		});
		this.add(button1);
		this.add(button2);

	}
}
