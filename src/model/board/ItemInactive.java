package model.board;


/**
 * This subclass implements a behaviour associated with a state of the Item.
 */
public class ItemInactive implements ItemState {	
	
	/**
	 * Instantiates a new item inactive.
	 */
	public ItemInactive(){
		super();

	}

	/**
	 * Explosion provokes transition
	 */
	public ItemState explode() {
		return new ItemExploding();
	}

	/**
	 * Pickup provokes transition
	 */
	public ItemState pickUp() {
		return this;
	}

	/**
	 * Explosion end provokes transition
	 */
	public ItemState explosionEnds() {
		return new ItemActive();
	}
	
	/**
	 * Checks if item state is hidden
	 * @return true if item is hidden
	 */
	public boolean isHidden(){
		return false;
	}
	
	/**
	 * Opens the exit door
	 */
	public ItemState openExit(){
		return this;
	}


}//end ItemInactive