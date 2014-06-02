package model;


/**
 * This class represents the exit of the maze.
 */
public class BoardExit extends Item {

	/**
	 * Instantiates a new board exit.
	 */
	public BoardExit(){
		
		//super()

	}

	/* (non-Javadoc)
	 * @see model.Item#finalize()
	 */
	public void finalize() throws Throwable {
		super.finalize();
	}
	
	/**
	 * Set a new state of the board exit.
	 * @param state the new state
	 */
	public void setCurrentState(ItemState state){

	}


	/**
	 * Manages the visit by the player
	 * @param player the player visitor
	 */
	@Override
	public void accept(Player player){
		//player->updateBoardPosition()


	}


	/**
	 * Manages the visit by the monster
	 * @param player the monster visitor
	 */
	public void accept(Monster monster){
		//monster->updateBoardPosition()


	}


	/**
	 * Sets a new animation to be draw in the game window, according the Item current state
	 * @param player the player visitor
	 */
	public void setAnimation(/*Animation animation*/){

	}
}//end BoardExit