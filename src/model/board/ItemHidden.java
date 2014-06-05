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
	 * @see model.ItemState#finalize()
	 */
	public void finalize() throws Throwable {
		super.finalize();
	}
	

	@Override
	public ItemState explode() {
		return new ItemDetonating();
	}

	@Override
	public ItemState pickUp() {
		return this;
	}

	@Override
	public ItemState explosionEnds() {
		return this;
	}
	
	
}//end ItemHidden