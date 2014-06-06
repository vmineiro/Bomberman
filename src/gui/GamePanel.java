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

import java.awt.Graphics;
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
	private static final int REFRESH_RATE = 50;
	
	/** The game timer */
	private Timer gameTimer;
	
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
	
	//=============================================================
	
	public GamePanel()
	{
		//TODO: Launch game
		GameModel.getInstance();		
		addKeyListener(this);
		
		ActionListener gameTimerListener = new ActionListener(){ 
			public void actionPerformed(ActionEvent e) {
				GameModel.getInstance().update();
				repaint();
				
				if(GameModel.getInstance().gameOver()){
					gameTimer.stop();
					
					//TODO: DELETE AFTER TESTING
					System.out.println("GAME OVER");
				}
				
			}
		};
		
		gameTimer = new Timer(REFRESH_RATE, gameTimerListener);
		gameTimer.start();
	}
	
	/**
	 * Draw game state
	 */
	public void paintComponent(Graphics g) 
	{
		
		//TODO: DELETE AFTER TESTING
		BufferedImage wallImg = null;
		
		try
		{
			wallImg = ImageIO.read(new File("img/wall01.png"));
		} catch (IOException e) {}
		
		int n = GameModel.getInstance().getBoard().getMaze().length;
		
		int dstImgWid = getWidth()/n;
		int dstImgHei = getHeight()/n;
	
		for(int i=0; i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(GameModel.getInstance().getBoard().getItem(new Position(i,j)).getClass() == UndestructibleWall.class)
				{
					g.drawImage(wallImg, j*dstImgWid, i*dstImgHei, (j*dstImgWid)+dstImgWid, (i*dstImgHei)+dstImgHei, 0, 0, 256, 256, null);
				}
			}
		}
		
		GameModel.getInstance().getPlayers().draw(g, getWidth(), getHeight());
		GameModel.getInstance().getMonsters().draw(g, getWidth(), getHeight());
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
