package model.player;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.imageio.ImageIO;

import model.GameChar;
import model.GameModel;
import model.Position;
import model.board.BoardExit;
import model.board.BombControl;
import model.board.BombPowerUp;
import model.board.BoostSpeed;
import model.board.ExtraBomb;
import model.board.Item;
import model.board.ItemPath;
import model.board.UndestructibleWall;
import model.monster.Monster;

/**
 * This class defines the interface of interest to clients and maintains an
 * instance of a PlayerState subclass that defines the current state.
 */
public class Player implements GameChar{

	/** The score. */
	//private int score = 0;
	
	/** The lives. */
	private int lives = 3;
	
	/** The speed. */
	private int speed = 1;
	
	/** The board position. */
	private Position boardPosition;
	
	/** The next board position */
	private Position nextPlayerPosition;
	
	/** The state. */
	private PlayerState state;
	
	/** The manual bomb. */
	private boolean manualBomb = false;
	
	/** The bomb power. */
	private int bombPower = 1;
	
	/** The numbers of available bombs. */
	private int availableBombs = 1;
	
	/** The imortal. */
	//private boolean imortal = true;
	
	/** Manual Bombs Queue */
	private Queue<ManualBomb> queueMBombs = new LinkedList<ManualBomb>();
	
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
			
			if(manualBomb){
				//TODO: Place bomb in item
				queueMBombs.add(new ManualBomb(this));
			} else{
				GameModel.getInstance().getBoard().getItem(boardPosition).bombDropped(new AutomaticBomb(this));
			}
		}
	}
	
	/**
	 * Detonate manual bombs
	 */
	public void detonateBomb(){
		if(!queueMBombs.isEmpty()){
			queueMBombs.poll().detonate();
		}
	}
	
	/**
	 * Increase speed.
	 */
	public void increaseSpeed(){
		this.speed++;
	}

	/**
	 * Increase power bomb.
	 */
	public void increasePowerBomb(){
		this.bombPower++;
	}

	/**
	 * Life lost.
	 */
	public void lifeLost(){
		this.lives--;
	}

	/**
	 * Adds the bomb.
	 */
	public void addBomb(){
		this.availableBombs++;
	}
	
	/**
	 * Get bomb control
	 */
	public void getBombControl(){
		this.manualBomb = true;
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
			if(boardPosition.equals(monster.getBoardPosition())){
				collidesWith(monster);
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Monster visits bomb control item in game board
	 */
	public void visitBombControl(BombControl item){
		updateBoardPosition(nextPlayerPosition);
		getBombControl();
		checkDeath(item);
		if(item.hasMonsters()){
			collidesWith(new Monster());
		}
	}
	
	/**
	 * Monster visits extra bomb item in game board
	 */
	public void visitExtraBomb(ExtraBomb item){
		updateBoardPosition(nextPlayerPosition);
		addBomb();
		checkDeath(item);
		if(item.hasMonsters()){
			collidesWith(new Monster());
		}		
	}
	
	/**
	 * Monster visits bomb power up item in game board
	 */
	public void visitBombPowerUp(BombPowerUp item){
		updateBoardPosition(nextPlayerPosition);
		increasePowerBomb();
		checkDeath(item);
		if(item.hasMonsters()){
			collidesWith(new Monster());
		}
	}
	
	/**
	 * Monster visits boost speed item in game board
	 */
	public void visitBoostSpeed(BoostSpeed item){
		updateBoardPosition(nextPlayerPosition);
		increaseSpeed();
		checkDeath(item);
		if(item.hasMonsters()){
			collidesWith(new Monster());
		}
	}
	
	/**
	 * Monster visits path item in game board
	 */
	public void visitPath(ItemPath item){
		updateBoardPosition(nextPlayerPosition);
		checkDeath(item);
		if(item.hasMonsters()){
			collidesWith(new Monster());
		}
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
		if(item.hasMonsters()){
			collidesWith(new Monster());
		}
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
		setCurrentState(getCurrentState().die());
	}
	
	//TODO: Implement this functions =======================================

	//TODO:if the player died should reset his power ups.
	/**
	 * Respawn. Set the player in start position.
	 */
	public void respawn(){}

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