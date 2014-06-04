package model.board;


/**
 * This subclass implements a behaviour associated with a state of the Item.
 */
public class ItemHidden implements ItemState {

	/**
	 * Instantiates a new item hidden.
	 */
	public ItemHidden(){
	
	}

	/* (non-Javadoc)
	 * @see model.ItemState#finalize()
	 */
	public void finalize() throws Throwable {
		super.finalize();
	}
	

	@Override
	public ItemState explode() {
		// TODO Auto-generated method stub
		return new ItemDetonating();
	}

	@Override
	public ItemState pickUp() {
		// TODO Auto-generated method stub
		return this;
	}
}//end ItemHidden