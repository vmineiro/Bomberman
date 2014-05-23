package model;

/**
 * This class defines an interface for encapsulating the behaviour associated with
 * a particular state of the Item.
 */
public abstract class ItemState {

	public ItemState(){

	}

	public void finalize() throws Throwable {

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
}//end ItemState