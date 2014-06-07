package model.board;



/**
 * The Class ItemDetonating.
 */
public class ItemDetonating implements ItemState {

	/**
	 * Instantiates a new item detonating.
	 */
	public ItemDetonating(){
		super();

	}


	public ItemState explode() {
		return this;
	}


	public ItemState pickUp() {
		return this;
	}

	public ItemState explosionEnds() {
		return new ItemActive();
	}

	/**
	 * Checks if item state is hidden
	 * @return true if item is hidden
	 */
	public boolean isHidden(){
		return false;
	}
	
	/**
	 * Opens the exit door
	 */
	public ItemState openExit(){
		return this;
	}

}
