package model.player;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.Timer;

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
	
	/** The draw position. */
	private Position drawPosition;
	
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
	private BufferedImage bombermanImg_1;
	private BufferedImage bombermanImg_2;
	private BufferedImage bombermanImg_3;
	private BufferedImage bombermanImg_4;
	private BufferedImage bombermanImg_5;
	private BufferedImage bombermanImg_6;
	private BufferedImage bombermanImg_7;
	private BufferedImage bombermanImg_8;
	private BufferedImage bombermanImg_9;
	private BufferedImage bombermanImg_10;
	private BufferedImage bombermanImg_11;
	private BufferedImage bombermanImg_12;
	private ArrayList<BufferedImage> animPlayer;
	private Timer animTimer;
	private int animIndex = 0;
	
	//============================================================================
	
	/**
	 * Instantiates a new player.
	 */
	public Player(){
		this.boardPosition = new Position();
		this.drawPosition = new Position();
		this.state = new PlayerAlive();	
	
		try
		{
			bombermanImg_1 = ImageIO.read(new File("img/bomberman_1.png"));
			bombermanImg_2 = ImageIO.read(new File("img/bomberman_2.png"));
			bombermanImg_3 = ImageIO.read(new File("img/bomberman_3.png"));
			bombermanImg_4 = ImageIO.read(new File("img/bomberman_4.png"));
			bombermanImg_5 = ImageIO.read(new File("img/bomberman_5.png"));
			bombermanImg_6 = ImageIO.read(new File("img/bomberman_6.png"));
			bombermanImg_7 = ImageIO.read(new File("img/bomberman_7.png"));
			bombermanImg_8 = ImageIO.read(new File("img/bomberman_8.png"));
			bombermanImg_9 = ImageIO.read(new File("img/bomberman_9.png"));
			bombermanImg_10 = ImageIO.read(new File("img/bomberman_10.png"));
			bombermanImg_11 = ImageIO.read(new File("img/bomberman_11.png"));
			bombermanImg_12 = ImageIO.read(new File("img/bomberman_12.png"));
		} catch (IOException e) {}	
		
		animPlayer = new ArrayList<BufferedImage>();
		animPlayer.add(bombermanImg_1);
		animPlayer.add(bombermanImg_2);
		animPlayer.add(bombermanImg_3);
		animPlayer.add(bombermanImg_4);
		animPlayer.add(bombermanImg_5);
		animPlayer.add(bombermanImg_6);
		animPlayer.add(bombermanImg_7);
		animPlayer.add(bombermanImg_8);
		animPlayer.add(bombermanImg_9);
		animPlayer.add(bombermanImg_10);
		animPlayer.add(bombermanImg_11);
		animPlayer.add(bombermanImg_12);
		
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
				queueMBombs.add(new ManualBomb(this));
			} else{
				new AutomaticBomb(this);
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
		//this.bombermanImg = animation;
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
	 * Check if player is dead
	 */
	public boolean isDead(){
		if(getCurrentState().getClass() == PlayerDead.class){
			return true;
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
		
		g.drawImage(animPlayer.get(animIndex), boardPosition.getCol()*dstImgWid, boardPosition.getLine()*dstImgHei, 
				(boardPosition.getCol()*dstImgWid)+dstImgWid, (boardPosition.getLine()*dstImgHei)+dstImgHei, 0, 0, 32, 56, null);

		animIndex++;
		if(animIndex == 12){
			animIndex = 0;
		}
		
		//animTimer = new Timer(30, animTimerListener);
		//animTimer.start();
	}
	
	/*
	ActionListener animTimerListener = new ActionListener(){ 
		public void actionPerformed(ActionEvent e) {
			GameModel.getInstance().update();
			setCurrentState(new PlayerDead());
		}
	};
	*/	

}

//end Player