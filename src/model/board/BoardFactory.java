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
	public BoardFactory(int boardSize){

	}

	
	/**
	 * Creates a new ExtraBomb Item and assigns to a random position in the maze.
	 */
	public Item createExtraBomb(){
		return new ExtraBomb();
	}

	/**
	 * Creates a new BombControl Item and assigns to a random position in the maze.
	 */
	public Item createBombControl(){
		return new BombControl();
	}

	/**
	 * Creates a new BombPowerUp Item and assigns to a random position in the maze.
	 */
	public Item createBombPowerUp(){
		return new BombPowerUp();
	}

	/**
	 * Creates a new BoarExit and assigns to a random position in the maze.
	 */
	public Item createBoardExit(){
		return new BoardExit();
	}

	/**
	 * Creates a new BoostSpeed Item and assign to a random position in the maze.
	 */
	public Item createBoostSpeed(){
		return new BoostSpeed();
	}

	/**
	 * Initialize board construction with 'l' lines and 'c' columns.
	 * Creates all the Path item (in hidden state) and the UndestrutibleWall Items.
	 *
	 * @param l the l
	 * @param c the c
	 */
	public Item[][] initializeBoard(int l, int c){
		Item[][] tempMaze = new Item[l][c];
		
		
		
		for (int i = 0; i < l; i++){
			for (int j = 0; j < c; j++){
//				tempMaze[i][j] =
			}
			
		}
		
		return tempMaze;
		
	}

	/**
	 * Toogle path Item state, from hidden to active. 
	 *
	 * @param i the i
	 * @param j the j
	 */
	public void tooglePath(int i, int j){
		this.maze[i][j].setCurrentState(new ItemActive());

	}

	/**
	 * Sets the Item, item, in the position (i,j) of the maze.
	 *
	 * @param i the i
	 * @param j the j
	 * @param item the item
	 */
	public void setItem(int i, int j, Item item){
		this.maze[i][j] = item;
	}
	
	
	
	
	
	
	
}//end BoardFactory