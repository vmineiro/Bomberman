package model;

/**
 * This class GameModel defines an Instance operation that lets clients access its
 * unique instance, and may be responsible for creating its own unique
 * instance.
 */
public class GameModel {

	private static int uniqueInstance;
	private Board board;
	private Player players;
	private Monster monsters;
	public Board m_Board;
	public Monster m_Monster;
	public Player m_Player;

	public GameModel(){

	}

	public void finalize() throws Throwable {

	}
	
	/*
	public static Instance(){
		//return uniqueInstance


	}
	*/
	
	public void draw(){

	}

	public void update(){

	}

	public void saveGame(){

	}

	public void loadGame(){

	}

	public boolean gameOver(){
		return false;
	}

	/**
	 * 
	 * @param board
	 */
	public void setBoard(Board board){

	}
}//end GameModel