package model;

import model.board.Board;
import model.monster.Monster;
import model.player.Player;

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
	
	// =====================================================================
	
	/**
	 * Instantiates a new game model.
	 */
	private GameModel(){}

	/* (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	public void finalize() throws Throwable {

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
	 * Draw. Calls draw method of all objects.
	 */
	public void draw(){

	}

	/**
	 * Update the game state. Calls update method of all objects.
	 */
	public void update(){

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
		return false;
	}

	/**
	 * Sets the board.
	 *
	 * @param board the new board
	 */
	public void setBoard(Board board){

	}
}//end GameModel