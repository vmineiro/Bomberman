package model.board;

import model.Position;


/**
 * This class represents the game board.
 */
public class Board {

	
	
	/** The maze. */
	private Item[][] maze;
	
	
	/**
	 * Instantiates a new board.
	 */
	public Board(){
		
		

	}

	
	/**
	 * Sets a new maze.
	 *
	 * @param maze the new maze
	 */
	public void setMaze(Item[][] maze){
		this.maze = maze;

	}


	/**
	 * Gets the item, on the line i and column j, form the maze.
	 *
	 * @param p the position to get
	 * @return the item
	 */
	public Item getItem(Position p){
		return maze[p.getLine()][p.getCol()];
	}
	
	/**
	 * Explode.
	 *
	 * @param p the position to explode
	 */
	public void explode(Position p){
		
		
		
	}

}//end Board