package gui;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import model.GameModel;

/**
 * The Class GamePanel.
 */
public class GamePanel extends JPanel implements KeyListener
{	
	
	/** The key pauPause. */
	private int keyPause = KeyEvent.VK_ESCAPE;
	
	//========= PLAYER 1 KEYS =====================================
	
	/** The key up. */
	private int keyUpP1 = KeyEvent.VK_UP;
	
	/** The key down. */
	private int keyDownP1 = KeyEvent.VK_DOWN;
	
	/** The key left. */
	private int keyLeftP1 = KeyEvent.VK_LEFT;
	
	/** The key right. */
	private int keyRightP1 = KeyEvent.VK_RIGHT;
	
	/** The key drop bomb. */
	private int keyDropBombP1 = KeyEvent.VK_SPACE;
	
	/** The key drop bomb. */
	private int keyExploBombP1 = KeyEvent.VK_ENTER;


	//========= PLAYER 2 KEYS =====================================
	
	/** The key up. */
	private int keyUpP2 = KeyEvent.VK_T;
	
	/** The key down. */
	private int keyDownP2 = KeyEvent.VK_G;

	/** The key left. */
	private int keyLeftP2 = KeyEvent.VK_F;
	
	/** The key right. */
	private int keyRightP2 = KeyEvent.VK_H;
	
	/** The key drop bomb. */
	private int keyDropBombP2 = KeyEvent.VK_Q;
	
	/** The key drop bomb. */
	private int keyExploBombP2 = KeyEvent.VK_A;


	

	
	//=============================================================
	
	/** The main window. */
	private MainWindow mainWindow;
	

	/**
	 * Instantiates a new game panel.
	 *
	 * @param mainWindow the main window
	 */
	public GamePanel(final MainWindow mainWindow)
	{		
		addKeyListener(this);
		this.mainWindow = mainWindow;	
	}
	
