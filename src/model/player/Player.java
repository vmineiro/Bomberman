package model.player;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.GameChar;
import model.GameModel;
import model.Position;
import model.board.BoardExit;
import model.board.Item;
import model.board.ItemPath;
import model.board.UndestructibleWall;
import model.monster.Monster;
import java.io.Serializable;

/**
 * This class defines the interface of interest to clients and maintains an
 * instance of a PlayerState subclass that defines the current state.
 */
public class Player implements GameChar, Serializable{
	
	/** The board position. */
	private Position boardPosition;
	
	/** The next board position */
	private Position nextPlayerPosition;
	
	/** The state. */
	private PlayerState state;
	
	/** The numbers of available bombs. */
	private int availableBombs = 1;
	
	/** The Animation of the Item. */
	private BufferedImage bombermanImg;
	
	//============================================================================
	
	/**
	 * Instantiates a new player.
	 */
	public Player(){
		this.boardPosition = new Position();
		this.state = new PlayerAlive();
		
		try 
		{
			bombermanImg = ImageIO.read(new File("img/bomberman_s.png"));			
		} catch (IOException e) {}
	}
	
	/**
	 * Get board position
	 */
	public Position getBoardPosition(){
		return boardPosition;
	}
	
	/**
	 * Update board position.
	 */
	public void updateBoardPosition(Position n_pos){
		this.boardPosition = n_pos;
	}
	
	/**
	 * Gets the current state
	 */
	public PlayerState getCurrentState(){
		return state;
	}
	
	/**
	 * Sets the current state.
	 *
	 * @param state the new current state
	 */
	public void setCurrentState(PlayerState state){
		this.state = state;
	}
	
	/**
	 * Update.
	 */
	public void update(){
		nextPlayerPosition = GameModel.getInstance().getNextMov(this);
		GameModel.getInstance().getBoard().getItem(nextPlayerPosition).accept(this);
	}
	
	/**
	 * Drop bomb.
	 */
	public void dropBomb(){
		if(availableBombs != 0)
		{
			this.availableBombs--;
			GameModel.getInstance().getBoard().getItem(boardPosition).bombDropped(new Bomb(this));
		}
	}
	
	/**
	 * Adds the bomb.
	 */
	public void addBomb(){
		this.availableBombs++;
	}
	
	/**
	 * Sets the animation.
	 */
	public void setAnimation(BufferedImage animation){
		this.bombermanImg = animation;
	}
	
	/**
	 * Checks player death
	 */
	public boolean checkDeath(Item playerItem){
		//Checks explosion
		if(playerItem.isExploding())
		{
			setCurrentState(getCurrentState().die());
			return true;
		}

		//Checks collision with monsters
		for(Monster monster : GameModel.getInstance().getMonsters()){
			if(!monster.getCurrentState().isDead()){
				if(boardPosition.equals(monster.getBoardPosition())){
					collidesWith(monster);
					return true;
				}
			}
		}

		return false;
	}
	
	/**
	 * Monster visits path item in game board
	 */
	public void visitPath(ItemPath item){
		updateBoardPosition(nextPlayerPosition);
		checkDeath(item);
	}
	
	/**
	 * Monster visits undestructible wall item in game board
	 */
	public void visitUndestructibleWall(UndestructibleWall item){}
	
	/**
	 * Monster visits board exit item in game board
	 */ 
	public void visitBoardExit(BoardExit item){
		//TODO: Add check isActive()
		updateBoardPosition(nextPlayerPosition);
		checkDeath(item);
	}
	
	/**
	 * Collision Management
	 * @param gameChar
	 */
	public void collidesWith(GameChar gameChar){
		gameChar.visit(this);
	}
	
	/**
	 * Visited by Player
	 * @param vPlayer
	 */
	public void visit(Player vPlayer){}
	
	/**
	 * Visited by Monster
	 * @param vMonster
	 */
	public void visit(Monster vMonster){
		//TODO: DELETE
		System.out.println("PLAYER MATOU SE");
		setCurrentState(getCurrentState().die());
	}	

	/**
	 * Draw Player
	 */
	public void draw(Graphics g, int width, int height){
		
		int n = GameModel.getInstance().getBoard().getMaze().length;
		int dstImgWid = width / n;
		int dstImgHei = height / n;
	
		g.drawImage(this.bombermanImg, boardPosition.getCol()*dstImgWid, boardPosition.getLine()*dstImgHei, 
				(boardPosition.getCol()*dstImgWid)+dstImgWid, (boardPosition.getLine()*dstImgHei)+dstImgHei, 0, 0, 139, 209, null);
	}
}

//end Player
