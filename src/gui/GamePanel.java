package gui;

import model.GameModel;
import model.Position;
import model.board.BoardExit;
import model.board.BombControl;
import model.board.BombPowerUp;
import model.board.BoostSpeed;
import model.board.ExtraBomb;
import model.board.Item;
import model.board.ItemActive;
import model.board.ItemPath;
import model.board.UndestructibleWall;
import model.monster.Monster;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * The Class GamePanel
 */
public class GamePanel extends JPanel implements KeyListener
{	
	/** Game refresh rate */
	private static final int REFRESH_RATE = 60;
	
	/** The game timer */
	private Timer refreshTimer;
	
	/** The key up. */
	private int keyUp = KeyEvent.VK_UP;
	
	/** The key down. */
	private int keyDown = KeyEvent.VK_DOWN;
	
	/** The key left. */
	private int keyLeft = KeyEvent.VK_LEFT;
	
	/** The key right. */
	private int keyRight = KeyEvent.VK_RIGHT;
	
	/** The key drop bomb. */
	private int keyDropBomb = KeyEvent.VK_SPACE;
	
	/** The player image */
	private Image bombermanImg;

	//=============================================================
	
	public GamePanel()
	{
		GameModel.getInstance();		
		addKeyListener(this);
		
		//TODO: Review code for multiplayer game
		this.bombermanImg = getToolkit().createImage("img/bomberman.gif");
		GameModel.getInstance().getPlayers().setAnimation(bombermanImg);
		
		ActionListener gameTimerListener = new ActionListener(){ 
			public void actionPerformed(ActionEvent e) {
				repaint();
				
				if(GameModel.getInstance().gameOver()){
					refreshTimer.stop();
				}
				
			}
		};
		
		refreshTimer = new Timer(REFRESH_RATE, gameTimerListener);
		refreshTimer.start();
	}
	
	/**
	 * Draw game state
	 */
	public void paintComponent(Graphics g) 
	{		
		super.paintComponent(g);
		GameModel.getInstance().draw(g, getWidth(), getHeight());
	}	
	
	@Override
	public void keyPressed(KeyEvent e){
		
		int key = e.getKeyCode();

		if(key == keyUp)
		{
			GameModel.getInstance().updateKeyUp();
		}
		else if(key == keyDown)
		{
			GameModel.getInstance().updateKeyDown();
		}
		else if (key == keyLeft)
		{
			GameModel.getInstance().updateKeyLeft();
		}
		else if(key == keyRight)
		{
			GameModel.getInstance().updateKeyRight();
		}
		else if(key == keyDropBomb)
		{
			GameModel.getInstance().getPlayers().dropBomb();
		}
		
	}
	
	@Override
	public void keyReleased(KeyEvent e){
		GameModel.getInstance().updateKeyReleased();
	}


	@Override
	public void keyTyped(KeyEvent e){}
}
