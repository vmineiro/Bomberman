package model.board;


/**
 * This subclass implements a behaviour associated with a state of the Item.
 */
public class ItemInactive extends ItemState {	
	
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


}//end ItemInactive