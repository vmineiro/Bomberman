package gui;

import model.GameModel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

/**
 * The Class GamePanel
 */
public class GamePanel extends JPanel implements KeyListener
{
	/** The key up. */
	private int keyUp = KeyEvent.VK_UP;
	
	/** The key down. */
	private int keyDown = KeyEvent.VK_DOWN;
	
	/** The key left. */
	private int keyLeft = KeyEvent.VK_LEFT;
	
	/** The key right. */
	private int keyRight = KeyEvent.VK_RIGHT;
	
	public GamePanel()
	{
		//TODO: Launch game
		GameModel.getInstance();
		
		addKeyListener(this);
	}
	
	@Override
	public void keyPressed(KeyEvent e){}
	
	@Override
	public void keyReleased(KeyEvent e){}


	@Override
	public void keyTyped(KeyEvent e){}
}
