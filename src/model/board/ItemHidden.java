package model.board;


/**
 * This subclass implements a behaviour associated with a state of the Item.
 */
public class ItemHidden extends ItemState {

	
	/**
	 * Instantiates a new item hidden.
	 */
	public ItemHidden(){
		super();
	
	}

	
	
	/* (non-Javadoc)
	 * @see model.board.ItemState#explode()
	 */
	@Override
	public ItemState explode() {
		return new ItemDetonating();
	}

	
	/* (non-Javadoc)
	 * @see model.board.ItemState#pickUp()
	 */
	@Override
	public ItemState pickUp() {
		return this;
	}

	
	/* (non-Javadoc)
	 * @see model.board.ItemState#explosionEnds()
	 */
	@Override
	public ItemState explosionEnds() {
		return this;
	}
	
	
}//end ItemHidden