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

	/* (non-Javadoc)
	 * @see model.board.ItemState#explode()
	 */
	public ItemState explode() {
		return new ItemExploding();
	}
	
	
	/* (non-Javadoc)
	 * @see model.board.ItemState#pickUp()
	 */
	public ItemState pickUp() {
		return this;
	}

	
	/* (non-Javadoc)
	 * @see model.board.ItemState#explosionEnds()
	 */
	public ItemState explosionEnds() {
		return new ItemActive();
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
		return new ItemInactive();
	}

}

//end ItemDetonating