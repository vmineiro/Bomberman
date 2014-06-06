package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Timer;

import model.board.Board;
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
import model.player.Player;
import model.player.PlayerDead;

//TODO: Add Comments to all function
/**
 * This class GameModel defines an Instance operation that lets clients access its
 * unique instance, and may be responsible for creating its own unique
 * instance.
 */
public class GameModel {

	/** The unique instance. */
	private static GameModel uniqueGameModel = null;
	
	/** The board. */
	private Board board;
	
	/** The players. */
	private Player players;
	
	/** The monsters. */
	private Monster monsters;
	
	/** Number of monsters alive */
	private int monstersAlive;
	
	/** The bomberman animation */
	private BufferedImage bombermanImage;
	
	/** The monster animation */
	private BufferedImage monsterImage;
	
	/** Key Pressed Up */
	private boolean pressedUp = false;
	
	/** Key Pressed Down */
	private boolean pressedDown = false;
	
	/** Key Pressed Left */
	private boolean pressedLeft = false;
	
	/** Key Pressed Right */
	private boolean pressedRight = false;
	
	// =====================================================================

	/**
	 * Instantiates a new game model.
	 */
	private GameModel(){
		this.board = new Board();
		this.players = new Player();
		this.monsters = new Monster();
		
		try
		{
			bombermanImage = ImageIO.read(new File("img/Bomberman_2.jpg"));
			monsterImage = ImageIO.read(new File("img/monster.png"));
		} catch (IOException e) {}
		
		players.setAnimation(bombermanImage);
		monsters.setAnimation(monsterImage);
		
		//TODO: DELETE AFTER TESTING
		//==========================================================================================
		this.players.updateBoardPosition(new Position(3,3));
		this.monsters.setBoardPosition(new Position(1,1));
		
		/*
		Item hiddenPath = new ItemPath();
		Item boardExit = new BoardExit();
		Item bombControl = new BombControl();
		Item bombPowerUp = new BombPowerUp();
		Item boostSpeed = new BoostSpeed();
		Item extraBomb = new ExtraBomb();
		*/
		
		Item normalPath = new ItemPath();
		normalPath.setCurrentState(new ItemActive());
	
		Item unWall = new UndestructibleWall();	
		
		Item[][] maze = new Item[][]{
				{unWall, unWall, unWall, unWall, unWall,unWall, unWall, unWall, unWall, unWall},
				{unWall, normalPath, normalPath, normalPath, unWall,unWall, normalPath, normalPath, normalPath, unWall},
				{unWall, normalPath, normalPath, normalPath, normalPath,normalPath, normalPath, normalPath, normalPath, unWall},
				{unWall, normalPath, normalPath, normalPath, normalPath,normalPath, normalPath, normalPath, normalPath, unWall},
				{unWall, normalPath, normalPath, normalPath, normalPath,normalPath, normalPath, normalPath, normalPath, unWall},
				{unWall, normalPath, normalPath, normalPath, normalPath,normalPath, normalPath, normalPath, normalPath, unWall},
				{unWall, normalPath, normalPath, normalPath, normalPath,normalPath, normalPath, normalPath, normalPath, unWall},
				{unWall, normalPath, normalPath, normalPath, normalPath,normalPath, normalPath, normalPath, normalPath, unWall},
				{unWall, normalPath, normalPath, normalPath, normalPath,normalPath, normalPath, normalPath, normalPath, unWall},
				{unWall, unWall, unWall, unWall, unWall,unWall, unWall, unWall, unWall, unWall}
		};
		
		board.setMaze(maze);
		
		//==========================================================================================
	}	
	
	/**
	 * Instance.
	 */
	public static GameModel getInstance(){
			if(uniqueGameModel == null){
				return uniqueGameModel = new GameModel();
			}
			else{
				return uniqueGameModel;
			}
	}
	
	/**
	 * Get board
	 */
	public Board getBoard(){
		return board;
	}
	
	/**
	 * Get players 
	 */
	public Player getPlayers(){
		return players;
	}
	
	/**
	 * Get monsters
	 */
	public Monster getMonsters(){
		return monsters;
	}
	
	/**
	 * Get the number of monsters alive.
	 * 
	 * @return monstersAlive the number of monsters alive.
	 */
	public int getMonstersAlive() {
		return monstersAlive;
	}
	
	/**
	 * Decrements the number of monsters alive
	 */
	public void decMonstersAlive(){
		monstersAlive = monstersAlive - 1;
	}
	
	/**
	 * Draw. Calls draw method of all objects.
	 */
	public void draw(){

	}

	/**
	 * Update the game state. Calls update method of all objects.
	 */
	public void update(){
		players.update();
		monsters.update();			
	}
	
	/**
	 * Update key pressed to UP 
	 */
	public void updateKeyUp(){
		this.pressedUp = true;
	}
	
	/**
	 * Update key pressed to DOWN 
	 */
	public void updateKeyDown(){
		this.pressedDown = true;
	}
	
	/**
	 * Update key pressed to LEFT 
	 */
	public void updateKeyLeft(){
		this.pressedLeft = true;
	}
	
	/**
	 * Update key pressed to RIGHT 
	 */
	public void updateKeyRight(){
		this.pressedRight = true;
	}
	
	/**
	 * Update key released  
	 */
	public void updateKeyReleased(){
		this.pressedUp = false;
		this.pressedDown = false;
		this.pressedLeft = false;
		this.pressedRight = false;
	}

	/**
	 * Save game.
	 */
	public void saveGame(){

	}

	/**
	 * Load game.
	 */
	public void loadGame(){

	}

	/**
	 * Game over.
	 *
	 * @return true, if the game is over.
	 */
	public boolean gameOver(){
		if(getPlayers().isDead()){
			return true;
		}
		return false;
	}

	/**
	 * Sets the board.
	 *
	 * @param board the new board
	 */
	public void setBoard(Board board){
		this.board = board;
	}
	
	
	/**
	 * Add a monster to the game
	 * 
	 * @param monster the monster to be added.
	 */
	public void addMonster(Monster monster){
		
		//TODO: Update when game have multiple monsters in the game
		this.monsters = monster;
	}
	
	
	/**
	 * Add a player to the game
	 * 
	 * @param player the player to be added.
	 */
	public void addPlayer(Player player){
		
		//TODO: Update when game have multiple players in the game
		this.players = player;
	}
	
	
}//end GameModel