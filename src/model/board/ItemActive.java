package model.board;




/**
 * This subclass implements a behaviour associated with a state of the Item.
 */
public class ItemActive implements ItemState {

	
	/**
	 * Instantiates a new item active.
	 */
	public ItemActive(){
		super();

	}

	/**
	 * Explosion provokes transition
	 */
	public ItemState explode(){
		return new ItemExploding();
	}

	/**
	 * Pickup provokes transition
	 */
	public ItemState pickUp() {
		return new ItemInactive();
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
	
	
}//end ItemActive