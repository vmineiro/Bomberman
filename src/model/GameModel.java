package model;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Timer;

import model.board.Board;
import model.board.Item;
import model.board.ItemActive;
import model.board.ItemInactive;
import model.board.ItemPath;
import model.board.UndestructibleWall;
import model.monster.Monster;
import model.player.Player;

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
	private ArrayList<Monster> monsters;
	
	/** Number of monsters alive */
	private int monstersAlive;
	
	/** Game Logic Timer */
	private Timer gameTimer;
	
	/** Game Logic refresh rate */
	private static final int LOGIC_RATE = 250;
	
	/** Key Pressed Up */
	private boolean pressedUp = false;
	
	/** Key Pressed Down */
	private boolean pressedDown = false;
	
	/** Key Pressed Left */
	private boolean pressedLeft = false;
	
	/** Key Pressed Right */
	private boolean pressedRight = false;
	
	//Player Movement Increments
	public static final Position UP = new Position(-1,0);
	public static final Position DOWN = new Position(1,0);
	public static final Position LEFT = new Position(0,-1);
	public static final Position RIGHT = new Position(0,1);
	
	// =====================================================================

	/**
	 * Instantiates a new game model.
	 */
	private GameModel(){
		this.board = new Board();
		this.players = new Player();
		this.monsters = new ArrayList<Monster>();
		
		//TODO: DELETE AFTER TESTING
		//TODO: Generate 3x Monsters
		for(int i=0; i<3; i++){
			Monster monst = new Monster();
			monst.setBoardPosition(new Position(1,1));
			addMonster(monst);
		}		
		
		//==========================================================================================
		
		this.players.updateBoardPosition(new Position(3,3));
		
		/*
		Item hiddenPath = new ItemPath();
		Item boardExit = new BoardExit();
		Item bombControl = new BombControl();
		Item bombPowerUp = new BombPowerUp();
		Item boostSpeed = new BoostSpeed();
		Item extraBomb = new ExtraBomb();
		*/
		
		//TODO: Test board composed only by two objects everything else is reference
		char[][] mazeChar = new char[][]{
				{'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
				{'x', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'x'},
				{'x', 'p', 'x', 'p', 'x', 'p', 'x', 'x', 'p', 'x'},
				{'x', 'p', 'x', 'p', 'x', 'p', 'x', 'x', 'p', 'x'},
				{'x', 'p', 'p', 'p', 'x', 'p', 'w', 'w', 'p', 'x'},
				{'x', 'p', 'p', 'p', 'x', 'p', 'x', 'x', 'p', 'x'},
				{'x', 'p', 'x', 'p', 'x', 'p', 'x', 'x', 'p', 'x'},
				{'x', 'p', 'x', 'p', 'x', 'p', 'x', 'x', 'p', 'x'},
				{'x', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'x'},
				{'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
		};
			
		
		Item[][] maze = new Item[10][10];
		
		for(int i=0; i<mazeChar.length; i++){
			for(int j=0; j<mazeChar.length; j++){
				if(mazeChar[i][j] == 'x'){
					maze[i][j] = new UndestructibleWall();
				}else if(mazeChar[i][j] == 'p'){
					maze[i][j] = new ItemPath();
					maze[i][j].setCurrentState(new ItemActive());
				}else if(mazeChar[i][j] == 'w'){
					maze[i][j] = new ItemPath();
					maze[i][j].setCurrentState(new ItemInactive());
				}
				
			}
		}
		
		board.setMaze(maze);
		
		//==========================================================================================
		
		ActionListener gameTimerListener = new ActionListener(){ 
			public void actionPerformed(ActionEvent e) {
				GameModel.getInstance().update();	
			}
		};
		
		gameTimer = new Timer(LOGIC_RATE, gameTimerListener);
		gameTimer.start();
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
	public ArrayList<Monster> getMonsters(){
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
		
		for(int i=0; i<monsters.size(); i++)
		{
			if(monsters.get(i).getCurrentState().isDead())
			{
				monsters.remove(i);
			}
			else
			{
			monsters.get(i).update();
			}
		}
		
		if(GameModel.getInstance().gameOver()){
			gameTimer.stop();
			
			//TODO: DELETE AFTER TESTING
			System.out.println("GAME OVER");
		}
	}
	
	/**
	 * Update key pressed to UP 
	 */
	public void updateKeyUp(){
		this.pressedUp = true;
		players.update();
	}
	
	/**
	 * Update key pressed to DOWN 
	 */
	public void updateKeyDown(){
		this.pressedDown = true;
		players.update();
	}
	
	/**
	 * Update key pressed to LEFT 
	 */
	public void updateKeyLeft(){
		this.pressedLeft = true;
		players.update();
	}
	
	/**
	 * Update key pressed to RIGHT 
	 */
	public void updateKeyRight(){
		this.pressedRight = true;
		players.update();
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
	 * Get player next movement
	 * 
	 * @param player moving
	 * @return newPosPlayer
	 */
	public Position getNextMov(Player playerMoving){
		
		if(pressedUp){
			return playerMoving.getBoardPosition().add(UP);
		}
		else if(pressedDown){
			return playerMoving.getBoardPosition().add(DOWN);
		}
		else if(pressedLeft){
			return playerMoving.getBoardPosition().add(LEFT);
		}
		else if(pressedRight){
			return playerMoving.getBoardPosition().add(RIGHT);
		}
		
		return playerMoving.getBoardPosition();
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
		if(getPlayers().getCurrentState().isDead()){
			//TODO: Delete System.out
			System.out.println("Player is dead");
			return true;
		}
		
		if(getMonsters().isEmpty()){
			//TODO: Delete System.out
			System.out.println("Player won");
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
		monsters.add(monster);
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
	
	/**
	 * Draw Game
	 */
	public void draw(Graphics g, int width, int height){
		GameModel.getInstance().getBoard().draw(g, width, height);
		GameModel.getInstance().getPlayers().draw(g, width, height);
		
		for(Monster monster : monsters){
			monster.draw(g, width, height);
		}
	}
}

//end GameModel