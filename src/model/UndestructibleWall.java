package model;

// TODO: Auto-generated Javadoc
/**
 * The Class UndestructibleWall.
 */
public class UndestructibleWall extends Item {

	/**
	 * Instantiates a new undestructible wall.
	 */
	public UndestructibleWall(){

	}

	/* (non-Javadoc)
	 * @see model.Item#finalize()
	 */
	public void finalize() throws Throwable {
		super.finalize();
	}
	
	/**
	 * Sets the current state.
	 *
	 * @param state the new current state
	 */
	public void setCurrentState(ItemState state){

	}

	/**
	 * Accept.
	 *
	 * @param player the player
	 */
	public void accept(Player player){
		//player->updateBoardPosition()


	}

	/**
	 * Accept.
	 *
	 * @param monster the monster
	 */
	public void accept(Monster monster){
		//monster->updateBoardPosition()


	}

	/**
	 * Sets the animation.
	 */
	public void setAnimation(/*Animation animation*/){

	}
}//end UndestructibleWall