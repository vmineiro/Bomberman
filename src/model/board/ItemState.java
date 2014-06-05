package model.board;



/**
 * This class defines an interface for encapsulating the behaviour associated with
 * a particular state of the Item.
 */
public abstract class ItemState {
	

	
	
	/**
	 * Explode. Trigger a state change.
	 *
	 * @return the item state
	 */
	public abstract ItemState explode();
	
	
	/**
	 * Explode end. Trigger a state change.
	 *
	 * @return the item state
	 */
	public abstract ItemState explosionEnds();
	
	

	/**
	 * The item (power up item) is visited by the player. Trigger a state change.
	 *
	 * @return the item state
	 */
	public abstract ItemState pickUp();


}//end ItemState