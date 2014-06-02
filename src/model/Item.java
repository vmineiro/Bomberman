package model;

// TODO: Auto-generated Javadoc
/**
 * This class defines the interface of interest to clients and maintains an
 * instance of a ItemState subclass that defines the current state.
 */
public class Item {

	/** The state. */
	private ItemState state;
	
	/** The draw position. */
	private Position drawPosition;
	
	/** The board position. */
	private Position boardPosition;
	
	/** The Animation of the Item. */
	//private Animation animation;
	
	/** The has player. */
	private boolean hasPlayer = false;
	
	/** The has monster alive. */
	private boolean hasMonsterAlive = false;
	
	/** The has bomb. */
	private boolean hasBomb = false;

	/**
	 * Instantiates a new item.
	 */
	public Item(){

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	public void finalize() throws Throwable {

	}

	
	/**
	 * Sets the current state.
	 *
	 * @param state the new current state
	 */
	public void setCurrentState(ItemState state){

	}


	
	/**
	 * Manages the visit by the player.
	 *
	 * @param player the player
	 */
	public void accept(Player player){
		//player->updateBoardPosition()


	}


	/**
	 * Manages the visit by the monster.
	 *
	 * @param monster the monster
	 */
	public void accept(Monster monster){
		//monster->updateBoardPosition()


	}


	/**
	 * Sets the animation to be draw in the game window.
	 */
	public void setAnimation(/*Animation animation*/){

	}
}//end Item