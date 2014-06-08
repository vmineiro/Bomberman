package model.board;

import java.awt.Graphics;
import java.io.Serializable;

import model.GameModel;
import model.Position;

/**
 * This class represents the game board.
 */
@SuppressWarnings("serial")
public class Board implements Serializable{
	
	/** The maze. */
	private Item[][] maze;
	
	/**  The exit board position. */
	private Position exitPos;
	
	/**
	 * Instantiates a new board.
	 */
	public Board(){}

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
	 * Get Maze.
	 *
	 * @return the maze
	 */
	public Item[][] getMaze(){
		return maze;
	}
	
	/**
	 * Return the exit of the board.
	 *
	 * @return the exit pos
	 */
	public Position getExitPos(){
		return exitPos;
	}
	
	/**
	 *  
	 * Saves the position of exit.
	 *
	 * @param exit the new exit pos
	 */
	public void setExitPos(Position exit){
		this.exitPos = exit;
	}
	
	/**
	 * Return the exit item.
	 *
	 * @return the exit item
	 */
	public Item getExitItem(){
		return this.getItem(this.getExitPos());
	}
	
	/**
	 * Draw Game Board.
	 *
	 * @param g the g
	 * @param width the width
	 * @param height the height
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