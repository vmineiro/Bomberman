package model.board;


/**
 * A factory for creating Board objects.
 */
public class BoardFactory {

	
	/** The maze. */
	private Item[][] maze;

	/**
	 * Instantiates a new board factory.
	 */
	public BoardFactory(){

	}

	
	/**
	 * Creates a new ExtraBomb Item and assigns to a random position in the maze.
	 */
	public void createExtraBomb(){

	}

	/**
	 * Creates a new BombControl Item and assigns to a random position in the maze.
	 */
	public void createBombControl(){

	}

	/**
	 * Creates a new BombPowerUp Item and assigns to a random position in the maze.
	 */
	public void createBombPowerUp(){

	}

	/**
	 * Creates a new BoarExit and assigns to a random position in the maze.
	 */
	public void createBoardExit(){

	}

	/**
	 * Creates a new BoostSpeed Item and assign to a random position in the maze.
	 */
	public void createBoostSpeed(){

	}

	/**
	 * Initialize board construction with 'l' lines and 'c' columns.
	 * Creates all the Path item (in hidden state) and the UndestrutibleWall Items.
	 *
	 * @param l the l
	 * @param c the c
	 */
	public void initializeBoard(int l, int c){

	}

	/**
	 * Toogle path Item state, from hidden to active. 
	 *
	 * @param i the i
	 * @param j the j
	 */
	public void tooglePath(int i, int j){

	}

	/**
	 * Sets the Item, item, in the position (i,j) of the maze.
	 *
	 * @param i the i
	 * @param j the j
	 * @param item the item
	 */
	public void setItem(int i, int j, Item item){

	}
}//end BoardFactory