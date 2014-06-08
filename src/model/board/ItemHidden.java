package model.board;

import java.io.Serializable;


/**
 * This subclass implements a behaviour associated with a state of the Item.
 */
public class ItemHidden implements ItemState, Serializable {

	/**
	 * Instantiates a new item hidden.
	 */
	public ItemHidden(){
		super();

	}

	/* (non-Javadoc)
	 * @see model.board.ItemState#explode()
	 */
	public ItemState explode() {
		return new ItemDetonating();
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
		return this;
	}
	
	/**
	 * Checks if item state is hidden.
	 *
	 * @return true if item is hidden
	 */
	public boolean isHidden(){
		return true;
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

//end ItemHidden