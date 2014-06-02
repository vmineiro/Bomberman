package model.board;


/**
 * This class defines an interface for encapsulating the behaviour associated with
 * a particular state of the Item.
 */
public abstract class ItemState {

	/**
	 * Instantiates a new item state.
	 */
	public ItemState(){

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	public void finalize() throws Throwable {

	}
	
	/**
	 * Explode. Trigger a state change.
	 *
	 * @param item the item
	 */
	public void explode(Item item){

	}

	/**
	 * The item (power up item) is visited by the player. Trigger a state change.
	 * 
	 * @param item
	 */
	public void pickUp(Item item){

	}

	/**
	 * Change the BoardExit item to Active.
	 * 
	 * @param item
	 */
	public void openExit(Item item){

	}

	/**
	 * Updates the state of the item. Applies to ItemDetonating.
	 */
	public void update(){

	}
}//end ItemState