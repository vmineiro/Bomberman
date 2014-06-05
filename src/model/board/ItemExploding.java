package model.board;




/**
 * This subclass implements a behaviour associated with a state of the Item.
 */
public class ItemExploding extends ItemState {
	
	
	/**
	 * Instantiates a new item detonating.
	 */
	public ItemExploding(){
		super();
		
	}

	
	/* (non-Javadoc)
	 * @see model.board.ItemState#explode()
	 */
	@Override
	public ItemState explode() {
		return new ItemExploding();
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
		return new ItemInactive();
	}


}//end ItemDetonating