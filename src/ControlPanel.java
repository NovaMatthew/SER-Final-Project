import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ControlPanel extends JPanel implements PanelListener {

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
				button2.setEnabled(true);

			}

		});
		

		button2 = new JButton("Pause");
		button2.setFocusable(false);
		button2.setEnabled(true);
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				drawingPanel.togglePause();
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

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onGameOver() {
		button2.setEnabled(false);
		button1.setEnabled(true);
		
	}
}
