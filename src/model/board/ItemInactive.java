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
		return this;
	}


}//end ItemInactive