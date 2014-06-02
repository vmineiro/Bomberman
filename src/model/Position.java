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
	
}//end Position