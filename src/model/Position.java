package model;

import java.io.Serializable;


/**
 * The Class Position.
 */
public class Position implements Serializable{
	
	/** The line. */
	private int line;
	
	/** The col. */
	private int col;

	/**
	 * Instantiates a new position.
	 */
	public Position(){}
	
	/**
	 * Constructor.
	 *
	 * @param lin is the line of the new position and col is the column of the new position
	 * @param col the col
	 */
	public Position(int lin, int col)
	{
		this.line = lin;
		this.col = col;
	}
	
	/**
	 * Equals.
	 *
	 * @param p the position
	 * @return true, if successful this position has the same line and column of position p.
	 */
	public boolean equals(Position p) {
		
		if (this.line == p.getLine() && this.col == p.getCol()) return true;
		
		return false;
	}

	/**
	 * Gets the column.
	 *
	 * @return the col
	 */
	public int getCol() {
		return this.col;
	}

	/**
	 * Gets the line.
	 *
	 * @return the line
	 */
	public int getLine() {
		return this.line;
	}
	
	/**
	 * Sets the position.
	 *
	 * @param line the line
	 * @param col the column
	 */
	public void setPosition(int line, int col){
		this.line = line;
		this.col = col;
	}
	
	/**
	 * Adds two positions return a new Position as result.
	 *
	 * @param p1 the p1
	 * @return the position
	 */
	public Position add(Position p1){
		return new Position(line + p1.line, col + p1.col);
	}
	
}//end Position