	/**
	 * Draw game state.
	 *
	 * @param g the g
	 */
	public void paintComponent(Graphics g) 
	{			
		super.paintComponent(g);
		GameModel.getInstance().draw(g, getWidth(), getHeight());
	}	
	
	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e){
		
		int key = e.getKeyCode();
		
		if(key == keyUpP1)
		{
			GameModel.getInstance().updateKeyUp();
		}
		else if(key == keyDownP1)
		{
			GameModel.getInstance().updateKeyDown();
		}
		else if (key == keyLeftP1)
		{
			GameModel.getInstance().updateKeyLeft();
		}
		else if(key == keyRightP1)
		{
			GameModel.getInstance().updateKeyRight();
		}
		else if(key == keyDropBombP1)
		{
			GameModel.getInstance().getPlayers().dropBomb();
		}
		else if(key == keyPause)
		{
			mainWindow.pauseGame();
		}
		
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e){
		GameModel.getInstance().updateKeyReleased();
	}


	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent e){}
	
	
	/**
	 * Gets the key up p1.
	 *
	 * @return the key up p1
	 */
	public int getKeyUpP1() {
		return keyUpP1;
	}

	/**
	 * Sets the key up p1.
	 *
	 * @param keyUpP1 the new key up p1
	 */
	public void setKeyUpP1(int keyUpP1) {
		this.keyUpP1 = keyUpP1;
	}

	/**
	 * Gets the key down p1.
	 *
	 * @return the key down p1
	 */
	public int getKeyDownP1() {
		return keyDownP1;
	}

	/**
	 * Sets the key down p1.
	 *
	 * @param keyDownP1 the new key down p1
	 */
	public void setKeyDownP1(int keyDownP1) {
		this.keyDownP1 = keyDownP1;
	}

	/**
	 * Gets the key left p1.
	 *
	 * @return the key left p1
	 */
	public int getKeyLeftP1() {
		return keyLeftP1;
	}

	/**
	 * Sets the key left p1.
	 *
	 * @param keyLeftP1 the new key left p1
	 */
	public void setKeyLeftP1(int keyLeftP1) {
		this.keyLeftP1 = keyLeftP1;
	}

	/**
	 * Gets the key right p1.
	 *
	 * @return the key right p1
	 */
	public int getKeyRightP1() {
		return keyRightP1;
	}

	/**
	 * Sets the key right p1.
	 *
	 * @param keyRightP1 the new key right p1
	 */
	public void setKeyRightP1(int keyRightP1) {
		this.keyRightP1 = keyRightP1;
	}

	/**
	 * Gets the key drop bomb p1.
	 *
	 * @return the key drop bomb p1
	 */
	public int getKeyDropBombP1() {
		return keyDropBombP1;
	}

	/**
	 * Sets the key drop bomb p1.
	 *
	 * @param keyDropBombP1 the new key drop bomb p1
	 */
	public void setKeyDropBombP1(int keyDropBombP1) {
		this.keyDropBombP1 = keyDropBombP1;
	}

	/**
	 * Gets the key explo bomb p1.
	 *
	 * @return the key explo bomb p1
	 */
	public int getKeyExploBombP1() {
		return keyExploBombP1;
	}

	/**
	 * Sets the key explo bomb p1.
	 *
	 * @param keyExploBombP1 the new key explo bomb p1
	 */
	public void setKeyExploBombP1(int keyExploBombP1) {
		this.keyExploBombP1 = keyExploBombP1;
	}

	/**
	 * Gets the key up p2.
	 *
	 * @return the key up p2
	 */
	public int getKeyUpP2() {
		return keyUpP2;
	}

	/**
	 * Sets the key up p2.
	 *
	 * @param keyUpP2 the new key up p2
	 */
	public void setKeyUpP2(int keyUpP2) {
		this.keyUpP2 = keyUpP2;
	}

	/**
	 * Gets the key down p2.
	 *
	 * @return the key down p2
	 */
	public int getKeyDownP2() {
		return keyDownP2;
	}

	/**
	 * Sets the key down p2.
	 *
	 * @param keyDownP2 the new key down p2
	 */
	public void setKeyDownP2(int keyDownP2) {
		this.keyDownP2 = keyDownP2;
	}

	/**
	 * Gets the key left p2.
	 *
	 * @return the key left p2
	 */
	public int getKeyLeftP2() {
		return keyLeftP2;
	}

	/**
	 * Sets the key left p2.
	 *
	 * @param keyLeftP2 the new key left p2
	 */
	public void setKeyLeftP2(int keyLeftP2) {
		this.keyLeftP2 = keyLeftP2;
	}

	/**
	 * Gets the key right p2.
	 *
	 * @return the key right p2
	 */
	public int getKeyRightP2() {
		return keyRightP2;
	}

	/**
	 * Sets the key right p2.
	 *
	 * @param keyRightP2 the new key right p2
	 */
	public void setKeyRightP2(int keyRightP2) {
		this.keyRightP2 = keyRightP2;
	}

	/**
	 * Gets the key drop bomb p2.
	 *
	 * @return the key drop bomb p2
	 */
	public int getKeyDropBombP2() {
		return keyDropBombP2;
	}

	/**
	 * Sets the key drop bomb p2.
	 *
	 * @param keyDropBombP2 the new key drop bomb p2
	 */
	public void setKeyDropBombP2(int keyDropBombP2) {
		this.keyDropBombP2 = keyDropBombP2;
	}

	/**
	 * Gets the key explo bomb p2.
	 *
	 * @return the key explo bomb p2
	 */
	public int getKeyExploBombP2() {
		return keyExploBombP2;
	}

	/**
	 * Sets the key explosion bomb p2.
	 *
	 * @param keyExploBombP2 the new key explo bomb p2
	 */
	public void setKeyExploBombP2(int keyExploBombP2) {
		this.keyExploBombP2 = keyExploBombP2;
	}
}
