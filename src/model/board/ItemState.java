package model.board;

/**
 * This class defines an interface for encapsulating the behaviour associated with
 * a particular state of the Item.
 */
public interface ItemState {
		
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
	
	/**
	 * Checks if item state is hidden
	 * @return true if item is hidden
	 */
	public abstract boolean isHidden();
}

//end ItemState