import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class DrawingPanel extends JPanel {
	private boolean gameOver = false;
	private boolean wonGame = false;
	private boolean leftPressed, rightPressed, upPressed, downPressed;
	private Sprite enemy, objective, player;
	private ArrayList<Sprite> enemies;
	private Timer timer;

	public DrawingPanel() {
		super();
		this.setBackground(Color.BLUE); // for the game, but can be changed to a different color.

		// Instiate our Sprites with the abstract method from sprite class
		try {
			enemy = new Sprite("./images/water-mine.png") {

				@Override
				public void tick() {
					// TODO Auto-generated method stub

				}

			};
			objective = new Sprite("./images/home.png") {

				@Override
				public void tick() {
					// TODO Auto-generated method stub

				}

			};

			player = new Sprite("./images/clown-fish.png") {

				@Override
				public void tick() {
					// TODO Auto-generated method stub
					if (upPressed) {
						// do something
						player.setLocation(player.getX(), player.getY() + 2);
					} else if (downPressed) {
						// do something
						player.setLocation(player.getX(), player.getY() - 2);
					} else if (leftPressed) {
						// do something
						player.setLocation(player.getX() - 2, player.getY());
					} else if (rightPressed) {
						// do something
						player.setLocation(player.getX() + 2, player.getY());
					}
				}
			};
		} catch (IOException e1) {
			// Will trigger an exception if images were unable to load.
			e1.printStackTrace();
		}

		// implementing movement logic for the player
		timer = new Timer(1, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				player.tick();
			}

		});

		// we don't want the player to leave the screen..
		if (DrawingPanel.this.getHeight() == player.getY() + player.getHeight()) {

			player.setY(650);

		} else if (player.getY() == 0) {
			player.setY(10);
		}

		// check if enemy intersects with player or player intersects with the objective
		if (enemy.intersect(player)) {
			gameOver = true;
		} else if (player.intersect(objective)) {
			wonGame = true;
		}

		// check to see if game is over
		if (gameOver || wonGame) {
			endGame();
		}

		// Key configs for our game
		
		this.addKeyListener( new KeyAdapter() {

			@Override
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
			@Override
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

	// will start the game when the start button is pressed (NEEDS WORK) 
	public void startGame() {
		gameOver = false;
		wonGame = false;
		timer.start();
		enemies.clear();
	}

	// Stops the timer in the drawing panel constructor
	public void pauseGame() {
		if (timer.isRunning()) {
			timer.stop();
		} else {
			timer.start();
		}
	}

	// will end game
	public void endGame() {
		if (enemy.intersect(player)) {
			gameOver = true;
		} else if (player.intersect(objective)) {
			wonGame = true;
		}
		timer.stop();
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D brush = (Graphics2D) g;
		// paint components
		player.paint(brush);
		objective.paint(brush);

		// will paint the enemies for the game
		//for (int i = 0; i < enemies.size(); i++) {
			//enemies.get(i).paint(brush);
		//}

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
