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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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
	
	/** The key drop bomb. */
	private int keyDropBomb = KeyEvent.VK_SPACE;
	
	//=============================================================
	
	public GamePanel()
	{
		//TODO: Launch game
		GameModel.getInstance();		
		addKeyListener(this);
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
		
		//int ajust = (getWidth()%n)/2;
		
	
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
	}	
	
	@Override
	public void keyPressed(KeyEvent e){
		
		int key = e.getKeyCode();

		if(key == keyUp)
		{
			GameModel.getInstance().getPlayers().setCurrentState(GameModel.getInstance().getPlayers().getCurrentState().turnUp());
			repaint();
		}
		else if(key == keyDown)
		{
			GameModel.getInstance().getPlayers().setCurrentState(GameModel.getInstance().getPlayers().getCurrentState().turnDown());
			repaint();
		}
		else if (key == keyLeft)
		{
			GameModel.getInstance().getPlayers().setCurrentState(GameModel.getInstance().getPlayers().getCurrentState().turnLeft());
			repaint();
		}
		else if(key == keyRight)
		{
			GameModel.getInstance().getPlayers().setCurrentState(GameModel.getInstance().getPlayers().getCurrentState().turnRight());
			repaint();
		}
		else if(key == keyDropBomb)
		{
			GameModel.getInstance().getPlayers().dropBomb();
			repaint();
		}
		else
		{
			repaint();
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e){}


	@Override
	public void keyTyped(KeyEvent e){}
}
