import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;

import javax.swing.JPanel;

public class DrawingPanel extends JPanel {

	private Timer timer;
	private boolean isGameOver = false;
	private ArrayList<PanelListener> listeners = new ArrayList<PanelListener>();

	public DrawingPanel() {
		super();

		this.setBackground(Color.BLUE); // for the game, but can be changed to a different color.

		setLayout(null);

		timer = new Timer(1, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: game logic here

//				if (isGameOver) {
//					gameOver();
//				}
//
//				 repaint();
			}
			});

		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		});

		this.setFocusable(true);
		this.setDoubleBuffered(true);
	

	public void addListener(PanelListener listener) {
		listeners.add(listener);
	}

	public void startGame() {
		isGameOver = false;
		timer.start();
	}

	public void togglePause() {
		if (timer.isRunning()) {
			timer.stop();
		} else {
			timer.start();
		}
	}

	public void gameOver() {
		isGameOver = true;
		timer.stop();
		for (PanelListener listener : listeners) {
			listener.onGameOver();
		}
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D brush = (Graphics2D) g;

		if (isGameOver) {
			brush.setColor(Color.red);
			brush.setFont(new Font("Times New Roman", Font.PLAIN, 72));
			brush.drawString("GAME OVER", 300, 300);
		}

	}
}
