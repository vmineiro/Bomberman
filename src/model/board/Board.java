package model.board;

import java.awt.Graphics;

import model.GameModel;
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
		maze[p.getLine()][p.getCol()].explode();
	}
	
	/**
	 * Get Maze
	 */
	public Item[][] getMaze(){
		return maze;
	}
	
	/**
	 * Draw Game Board
	 */
	public void draw(Graphics g, int width, int height)
	{
		int n = GameModel.getInstance().getBoard().getMaze().length;
		int dstImgWid = width/n;
		int dstImgHei = height/n;

		for(int i=0; i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				getItem(new Position(i, j)).draw(g, i, j, dstImgWid, dstImgHei);			
			}
		}
	}

}//end Board