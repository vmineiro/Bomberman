package model.board;


/**
 * This subclass implements a behaviour associated with a state of the Item.
 */
public class ItemHidden implements ItemState {


	/**
	 * Instantiates a new item hidden.
	 */
	public ItemHidden(){
		super();

	}

	public ItemState explode() {
		return new ItemDetonating();
	}

	public ItemState pickUp() {
		return this;
	}


	public ItemState explosionEnds() {
		return this;
	}
	
	/**
	 * Checks if item state is hidden
	 * @return true if item is hidden
	 */
	public boolean isHidden(){
		return true;
	}

	
}

//end ItemHidden