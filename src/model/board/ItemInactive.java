package model.board;


/**
 * This subclass implements a behaviour associated with a state of the Item.
 */
public class ItemInactive implements ItemState {

	/**
	 * Instantiates a new item inactive.
	 */
	public ItemInactive(){
		
		

	}

	/* (non-Javadoc)
	 * @see model.ItemState#finalize()
	 */
	public void finalize() throws Throwable {
		super.finalize();
	}

	@Override
	public ItemState explode() {
		return new ItemExploding();
	}

	@Override
	public ItemState pickUp() {
		return this;
	}


}//end ItemInactive