package model;

// TODO: Auto-generated Javadoc
/**
 * The Class Position.
 */
public class Position {
	
	/** The line. */
	private int line;
	
	/** The col. */
	private int col;

	/**
	 * Instantiates a new position.
	 */
	public Position(){

	}
	
	/**
	 * Constructor
	 * 
	 * @param lin is the line of the new position and col is the column of the new position 
	 */
	public Position(int lin, int col)
	{
		this.line = lin;
		this.col = col;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	public void finalize() throws Throwable {

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
	 * Adds two positions and returns the result
	 */
	public Position add(Position p1, Position p2){
		return new Position(p1.line + p2.line, p1.col + p2.col);
	}
	
}//end Position