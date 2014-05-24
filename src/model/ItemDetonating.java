package model;


/**
 * This subclass implements a behaviour associated with a state of the Item.
 */
public class ItemDetonating extends ItemState {
	
	/** The count down for detonation end. */
	private int timeOut = 3;

	/**
	 * Instantiates a new item detonating.
	 */
	public ItemDetonating(){

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	public void finalize() throws Throwable {
		super.finalize();
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
}//end ItemDetonating