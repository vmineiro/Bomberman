package model;

/**
 * This subclass implements a behaviour associated with a state of the Item.
 */
public class ItemInactive extends ItemState {

	public ItemInactive(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	/**
	 * 
	 * @param item
	 */
	public void explode(Item item){

	}

	/**
	 * 
	 * @param item
	 */
	public void pickUp(Item item){

	}

	/**
	 * 
	 * @param item
	 */
	public void openExit(Item item){

	}

	public void update(){

	}
}//end ItemInactive