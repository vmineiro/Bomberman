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
	
	//=============================================================
	
	public GamePanel()
	{
		//TODO: Launch game
		//TODO: DELETE AFTER TESTING
		GameModel.getInstance();
		GameModel.getInstance().getPlayers().updateBoardPosition(new Position(3,3));
		GameModel.getInstance().getMonsters().setBoardPosition(new Position(1,1));
		
		Item hiddenPath = new ItemPath();
		Item boardExit = new BoardExit();
		Item bombControl = new BombControl();
		Item bombPowerUp = new BombPowerUp();
		Item boostSpeed = new BoostSpeed();
		Item extraBomb = new ExtraBomb();
	
		Item normalPath = new ItemPath();
		normalPath.setCurrentState(new ItemActive());
	
		Item undestructibleWall = new UndestructibleWall();	
		
		Item[][] maze = new Item[][]{
				{undestructibleWall, undestructibleWall, undestructibleWall, undestructibleWall, undestructibleWall},
				{undestructibleWall, normalPath, normalPath, normalPath, undestructibleWall},
				{undestructibleWall, normalPath, undestructibleWall, normalPath, undestructibleWall},
				{undestructibleWall, normalPath, normalPath, normalPath, undestructibleWall},
				{undestructibleWall, undestructibleWall, undestructibleWall, undestructibleWall, undestructibleWall}		
		};
		
		GameModel.getInstance().getBoard().setMaze(maze);
		
		//==========================================================================================
		
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
		
		//int n = game.getMaze().getBoard().length;
		int n = 5;
		
		int elem_size = getParent().getWidth()/n;
		int ajust = (getParent().getWidth()%n)/2;
		
		for(int i=0; i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				if(GameModel.getInstance().getBoard().getItem(new Position(i,j)).getClass() == UndestructibleWall.class)
				{
					g.drawImage(wallImg, j*elem_size+ajust, i*elem_size+ajust, (j*elem_size)+elem_size+ajust, (i*elem_size)+elem_size+ajust, 0, 0, 256, 256, null);
				}
			}
		}
	}	
	
	@Override
	public void keyPressed(KeyEvent e){}
	
	@Override
	public void keyReleased(KeyEvent e){}


	@Override
	public void keyTyped(KeyEvent e){}
}
