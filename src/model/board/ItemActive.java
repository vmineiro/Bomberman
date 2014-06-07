package model.board;




/**
 * This subclass implements a behaviour associated with a state of the Item.
 */
public class ItemActive extends ItemState {

	
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
	
	
}//end ItemActive