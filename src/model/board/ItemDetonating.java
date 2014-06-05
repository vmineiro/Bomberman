package model.board;



/**
 * The Class ItemDetonating.
 */
public class ItemDetonating extends ItemState {



	
	/**
	 * Instantiates a new item detonating.
	 */
	public ItemDetonating(){
		super();
	
	}


	/* (non-Javadoc)
	 * @see model.board.ItemState#explode()
	 */
	@Override
	public ItemState explode() {
		return this;
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
		return new ItemActive();
	}
	

}
