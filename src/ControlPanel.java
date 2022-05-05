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
		button1.setFocusable(false);
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				drawingPanel.startGame();
				button1.setEnabled(false);

			}
		});
		button1.setFocusable(false);
		button2 = new JButton("Pause");
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				drawingPanel.pauseGame();
				if (button2.getText().equals("Pause")) {
					button2.setText("Continue");
				} else {
					button2.setText("Pause");

				}
			}

		});
		button2.setFocusable(false);

		this.add(button1);
		this.add(button2);

	}
}
