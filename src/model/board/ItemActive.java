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
	

	/* (non-Javadoc)
	 * @see model.board.ItemState#explode()
	 */
	public ItemState explode(){
		return new ItemExploding();
	}
	

	/* (non-Javadoc)
	 * @see model.board.ItemState#pickUp()
	 */
	@Override
	public ItemState pickUp() {
		return new ItemInactive();
	}

	
	/* (non-Javadoc)
	 * @see model.board.ItemState#explosionEnds()
	 */
	@Override
	public ItemState explosionEnds() {
		return this;
	}
	
	
}//end ItemActive