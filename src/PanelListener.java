import java.awt.event.KeyEvent;

public interface PanelListener {
	public void keyPressed(KeyEvent e);
	public void keyReleased(KeyEvent e);
	void onGameOver();
}
