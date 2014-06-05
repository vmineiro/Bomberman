package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import model.board.Board;
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
	
	/** The game timer */
	private Timer gameTimer;
	
	// =====================================================================

	/**
	 * Instantiates a new game model.
	 */
	private GameModel(){
		this.board = new Board();
		this.players = new Player();
		this.monsters = new Monster();
		
		ActionListener gameTimerListener = new ActionListener(){ 
			public void actionPerformed(ActionEvent e) {
				update();
			}
		};
		
		gameTimer = new Timer(1000, gameTimerListener);
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
		
		if(gameOver()){
			gameTimer.stop();
		}			
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
		return true;
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