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
	 * @see model.ItemState#finalize()
	 */
	public void finalize() throws Throwable {
		super.finalize();
	}

	
	public ItemState explode() {
		return new ItemExploding();
	}

	
	public ItemState pickUp() {
		return this;
	}

	
	public ItemState explosionEnds() {
		return this;
	}


}//end ItemInactive