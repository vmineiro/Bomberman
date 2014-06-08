package model.board;

import java.io.Serializable;


/**
 * This subclass implements a behaviour associated with a state of the Item.
 */
public class ItemInactive implements ItemState,Serializable {	
	
	/**
	 * Instantiates a new item inactive.
	 */
	public ItemInactive(){
		super();

	}

	/**
	 * Explosion provokes transition.
	 *
	 * @return the item state
	 */
	public ItemState explode() {
		return new ItemExploding();
	}

	/**
	 * Pickup provokes transition.
	 *
	 * @return the item state
	 */
	public ItemState pickUp() {
		return this;
	}

	/**
	 * Explosion end provokes transition.
	 *
	 * @return the item state
	 */
	public ItemState explosionEnds() {
		return this;
	}
	
	/**
	 * Checks if item state is hidden.
	 *
	 * @return true if item is hidden
	 */
	public boolean isHidden(){
		return false;
	}
	
	/**
	 * Opens the exit door.
	 *
	 * @return the item state
	 */
	public ItemState openExit(){
		return new ItemActive();
	}


}//end ItemInactive