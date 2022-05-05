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
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class DrawingPanel extends JPanel {
	private boolean gameOver = false;
	private boolean wonGame = false;
	private boolean leftPressed, rightPressed, upPressed, downPressed;
	private Sprite enemy, objective, player;
	private ArrayList<Sprite> enemies = new ArrayList<Sprite>();
	private Timer timer;
	private int x,y;
	/*
	 * NOTE: Can ignore message when running program, for now the sprites intersect
	 * one another TO-DO: 1. implement random number of enemies (any range is fine)
	 * 2. have enemies start a the top of the screen (use something such as
	 * enemy.setLocation( enemy.getX(), enemy.getY() - 2); 3. Reduce the size of the
	 * enemy, player, and objective (Here's a code snippet to help:
	 * enemy.setWidth(enemy.getWidth() / 2); and enemy.setWidth(enemy.getWidth() /
	 * 2);)
	 * 
	 * IMPORTANT: All of this can be implemented in the Drawing Panel constructor.
	 * Let me know if you need any help.
	 */

	/*
	 * The clownfish would be the player. The sea anemone is the objective and the
	 * sea mines are the enemies. I don't know if you had a specific theme in mind
	 * or if you already found.
	 */
	public DrawingPanel() {
		super();
		this.setBackground(Color.BLUE); // for the game, but can be changed to a different color.

		// Instiate our Sprites with the abstract method from sprite class
		try {
			enemy = new Sprite("./images/mine.png") {

				@Override
				public void tick() {
					// TODO Auto-generated method stub

				}

			};
			enemy.setWidth(enemy.getWidth() / 8);
			enemy.setHeight(enemy.getHeight() / 8);
			enemy.setLocation(400, 200);

			objective = new Sprite("./images/home.png") {

				@Override
				public void tick() {
					// TODO Auto-generated method stub

				}

			};
			objective.setWidth(objective.getWidth() / 10);
			objective.setHeight(objective.getHeight() / 10);
			objective.setLocation(400, 200);

			player = new Sprite("./images/clown-fish.png") {

				@Override
				public void tick() {
					// TODO Auto-generated method stub
					if (upPressed) {
						// do something
						player.setLocation(player.getX(), player.getY() - 2);
					} else if (downPressed) {
						// do something
						player.setLocation(player.getX(), player.getY() + 2);
					} else if (leftPressed) {
						// do something
						player.setLocation(player.getX() - 2, player.getY());
					} else if (rightPressed) {
						// do something
						player.setLocation(player.getX() + 2, player.getY());
					}
				}
			};

			player.setWidth(player.getWidth() / 12);
			player.setHeight(player.getHeight() / 10);
			player.setLocation(50, 100);
			Random rand = new Random();
			timer = new Timer(1, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					player.tick();
					
					int randn = rand.nextInt(1, 15);
						
					for (int i = 0; i < enemies.size(); i++) {

						Sprite enemy = enemies.get(i);
						
						enemy.setLocation(enemy.getX(), enemy.getY() + 1);
						// we don't want the player to leave the screen..
						if (DrawingPanel.this.getHeight() == player.getY()+ player.getHeight()) {
							player.setY(650);
						} else if (player.getY() == 0) {
							player.setY(10);
						} else if (player.getX() >= DrawingPanel.this.getWidth()) {
							player.setX(900);
						} else if (player.getX() == 0) {
							player.setX(10);
						}

						if (enemy.getY()  > DrawingPanel.this.getHeight()) {
							enemies.remove(i);
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

						if (enemies.size() == 0) {
							int random = rand.nextInt(1, 15);
							for (int j = 0; j < random; j++) {

								try {
									enemy = new Sprite("./images/mine.png") {

										@Override
										public void tick() {}

									};
									enemy.setWidth(enemy.getWidth() / 8);
									enemy.setHeight(enemy.getHeight() / 8);
									enemies.add(enemy);

								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}

							}
							x = rand.nextInt(10, 900);
							
							enemies.get(i).setX(x);

						}
					

					repaint();
						}
					}
			});

			// Key configs for our game
			this.addKeyListener(new KeyAdapter() {

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

		} catch (IOException e1) {
			// Will trigger an exception if images were unable to load.
			e1.printStackTrace();
		}
		setFocusable(true);

		// implementing movement logic for the player
	}

	// will start the game when the start button is pressed (NEEDS WORK)
	public void startGame() {
		gameOver = false;
		wonGame = false;
		timer.start();
		//enemies.clear();
		Random rand = new Random();
		int random = rand.nextInt(1, 15);
		for (int j = 0; j < random; j++) {

			try {
				enemy = new Sprite("./images/mine.png") {

					@Override
					public void tick() {}

				};
				enemy.setWidth(enemy.getWidth() / 8);
				enemy.setHeight(enemy.getHeight() / 8);
				enemy.setLocation(400, 200);
				enemies.add(enemy);

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		
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
		enemy.paint(brush);
		// will paint the enemies for the game
		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).paint(brush);
		}

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
