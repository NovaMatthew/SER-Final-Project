import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel {
	private boolean gameOver = false;
	private boolean wonGame = false;
	private boolean leftPressed, rightPressed, upPressed, downPressed;

	public DrawingPanel() {
		super();
		this.setBackground(Color.BLUE); // for the game, but can be changed to a different color.

		// This will need more stuff but should be added later on
		if (upPressed) {
			// do something
		} else if (downPressed) {
			// do something
		} else if (leftPressed) {
			// do something
		} else if (rightPressed) {
			// do something
		}
		setLayout(null);

		this.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					upPressed = true;
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {

					downPressed = true;
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {

					leftPressed = true;
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

					rightPressed = true;
				}

			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_UP) {

					upPressed = false;
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {

					downPressed = false;
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {

					leftPressed = false;
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

					rightPressed = false;
				}
			}

		});

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D brush = (Graphics2D) g;

		if (gameOver) {
			brush.setFont(new Font(" Serif", Font.BOLD, 70));
			brush.setColor(Color.BLACK);
			brush.drawString("TRY AGAIN", 325, 400);
		}
		if (wonGame) {
			brush.setFont(new Font(" Serif", Font.BOLD, 70));
			brush.setColor(Color.BLACK);
			brush.drawString("YOU WIN", 325, 400);
		}

	}
}
