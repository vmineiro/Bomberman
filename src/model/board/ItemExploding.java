package model.board;

import java.io.Serializable;

/**
 * This subclass implements a behaviour associated with a state of the Item.
 */
public class ItemExploding implements ItemState, Serializable {
	
	
	/**
	 * Instantiates a new item detonating.
	 */
	public ItemExploding(){
		super();
		
	}

	public ItemState explode() {
		return new ItemExploding();
	}
	
	
	public ItemState pickUp() {
		return this;
	}

	
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

}

//end ItemDetonating